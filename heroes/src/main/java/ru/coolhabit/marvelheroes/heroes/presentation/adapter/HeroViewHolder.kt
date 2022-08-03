package ru.coolhabit.marvelheroes.heroes.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.marvelheroes.heroes.databinding.RvHeroItemBinding
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.extensions.load

class HeroViewHolder(
    private val binding: RvHeroItemBinding,
    private val tapHandler: (Hero) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Hero) {
        binding.apply {
            heroName.text = item.heroName
            heroPoster.load(item.heroPoster)
            heroCard.setOnClickListener {
                tapHandler.invoke(item)
            }
        }
    }
}
