package ru.coolhabit.marvelheroes.heroes.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.HeroesUseCase
import javax.inject.Inject

class HeroesViewModel @Inject constructor(
    private val useCase: HeroesUseCase,
) : ViewModel() {

    val loadHeroes = useCase.loadHeroesList().cachedIn(viewModelScope)

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
