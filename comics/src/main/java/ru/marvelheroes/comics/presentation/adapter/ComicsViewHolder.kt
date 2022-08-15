package ru.marvelheroes.comics.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.comics.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.comics.Comics
import ru.marvelheroes.extensions.load

class ComicsViewHolder(
    private val binding: RvComicsItemBinding,
    private val tapHandler: (Comics?) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Comics?) {
        with(binding) {
            comicsTitle.text = item?.comicsName
            comicsPoster.load(item?.comicsPoster)
            comicsCard.setOnClickListener {
                tapHandler.invoke(item)
            }
        }
    }
}
