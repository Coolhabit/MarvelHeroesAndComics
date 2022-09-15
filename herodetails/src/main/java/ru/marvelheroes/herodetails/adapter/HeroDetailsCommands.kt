package ru.marvelheroes.herodetails.adapter

import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.presentation.adapter.IClickCommand

sealed class HeroDetailsCommands<T> : IClickCommand<T>

class ComicsCommand(override val payload: Comics) : HeroDetailsCommands<Comics>()

class SeriesCommand(override val payload: Series) : HeroDetailsCommands<Series>()
