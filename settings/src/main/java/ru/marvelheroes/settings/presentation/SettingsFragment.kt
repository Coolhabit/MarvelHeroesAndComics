package ru.marvelheroes.settings.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.marvelheroes.presentation.base.BaseFragment
import ru.marvelheroes.settings.R
import ru.marvelheroes.settings.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private val viewModel by viewModels<SettingsViewModel>()
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.termsOfUse.webTitle.text = context?.resources?.getString(R.string.terms_of_use_text)
        binding.marvelShop.webTitle.text = context?.resources?.getString(R.string.marvel_shop_text)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            binding.dayNightSwitchBlock.themeSwitchBtn.isChecked = viewModel.getDayNightCheck()
        }

        binding.dayNightSwitchBlock.themeSwitchBtn.setOnCheckedChangeListener { _, isChecked ->
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.saveDayNightCheck(isChecked)
            }
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        navigateToUrl(binding.termsOfUse.root, R.string.terms_link)

        navigateToUrl(binding.marvelShop.root, R.string.shop_link)
    }

    private fun navigateToUrl(view: View, string: Int) {
        view.setOnClickListener {
            val url = context?.resources?.getString(string)
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
