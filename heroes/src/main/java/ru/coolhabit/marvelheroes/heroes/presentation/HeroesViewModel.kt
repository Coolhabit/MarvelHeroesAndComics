package ru.coolhabit.marvelheroes.heroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.HeroesUseCase
import javax.inject.Inject

class HeroesViewModel @Inject constructor(
    private val useCase: HeroesUseCase,
) : ViewModel() {

    private val _loadHeroes: Flow<PagingData<Hero>> =
        Pager(PagingConfig(pageSize = NETWORK_PAGE_SIZE)) {
            useCase.loadHeroesList()
        }.flow
            .cachedIn(viewModelScope)

    val loadHeroes: Flow<PagingData<Hero>>
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
