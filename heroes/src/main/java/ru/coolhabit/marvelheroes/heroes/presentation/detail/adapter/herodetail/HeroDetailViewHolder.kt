package ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.herodetail

import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.marvelheroes.heroes.databinding.ViewHeroCompilationBinding
import ru.marvelheroes.entities.dto.hero.HeroDetail
import ru.marvelheroes.extensions.load

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
