package ru.coolhabit.marvelheroes.heroes.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.FragmentHeroesBinding
import ru.marvelheroes.presentation.adapter.ItemDecoration
import javax.inject.Inject

class HeroesFragment : Fragment(R.layout.fragment_heroes) {

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HeroesViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentHeroesBinding

    protected val mainActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity

    @Inject
    lateinit var heroAdapter: HeroAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
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
        heroAdapter.submitList(viewModel.loadHeroList())
    }
}
