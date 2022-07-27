package ru.coolhabit.marvelheroes.heroes.presentation

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.marvelheroes.heroes.databinding.RvHeroItemBinding
import ru.marvelheroes.extensions.load

class HeroViewHolder(private val binding: RvHeroItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Hero) {
            binding.heroName.text = item.heroName
            binding.heroPoster.load(item.heroPoster)
        }
}