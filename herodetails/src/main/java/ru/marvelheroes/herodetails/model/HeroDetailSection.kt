package ru.marvelheroes.herodetails.model

import ru.marvelheroes.entities.dto.hero.HeroDetail
import ru.marvelheroes.entities.dto.series.Series
import ru.marvelheroes.presentation.adapter.IHeroDetailSection

sealed class HeroDetailSection(
    override val sectionName: String
) : IHeroDetailSection {

    class HeroDetailsCompilation(
        sectionName: String,
        val heroDetails: List<HeroDetail>
    ) : HeroDetailSection(sectionName) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is HeroDetailsCompilation) return false
            if (!super.equals(other)) return false

            if (heroDetails != other.heroDetails) return false

            return true
        }

        override fun hashCode(): Int {
            var result = super.hashCode()
            result = 31 * result + heroDetails.hashCode()
            return result
        }
    }

    class ComicsAndSeriesCompilation(
        sectionName: String,
        var bookList: List<Series>
    ) : HeroDetailSection(sectionName) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is ComicsAndSeriesCompilation) return false
            if (!super.equals(other)) return false

            if (bookList != other.bookList) return false

            return true
        }

        override fun hashCode(): Int {
            var result = super.hashCode()
            result = 31 * result + bookList.hashCode()
            return result
        }
    }
}
