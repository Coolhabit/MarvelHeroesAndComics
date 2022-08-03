package ru.marvelheroes.myavengers.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.marvelheroes.myavengers.R
import ru.marvelheroes.myavengers.databinding.FragmentMyAvengersBinding
import ru.marvelheroes.presentation.base.BaseFragment

class MyAvengersFragment : BaseFragment(R.layout.fragment_my_avengers) {

    private val viewModel by viewModels<MyAvengersViewModel>()
    private lateinit var binding: FragmentMyAvengersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyAvengersBinding.inflate(inflater, container, false)
        return binding.root
    }
}
