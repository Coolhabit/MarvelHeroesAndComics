package ru.coolhabit.marvelheroes.heroes.presentation

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

    private val _loadHeroes = useCase.loadHeroesList().cachedIn(viewModelScope)
    val loadHeroes: Flow<PagingData<Hero>>
        get() = _loadHeroes

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
