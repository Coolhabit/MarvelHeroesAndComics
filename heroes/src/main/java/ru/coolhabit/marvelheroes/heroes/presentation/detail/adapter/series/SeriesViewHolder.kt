package ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.series

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.series.Series
import ru.marvelheroes.extensions.load

class SeriesViewHolder(
    private val binding: RvComicsItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Series) {
        with(binding) {
            comicsTitle.text = item.seriesName
            comicsPoster.load(item.seriesPoster)
        }
    }
}
