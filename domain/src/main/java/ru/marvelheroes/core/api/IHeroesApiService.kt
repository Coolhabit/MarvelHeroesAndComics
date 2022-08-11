package ru.marvelheroes.core.api

import androidx.paging.PagingSource
import ru.marvelheroes.entities.dto.hero.Hero

interface IHeroesApiService {

    fun loadHeroesList(): PagingSource<Int, Hero>
}
