package ru.coolhabit.marvelheroes.heroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.HeroesUseCase
import javax.inject.Inject

class HeroesViewModel @Inject constructor(
    private val useCase: HeroesUseCase,
) : ViewModel() {

    private val _load = MutableSharedFlow<List<Hero>>()
    val load = _load.asSharedFlow()

    fun loadHeroList() {
        viewModelScope.launch {
            _load.emit(useCase.loadHeroesList())
        }
    }
}
