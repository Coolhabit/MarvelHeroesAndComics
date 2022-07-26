package ru.coolhabit.marvelheroes.heroes.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.FragmentHeroesBinding
import ru.coolhabit.marvelheroes.heroes.presentation.base.adapter.HeroAdapter
import ru.marvelheroes.presentation.adapter.ItemDecoration
import ru.marvelheroes.presentation.base.BaseFragment
import javax.inject.Inject

class HeroesFragment : BaseFragment(R.layout.fragment_heroes) {

    private val viewModel by viewModels<HeroesViewModel>()
    private lateinit var binding: FragmentHeroesBinding

    @Inject
    lateinit var heroAdapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initContent(null)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroAdapter.addLoadStateListener { state ->
            binding.apply {
                rvHeroList.isVisible = state.refresh != LoadState.Loading
                overallProgress.isVisible = state.refresh == LoadState.Loading
            }
        }

        binding.rvHeroList.apply {
            adapter = heroAdapter
            itemAnimator = null
            addItemDecoration(
                ItemDecoration(
                    context,
                    top = R.dimen.spacing_12,
                    right = R.dimen.spacing_20,
                    left = R.dimen.spacing_20,
                    bottom = R.dimen.spacing_8,
                )
            )
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                heroAdapter.loadStateFlow.collect {
                    binding.prependProgress.isVisible = it.prepend is LoadState.Loading
                    binding.appendProgress.isVisible = it.append is LoadState.Loading
                }
            }
        }

        viewModel.getFavouriteHeroes().observe(viewLifecycleOwner) {
            heroAdapter.updateFavourites(it)
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loadHeroes.collectLatest {
                heroAdapter.submitData(it)
            }
        }

        heroAdapter.onFavClick = { hero ->
            val favHero = heroAdapter.favourites.find { it.heroId == hero.heroId }
            if (favHero != null) {
                viewModel.removeFromFavourite(hero)
            } else {
                viewModel.addToFavourite(hero)
            }
        }

        binding.searchBlock.apply {
            searchInput.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    viewModel.performSearch(searchInput.text.toString())
                    updateUI()
                    true
                } else {
                    false
                }
            }

            searchInputLayout.setEndIconOnClickListener {
                searchInput.text?.clear()
                viewModel.initContent(null)
                updateUI()
            }
        }

        heroToast()
    }

    private fun heroToast() {
        heroAdapter.tapHandler = {
            val directions = HeroesFragmentDirections.openHeroDetails(it?.heroId.toString())
            findNavController().navigate(directions)
        }
    }

    private fun updateUI() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadHeroes.collectLatest {
                heroAdapter.submitData(it)
            }
        }
    }
}
