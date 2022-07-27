package ru.marvelheroes.comics.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import ru.marvelheroes.comics.R
import ru.marvelheroes.comics.databinding.FragmentComicsBinding
import javax.inject.Inject

class ComicsFragment : Fragment(R.layout.fragment_comics) {

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(ComicsViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentComicsBinding

    protected val mainActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }
}