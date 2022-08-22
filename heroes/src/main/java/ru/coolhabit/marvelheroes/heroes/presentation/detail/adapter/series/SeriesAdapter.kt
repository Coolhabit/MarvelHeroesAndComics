package ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.coolhabit.marvelheroes.heroes.databinding.RvSeriesItemBinding
import ru.marvelheroes.entities.dto.series.Series
import javax.inject.Inject

class SeriesAdapter @Inject constructor() : ListAdapter<Series, SeriesViewHolder>(SeriesDiffUtils()) {

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvSeriesItemBinding.inflate(inflater, parent, false)
        return SeriesViewHolder(binding)
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
