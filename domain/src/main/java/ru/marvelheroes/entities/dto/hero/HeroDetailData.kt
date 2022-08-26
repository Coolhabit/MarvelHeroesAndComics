package ru.marvelheroes.entities.dto.hero

import ru.marvelheroes.entities.dto.series.Series

data class HeroDetailData(
    val heroDetail: List<HeroDetail>,
    val seriesList: List<Series>,
    val comicsList: List<Series>,
)
