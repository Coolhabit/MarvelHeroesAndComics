package ru.marvelheroes.herodetails.adapter.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.marvelheroes.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.books.Comics
import javax.inject.Inject

class ComicsAdapter @Inject constructor() : ListAdapter<Comics, ComicsViewHolder>(SeriesDiffUtils()) {

    var clickListener: (Comics) -> Unit = {}

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvComicsItemBinding.inflate(inflater, parent, false)
        return ComicsViewHolder(binding) { pos ->
            clickListener(getItem(pos))
        }
    }

    class SeriesDiffUtils: DiffUtil.ItemCallback<Comics>() {
        override fun areItemsTheSame(oldItem: Comics, newItem: Comics): Boolean {
            return oldItem.comicsId == newItem.comicsId
        }

        override fun areContentsTheSame(oldItem: Comics, newItem: Comics): Boolean {
            return oldItem == newItem
        }

    }
}
