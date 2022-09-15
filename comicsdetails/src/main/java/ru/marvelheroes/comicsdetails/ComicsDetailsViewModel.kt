package ru.marvelheroes.comicsdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.comics.ComicDetail
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.extensions.toComics
import ru.marvelheroes.usecases.ComicsUseCase
import javax.inject.Inject

class ComicsDetailsViewModel @Inject constructor(
    private val useCase: ComicsUseCase
) : ViewModel() {

    var comicInfo: Comics? = null

    private val _loadDetail = MutableSharedFlow<ComicDetail>()
    val loadDetail = _loadDetail.asSharedFlow()

    fun initDetail(id: String) {
        viewModelScope.launch {
            val comicDetails = useCase.loadComicsDetails(id)
            comicInfo = comicDetails.first().toComics()
            _loadDetail.emit(comicDetails.last())
        }
    }
}
