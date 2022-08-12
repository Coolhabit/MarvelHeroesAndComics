package ru.marvelheroes.myavengers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.MyAvengersUseCase
import javax.inject.Inject

class MyAvengersViewModel @Inject constructor(
    private val useCase: MyAvengersUseCase,
) : ViewModel() {

    private val _loadFavHeroes = MutableSharedFlow<List<Hero>>()
    val loadFavHeroes = _loadFavHeroes.asSharedFlow()

    fun initLoad() {
        viewModelScope.launch {
            _loadFavHeroes.emit(useCase.getFavouriteHeroes())
        }
    }

    fun addToFavourite(hero: Hero) {
        viewModelScope.launch {
            useCase.addHeroToFavourite(hero)
        }
    }

    fun removeFromFavourite(hero: Hero) {
        viewModelScope.launch {
            useCase.removeHeroFromFavourite(hero)
        }
    }
}