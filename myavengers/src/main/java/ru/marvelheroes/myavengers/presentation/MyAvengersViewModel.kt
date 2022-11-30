package ru.marvelheroes.myavengers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.MyAvengersUseCase
import javax.inject.Inject

class MyAvengersViewModel @Inject constructor(
    private val useCase: MyAvengersUseCase,
) : ViewModel() {

    fun getFavouriteHeroes() = useCase.getFavouriteHeroes().asLiveData()

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
