package ru.marvelheroes.myavengers.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.extensions.load
import ru.marvelheroes.myavengers.databinding.RvHeroItemBinding

class MyAvengersViewHolder(
    private val binding: RvHeroItemBinding,
    private val onFavClick: (Hero) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Hero) {
        binding.apply {
            heroName.text = item.heroName
            heroPoster.load(item.heroPoster)
            favouriteBtn.setOnClickListener {
                onFavClick.invoke(item)
            }
        }
    }
}
