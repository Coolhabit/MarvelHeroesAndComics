package ru.marvelheroes.herodetails

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.ibrahimyilmaz.kiel.adapterOf
import ru.marvelheroes.herodetails.adapter.herodetail.HeroDetailSectionViewHolder
import ru.marvelheroes.herodetails.adapter.series.SeriesSectionViewHolder
import ru.marvelheroes.herodetails.databinding.FragmentHeroDetailsBinding
import ru.marvelheroes.presentation.adapter.IAdapterItemProvider
import ru.marvelheroes.presentation.adapter.IClickCommand
import ru.marvelheroes.presentation.adapter.IHeroDetailSection
import ru.marvelheroes.presentation.base.BaseFragment

const val MILLIS = 1000
const val QUALITY = 100

class HeroDetailsFragment : BaseFragment(R.layout.fragment_hero_details),
    IAdapterItemProvider<IHeroDetailSection> {

    private val viewModel by viewModels<HeroDetailsViewModel>()
    private lateinit var binding: FragmentHeroDetailsBinding

    private val args by navArgs<HeroDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initDetail(args.heroId)
    }

    private val compositeAdapter = adapterOf<IHeroDetailSection> {
        diff(
            areContentsTheSame = { old, new -> old == new },
            areItemsTheSame = { old, new -> old === new },
        )
        register(
            layoutResource = HeroDetailSectionViewHolder.ID,
            viewHolder = ::HeroDetailSectionViewHolder,
            onViewHolderCreated = { holder ->
                holder.init(this@HeroDetailsFragment, ::handleCommands)
            }
        )
        register(
            layoutResource = SeriesSectionViewHolder.ID,
            viewHolder = ::SeriesSectionViewHolder,
            onViewHolderCreated = { holder ->
                holder.init(this@HeroDetailsFragment, ::handleCommands)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHeroDetails.apply {
            adapter = compositeAdapter
            itemAnimator = null
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        viewModel.apply {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                loadDetail.collect {
                    compositeAdapter.submitList(it)
                }
            }
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.share_hero_info -> {
                    heroShare()
                    true
                }
                R.id.save_image -> {
                    saveImage()
                    true
                }
                else -> false
            }
        }
    }

    private fun saveImage() {
        if (!checkPermission()) {
            requestPermission()
            return
        }

        lifecycleScope.launch {
            val job = lifecycleScope.async {
                withContext(Dispatchers.IO) {
                    viewModel.loadWallpaper(viewModel.heroInfo?.heroPoster)
                }
            }
            saveToGallery(job.await())

            showGallerySnackbar()
        }
    }

    private fun heroShare() {
        val intent = Intent()
        val heroName = viewModel.heroInfo?.heroName
        val stringShare = context?.getString(R.string.hero_toast, heroName)
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, stringShare)
        intent.type = context?.resources?.getString(R.string.intent_type_text)
        startActivity(Intent.createChooser(intent, context?.resources?.getString(R.string.share_to)))
    }

    override fun getAdapterItem(position: Int): IHeroDetailSection {
        return compositeAdapter.currentList[position]
    }

    private fun handleCommands(command: IClickCommand<*>) {
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED
    }

    //Запрашиваем разрешение
    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
    }

    private fun saveToGallery(bitmap: Bitmap) {
        //Проверяем версию системы
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            //Создаем объект для передачи данных
            val contentValues = ContentValues().apply {
                //Составляем информацию для файла (имя, тип, дата создания, куда сохранять и т.д.)
                put(MediaStore.Images.Media.TITLE, viewModel.heroInfo?.heroName)
                put(
                    MediaStore.Images.Media.DISPLAY_NAME,
                    viewModel.heroInfo?.heroName
                )
                put(MediaStore.Images.Media.MIME_TYPE, context?.resources?.getString(R.string.image_myme))
                put(
                    MediaStore.Images.Media.DATE_ADDED,
                    System.currentTimeMillis() / MILLIS
                )
                put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis())
                put(MediaStore.Images.Media.RELATIVE_PATH, context?.resources?.getString(R.string.image_path))
            }
            //Получаем ссылку на объект Content resolver, который помогает передавать информацию из приложения вовне
            val contentResolver = requireActivity().contentResolver
            val uri = contentResolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
            //Открываем канал для записи на диск
            val outputStream = uri?.let { contentResolver.openOutputStream(it) }
            //Передаем нашу картинку, может сделать компрессию
            bitmap.compress(Bitmap.CompressFormat.JPEG, QUALITY, outputStream)
            //Закрываем поток
            outputStream?.close()
        } else {
            //То же, но для более старых версий ОС
            @Suppress("DEPRECATION")
            MediaStore.Images.Media.insertImage(
                requireActivity().contentResolver,
                bitmap,
                viewModel.heroInfo?.heroName,
                viewModel.heroInfo?.heroName
            )
        }
    }

    private fun showGallerySnackbar() {
        Snackbar.make(
            binding.root,
            R.string.downloaded_to_gallery,
            Snackbar.LENGTH_LONG
        )
            .setAction(R.string.open) {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.type = context?.resources?.getString(R.string.intent_type_image)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            .show()
    }
}
