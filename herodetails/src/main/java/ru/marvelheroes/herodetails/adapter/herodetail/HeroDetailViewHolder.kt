package ru.marvelheroes.herodetails.adapter.herodetail

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.entities.dto.hero.HeroDetail
import ru.marvelheroes.extensions.load
import ru.marvelheroes.herodetails.databinding.ViewHeroCompilationBinding

class HeroDetailViewHolder(private val binding: ViewHeroCompilationBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: HeroDetail) {
        with(binding) {
            poster.load(item.hero.heroPoster)
            title.text = item.hero.heroName
            description.text = item.description
        }
    }
}
