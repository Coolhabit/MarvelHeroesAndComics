package ru.coolhabit.marvelheroes.heroes.presentation

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HeroesViewModel @Inject constructor() : ViewModel() {

    fun loadHeroList(): List<Hero> {
        return mutableListOf(
            Hero(
                heroId = "1",
                heroName = "Doctor Strange",
                heroPoster = "file:///android_asset/doctor_strange.jpg"
            ),
            Hero(
                heroId = "2",
                heroName = "Iron Man",
                heroPoster = "file:///android_asset/iron_man.jpg"
            ),
            Hero(
                heroId = "3",
                heroName = "Thor",
                heroPoster = "file:///android_asset/thor.jpg"
            )
        )
    }
}