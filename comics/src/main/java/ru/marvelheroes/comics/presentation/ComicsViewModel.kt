package ru.marvelheroes.comics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import ru.marvelheroes.entities.dto.comics.Comics
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE
import ru.marvelheroes.usecases.ComicsUseCase
import javax.inject.Inject

class ComicsViewModel @Inject constructor(
    private val useCase: ComicsUseCase,
) : ViewModel() {

    private val _loadComics: StateFlow<PagingData<Comics>> =
        Pager(PagingConfig(pageSize = NETWORK_PAGE_SIZE)) {
            useCase.loadComicsList()
        }.flow
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    val loadComics: StateFlow<PagingData<Comics>>
        get() = _loadComics
}
