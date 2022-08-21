package ru.coolhabit.marvelheroes.heroes.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.hero.HeroDetail
import ru.marvelheroes.usecases.HeroesUseCase
import javax.inject.Inject

class HeroDetailsViewModel @Inject constructor(
    private val useCase: HeroesUseCase
) : ViewModel() {

    private val _loadDetail = MutableSharedFlow<HeroDetail>()
    val loadDetail = _loadDetail.asSharedFlow()

    fun initDetail(id: String) {
        viewModelScope.launch {
            _loadDetail.emit(useCase.loadHeroDetails(id))
        }
    }
}
