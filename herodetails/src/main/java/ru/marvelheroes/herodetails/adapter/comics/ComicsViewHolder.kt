package ru.marvelheroes.herodetails.adapter.comics

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.books.Comics
import ru.marvelheroes.extensions.load

class ComicsViewHolder(
    private val binding: RvComicsItemBinding,
    private val clickListener: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            clickListener.invoke(bindingAdapterPosition)
        }
    }

    fun bind(item: Comics) {
        with(binding) {
            comicsTitle.text = item.comicsName
            comicsPoster.load(item.comicsPoster)
        }
    }
}
