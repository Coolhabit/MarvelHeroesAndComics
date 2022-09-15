package ru.marvelheroes.herodetails.model

import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.entities.dto.hero.HeroDetail
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

    class ComicsSection(
        sectionName: String,
        var comicsList: List<Comics>
    ) : HeroDetailSection(sectionName) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is ComicsSection) return false
            if (!super.equals(other)) return false

            if (comicsList != other.comicsList) return false

            return true
        }

        override fun hashCode(): Int {
            var result = super.hashCode()
            result = 31 * result + comicsList.hashCode()
            return result
        }
    }

    class SeriesSection(
        sectionName: String,
        var seriesList: List<Series>
    ) : HeroDetailSection(sectionName) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is SeriesSection) return false
            if (!super.equals(other)) return false

            if (seriesList != other.seriesList) return false

            return true
        }

        override fun hashCode(): Int {
            var result = super.hashCode()
            result = 31 * result + seriesList.hashCode()
            return result
        }
    }
}
