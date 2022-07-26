package ru.marvelheroes.herodetails.adapter.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.marvelheroes.databinding.RvComicsItemBinding
import ru.marvelheroes.entities.dto.books.Series
import javax.inject.Inject

class SeriesAdapter @Inject constructor() : ListAdapter<Series, SeriesViewHolder>(SeriesDiffUtils()) {

    var clickListener: (Series) -> Unit = {}

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvComicsItemBinding.inflate(inflater, parent, false)
        return SeriesViewHolder(binding) { pos ->
            clickListener(getItem(pos))
        }
    }

    class SeriesDiffUtils: DiffUtil.ItemCallback<Series>() {
        override fun areItemsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem.seriesId == newItem.seriesId
        }

        override fun areContentsTheSame(oldItem: Series, newItem: Series): Boolean {
            return oldItem == newItem
        }

    }
}
