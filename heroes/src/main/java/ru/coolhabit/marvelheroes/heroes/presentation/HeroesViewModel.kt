package ru.coolhabit.marvelheroes.heroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.HeroesUseCase
import javax.inject.Inject

class HeroesViewModel @Inject constructor(
    private val useCase: HeroesUseCase,
) : ViewModel() {

    private val _loadHeroes: StateFlow<PagingData<Hero>> =
        Pager(PagingConfig(pageSize = NETWORK_PAGE_SIZE)) {
            useCase.loadHeroesList()
        }.flow
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    val loadHeroes: StateFlow<PagingData<Hero>>
        get() = _loadHeroes

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

    suspend fun getFavouriteHeroes(): List<Hero> {
        return useCase.getFavouriteHeroes()
    }
}
