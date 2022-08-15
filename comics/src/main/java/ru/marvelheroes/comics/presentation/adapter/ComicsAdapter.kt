package ru.marvelheroes.comics.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.marvelheroes.comics.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.comics.Comics
import javax.inject.Inject

class ComicsAdapter @Inject constructor() : PagingDataAdapter<Comics, ComicsViewHolder>(ComicsDiffUtils()) {

    var tapHandler: (Comics?) -> Unit ={}

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvComicsItemBinding.inflate(inflater, parent, false)
        return ComicsViewHolder(binding, tapHandler)
    }

    class ComicsDiffUtils: DiffUtil.ItemCallback<Comics>() {
        override fun areItemsTheSame(oldItem: Comics, newItem: Comics): Boolean {
            return oldItem.comicsId == newItem.comicsId
        }

        override fun areContentsTheSame(oldItem: Comics, newItem: Comics): Boolean {
            return oldItem == newItem
        }

    }
}
