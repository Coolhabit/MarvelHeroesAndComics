package ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.series

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.marvelheroes.heroes.databinding.RvSeriesItemBinding
import ru.marvelheroes.entities.dto.series.Series
import ru.marvelheroes.extensions.load

class SeriesViewHolder(
    private val binding: RvSeriesItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Series) {
        with(binding) {
            comicsTitle.text = item.seriesName
            comicsPoster.load(item.seriesPoster)
        }
    }
}
