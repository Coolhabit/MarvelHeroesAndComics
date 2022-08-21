package ru.coolhabit.marvelheroes.heroes.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.flow.collectLatest
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.FragmentHeroDetailsBinding
import ru.marvelheroes.extensions.load
import ru.marvelheroes.presentation.base.BaseFragment

class HeroDetailsFragment : BaseFragment(R.layout.fragment_hero_details) {

    private val viewModel by viewModels<HeroDetailsViewModel>()
    private lateinit var binding: FragmentHeroDetailsBinding

    private val args by navArgs<HeroDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initDetail(args.heroId)
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

        bindHero()
    }

    private fun bindHero() {
        lifecycleScope.launchWhenStarted {
            viewModel.loadDetail.collectLatest {
                with(binding) {
                    poster.load(it.hero.heroPoster)
                    title.text = it.hero.heroName
                    description.text = it.description
                }
            }
        }
    }
}
