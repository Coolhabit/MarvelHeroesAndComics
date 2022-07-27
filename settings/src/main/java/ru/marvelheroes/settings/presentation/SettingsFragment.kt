package ru.marvelheroes.settings.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import ru.marvelheroes.settings.R
import ru.marvelheroes.settings.databinding.FragmentSettingsBinding
import javax.inject.Inject

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(SettingsViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentSettingsBinding

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
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
