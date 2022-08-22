package ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.herodetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.coolhabit.marvelheroes.heroes.databinding.ViewHeroCompilationBinding
import ru.marvelheroes.entities.dto.hero.HeroDetail
import javax.inject.Inject

class HeroDetailAdapter @Inject constructor() : ListAdapter<HeroDetail, HeroDetailViewHolder>(HeroDetailDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHeroCompilationBinding.inflate(inflater, parent, false)
        return HeroDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HeroDetailDiffUtils : DiffUtil.ItemCallback<HeroDetail>() {

        override fun areItemsTheSame(oldItem: HeroDetail, newItem: HeroDetail): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: HeroDetail, newItem: HeroDetail): Boolean {
            return oldItem.hero.heroId == newItem.hero.heroId
        }
    }
}
