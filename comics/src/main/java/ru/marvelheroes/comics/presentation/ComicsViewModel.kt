package ru.marvelheroes.comics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import ru.marvelheroes.usecases.ComicsUseCase
import javax.inject.Inject

class ComicsViewModel @Inject constructor(
    private val useCase: ComicsUseCase,
) : ViewModel() {

    val loadSeries = useCase.loadComicsList().cachedIn(viewModelScope)
}
