package ru.marvelheroes.usecases

import androidx.paging.PagingSource
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero
import javax.inject.Inject

class HeroesUseCase @Inject constructor(
    private val api: IHeroesApiService,
) {
    fun loadHeroesList(): PagingSource<Int, Hero> {
        return api.loadHeroesList()
    }
}
