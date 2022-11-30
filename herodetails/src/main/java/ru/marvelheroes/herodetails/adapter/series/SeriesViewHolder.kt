package ru.marvelheroes.herodetails.adapter.series

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.extensions.load

class SeriesViewHolder(
    private val binding: RvComicsItemBinding,
    private val clickListener: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            clickListener.invoke(bindingAdapterPosition)
        }
    }

    fun bind(item: Series) {
        with(binding) {
            comicsTitle.text = item.seriesName
            comicsPoster.load(item.seriesPoster)
        }
    }
}
