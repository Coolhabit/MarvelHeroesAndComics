package ru.coolhabit.marvelheroes.heroes.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.coolhabit.marvelheroes.heroes.databinding.RvHeroItemBinding
import javax.inject.Inject

class HeroAdapter @Inject constructor() : ListAdapter<Hero, HeroViewHolder>(HeroDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvHeroItemBinding.inflate(inflater, parent, false)
        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HeroDiffUtils: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.heroId == newItem.heroId
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }
}