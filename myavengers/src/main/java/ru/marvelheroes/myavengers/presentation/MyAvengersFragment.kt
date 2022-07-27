package ru.marvelheroes.myavengers.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import ru.marvelheroes.myavengers.R
import ru.marvelheroes.myavengers.databinding.FragmentMyAvengersBinding
import javax.inject.Inject

class MyAvengersFragment : Fragment(R.layout.fragment_my_avengers) {

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MyAvengersViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentMyAvengersBinding

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
        binding = FragmentMyAvengersBinding.inflate(inflater, container, false)
        return binding.root
    }
}