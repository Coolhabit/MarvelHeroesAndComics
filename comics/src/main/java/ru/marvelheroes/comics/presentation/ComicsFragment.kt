package ru.marvelheroes.comics.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.marvelheroes.comics.R
import ru.marvelheroes.comics.databinding.FragmentComicsBinding
import ru.marvelheroes.comics.presentation.adapter.ComicsAdapter
import ru.marvelheroes.presentation.adapter.ItemDecoration
import ru.marvelheroes.presentation.base.BaseFragment
import javax.inject.Inject

class ComicsFragment : BaseFragment(R.layout.fragment_comics) {

    private val viewModel by viewModels<ComicsViewModel>()
    private lateinit var binding: FragmentComicsBinding

    @Inject
    lateinit var comicsAdapter: ComicsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        comicsAdapter.addLoadStateListener { state ->
            binding.apply {
                rvComicsList.isVisible = state.refresh != LoadState.Loading
                overallProgress.isVisible = state.refresh == LoadState.Loading
            }
        }

        binding.rvComicsList.apply {
            adapter = comicsAdapter
            itemAnimator = null
            addItemDecoration(
                ItemDecoration(
                    context,
                    top = R.dimen.spacing_8,
                    right = R.dimen.spacing_8,
                    left = R.dimen.spacing_8,
                    bottom = R.dimen.spacing_8,
                )
            )
            layoutManager = GridLayoutManager(
                requireContext(),
                context.resources.getInteger(R.integer.grid_span)
            )
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                comicsAdapter.loadStateFlow.collect {
                    binding.prependProgress.isVisible = it.prepend is LoadState.Loading
                    binding.appendProgress.isVisible = it.append is LoadState.Loading
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.loadComics.collectLatest {
                comicsAdapter.submitData(it)
            }
        }

        comicsToast()
    }

    private fun comicsToast() {
        comicsAdapter.tapHandler = {
            Toast.makeText(
                context, requireContext().resources.getString(R.string.comic_toast, it?.comicsName),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
