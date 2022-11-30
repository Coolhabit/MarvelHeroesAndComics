package ru.marvelheroes.comics.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.extensions.load

class ComicsViewHolder(
    private val binding: RvComicsItemBinding,
    private val tapHandler: (Series?) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Series?) {
        with(binding) {
            comicsTitle.text = item?.seriesName
            comicsPoster.load(item?.seriesPoster)
            comicsCard.setOnClickListener {
                tapHandler.invoke(item)
            }
        }
    }
}
