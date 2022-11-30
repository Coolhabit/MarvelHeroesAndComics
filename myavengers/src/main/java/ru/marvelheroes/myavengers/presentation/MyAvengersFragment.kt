package ru.marvelheroes.myavengers.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.marvelheroes.myavengers.R
import ru.marvelheroes.myavengers.databinding.FragmentMyAvengersBinding
import ru.marvelheroes.myavengers.presentation.adapter.MyAvengersAdapter
import ru.marvelheroes.presentation.adapter.ItemDecoration
import ru.marvelheroes.presentation.base.BaseFragment
import javax.inject.Inject

class MyAvengersFragment : BaseFragment(R.layout.fragment_my_avengers) {

    private val viewModel by viewModels<MyAvengersViewModel>()
    private lateinit var binding: FragmentMyAvengersBinding

    @Inject
    lateinit var avengersAdapter: MyAvengersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyAvengersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMyAvengers.apply {
            adapter = avengersAdapter
            itemAnimator = null
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                ItemDecoration(
                    context,
                    R.dimen.size_8,
                    R.dimen.size_8,
                    R.dimen.size_8,
                    R.dimen.size_8
                )
            )
        }

        viewModel.getFavouriteHeroes().observe(viewLifecycleOwner) {
            avengersAdapter.submitList(it)
        }

        avengersAdapter.onDeleteClick = {
            viewModel.removeFromFavourite(it)
        }

        avengersAdapter.tapHandler = {
            val directions = MyAvengersFragmentDirections.openHeroDetails(it.heroId)
            findNavController().navigate(directions)
        }
    }
}
