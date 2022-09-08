package ru.marvelheroes.comicsdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.comics.ComicDetail
import ru.marvelheroes.usecases.ComicsUseCase
import javax.inject.Inject

class ComicsDetailsViewModel @Inject constructor(
    private val useCase: ComicsUseCase
) : ViewModel() {

    private val _loadDetail = MutableSharedFlow<ComicDetail>()
    val loadDetail = _loadDetail.asSharedFlow()

    fun initDetail(id: String) {
        viewModelScope.launch {
            val comicDetails = useCase.loadComicsDetails(id)
            _loadDetail.emit(comicDetails.last())
        }
    }
}
