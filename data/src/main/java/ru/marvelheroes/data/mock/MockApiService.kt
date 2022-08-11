package ru.marvelheroes.data.mock

import androidx.paging.PagingSource
import kotlinx.coroutines.delay
import ru.marvelheroes.core.api.IHeroesApiService
import ru.marvelheroes.entities.dto.hero.Hero

class MockApiService : IHeroesApiService {
    //
//    override suspend fun loadHeroesList(): List<Hero> {
//        delay(1000)
//        val result = mutableListOf<Hero>()
//        result.add(
//            Hero(
//                heroId = "1",
//                heroName = "Doctor Strange",
//                heroPoster = "file:///android_asset/doctor_strange.jpg"
//            )
//        )
//        result.add(
//            Hero(
//                heroId = "2",
//                heroName = "Iron Man",
//                heroPoster = "file:///android_asset/iron_man.jpg"
//            )
//        )
//        result.add(
//            Hero(
//                heroId = "3",
//                heroName = "Thor",
//                heroPoster = "file:///android_asset/thor.jpg"
//            )
//        )
//        return result
//    }
    override fun loadHeroesList(): PagingSource<Int, Hero> {
        TODO("Not yet implemented")
    }

}
