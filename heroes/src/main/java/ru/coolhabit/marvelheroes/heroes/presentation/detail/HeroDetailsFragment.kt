package ru.coolhabit.marvelheroes.heroes.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import me.ibrahimyilmaz.kiel.adapterOf
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.FragmentHeroDetailsBinding
import ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.herodetail.HeroDetailSectionViewHolder
import ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.series.SeriesSectionViewHolder
import ru.marvelheroes.presentation.adapter.IAdapterItemProvider
import ru.marvelheroes.presentation.adapter.IClickCommand
import ru.marvelheroes.presentation.adapter.IHeroDetailSection
import ru.marvelheroes.presentation.base.BaseFragment

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
    }

    override fun getAdapterItem(position: Int): IHeroDetailSection {
        return compositeAdapter.currentList[position]
    }

    private fun handleCommands(command: IClickCommand<*>) {

    }
}
