package ru.marvelheroes.comicsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import ru.marvelheroes.comicsdetails.adapter.ComicImagesAdapter
import ru.marvelheroes.comicsdetails.databinding.FragmentComicsDetailsBinding
import ru.marvelheroes.comicsdetails.notifications.ComicsNotificationHelper
import ru.marvelheroes.extensions.load
import ru.marvelheroes.presentation.adapter.ItemDecoration
import ru.marvelheroes.presentation.base.BaseFragment
import javax.inject.Inject

class ComicsDetailsFragment : BaseFragment(R.layout.fragment_comics_details) {

    private val viewModel by viewModels<ComicsDetailsViewModel>()
    private lateinit var binding: FragmentComicsDetailsBinding
    private val args by navArgs<ComicsDetailsFragmentArgs>()

    @Inject
    lateinit var imagesAdapter: ComicImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initDetail(args.comicId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvComicImages.apply {
            adapter = imagesAdapter
            itemAnimator = null
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(
                ItemDecoration(
                    context,
                    R.dimen.spacing_8,
                    R.dimen.spacing_8,
                    R.dimen.spacing_8,
                    R.dimen.spacing_8,
                )
            )
        }

        viewModel.apply {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                loadDetail.collect {
                    imagesAdapter.submitList(it.comicImages)
                    with(binding) {
                        comicPoster.load(it.comicPoster)
                        title.text = it.comicName
                        description.text = it.comicDescription
                    }
                }
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.watch_later -> {
                    ComicsNotificationHelper.createNotification(requireContext(), viewModel.comicInfo, mainActivity)
                    true
                }
                else -> false
            }
        }
    }
}
