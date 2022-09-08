package ru.marvelheroes.herodetails.model

import ru.marvelheroes.entities.dto.hero.HeroDetailData

fun HeroDetailData.toSection(): List<HeroDetailSection> = mutableListOf<HeroDetailSection>().apply {
    add(
        HeroDetailSection.HeroDetailsCompilation(
            sectionName = "",
            heroDetails = heroDetail
        )
    )
    add(
        HeroDetailSection.SeriesSection(
            sectionName = "Series",
            seriesList = seriesList,
        )
    )
    add(
        HeroDetailSection.ComicsSection(
            sectionName = "Comics",
            comicsList = comicsList,
        )
    )
}
