package ru.marvelheroes.comics.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ru.marvelheroes.comics.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.series.Series
import javax.inject.Inject

class ComicsAdapter @Inject constructor() : PagingDataAdapter<Series, ComicsViewHolder>(ComicsDiffUtils()) {

    var tapHandler: (Series?) -> Unit ={}

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvComicsItemBinding.inflate(inflater, parent, false)
        return ComicsViewHolder(binding, tapHandler)
    }

    class ComicsDiffUtils: DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem.seriesId == newItem.seriesId
        }

        override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem == newItem
        }

    }
}
