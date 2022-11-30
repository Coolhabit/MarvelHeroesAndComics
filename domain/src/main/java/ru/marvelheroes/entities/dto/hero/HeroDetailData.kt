package ru.marvelheroes.entities.dto.hero

import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.books.Series

data class HeroDetailData(
    val heroDetail: List<HeroDetail>,
    val seriesList: List<Series>,
    val comicsList: List<Comics>,
)
