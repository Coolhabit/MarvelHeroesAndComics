package ru.coolhabit.marvelheroes.heroes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.FragmentHeroesBinding
import ru.coolhabit.marvelheroes.heroes.presentation.adapter.HeroAdapter
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
        viewModel.loadHeroList()
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

        binding.rvHeroList.apply {
            adapter = heroAdapter
            itemAnimator = null
            addItemDecoration(
                ItemDecoration(
                    context,
                    top = ru.marvelheroes.R.dimen.spacing_20,
                    right = ru.marvelheroes.R.dimen.spacing_20,
                    left = ru.marvelheroes.R.dimen.spacing_20,
                    bottom = ru.marvelheroes.R.dimen.spacing_20,
                )
            )
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.load.collect {
                heroAdapter.submitList(it)
            }
        }

        submitHeroList()

        heroToast()
    }

    private fun heroToast() {
        heroAdapter.tapHandler = {
            Toast.makeText(
                context,
                "Этого героя зовут ${it.heroName}!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun submitHeroList() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.load.collect {
                heroAdapter.submitList(it)
            }
        }
    }
}
