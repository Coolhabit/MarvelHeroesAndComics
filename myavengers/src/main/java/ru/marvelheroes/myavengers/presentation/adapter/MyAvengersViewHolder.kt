package ru.marvelheroes.myavengers.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.extensions.load
import ru.marvelheroes.myavengers.databinding.RvAvengersItemBinding

class MyAvengersViewHolder(
    private val binding: RvAvengersItemBinding,
    private val onFavClick: (Hero) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Hero) {
        with(binding) {
            avengersName.text = item.heroName
            avengersPoster.load(item.heroPoster)
            removeBtn.setOnClickListener {
                onFavClick.invoke(item)
            }
        }
    }
}
