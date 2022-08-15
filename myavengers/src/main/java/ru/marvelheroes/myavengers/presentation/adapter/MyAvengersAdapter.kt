package ru.marvelheroes.myavengers.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.myavengers.databinding.RvAvengersItemBinding
import javax.inject.Inject

class MyAvengersAdapter @Inject constructor() : ListAdapter<Hero, MyAvengersViewHolder>(MyAvengersDiffUtils()) {

    var onFavClick: (Hero) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAvengersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvAvengersItemBinding.inflate(inflater, parent, false)
        return MyAvengersViewHolder(binding, onFavClick)
    }

    override fun onBindViewHolder(holder: MyAvengersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MyAvengersDiffUtils: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.heroId == newItem.heroId
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }
}