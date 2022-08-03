package ru.marvelheroes.comics.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.marvelheroes.comics.R
import ru.marvelheroes.comics.databinding.FragmentComicsBinding
import ru.marvelheroes.presentation.base.BaseFragment

class ComicsFragment : BaseFragment(R.layout.fragment_comics) {

    private val viewModel by viewModels<ComicsViewModel>()
    private lateinit var binding: FragmentComicsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
