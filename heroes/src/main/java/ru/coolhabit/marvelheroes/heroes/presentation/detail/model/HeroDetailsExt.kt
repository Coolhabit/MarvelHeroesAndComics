package ru.coolhabit.marvelheroes.heroes.presentation.detail.model

import ru.marvelheroes.entities.dto.hero.HeroDetailData

fun HeroDetailData.toSection(): List<HeroDetailSection> = mutableListOf<HeroDetailSection>().apply {
    add(
        HeroDetailSection.HeroDetailsCompilation(
            sectionName = "",
            heroDetails = heroDetail
        )
    )
    add(
        HeroDetailSection.ComicsAndSeriesCompilation(
            sectionName = "Series",
            bookList = seriesList,
        )
    )
    add(
        HeroDetailSection.ComicsAndSeriesCompilation(
            sectionName = "Comics",
            bookList = comicsList,
        )
    )
}
