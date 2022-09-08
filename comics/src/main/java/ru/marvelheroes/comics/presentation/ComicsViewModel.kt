package ru.marvelheroes.comics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.usecases.ComicsUseCase
import javax.inject.Inject

class ComicsViewModel @Inject constructor(
    private val useCase: ComicsUseCase,
) : ViewModel() {

    lateinit var loadSeries: Flow<PagingData<Series>>

    var prevQuery: String? = null

    fun initContent(query: String?) {
        loadSeries = useCase.loadComicsList(query).cachedIn(viewModelScope)
    }

    fun performSearch(query: String?) {
        if (prevQuery == query) {
            return
        }

        prevQuery = query
        initContent(query)
    }
}
