package ru.coolhabit.marvelheroes.heroes.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.RvHeroItemBinding
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.extensions.load
import javax.inject.Inject

class HeroAdapter @Inject constructor() : PagingDataAdapter<Hero, HeroAdapter.HeroViewHolder>(HeroDiffUtils()) {

    var tapHandler: (Hero?) -> Unit = {}
    var onFavClick: (Hero) -> Unit = {}

    var favourites: List<Hero> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvHeroItemBinding.inflate(inflater, parent, false)
        return HeroViewHolder(binding, tapHandler, onFavClick)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    class HeroDiffUtils: DiffUtil.ItemCallback<Hero>() {
        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.heroId == newItem.heroId
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateFavourites(favouritesUpdated: List<Hero>) {
        favourites = favouritesUpdated
        notifyDataSetChanged()
    }

    inner class HeroViewHolder(
        private val binding: RvHeroItemBinding,
        private val tapHandler: (Hero?) -> Unit,
        private val onFavClick: (Hero) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Hero) {
            binding.apply {
                heroName.text = item.heroName
                heroPoster.load(item.heroPoster)
                heroCard.setOnClickListener {
                    tapHandler.invoke(item)
                }
                favouriteBtn.setOnClickListener {
                    onFavClick.invoke(item)
                }
                val favHero = favourites.find { it.heroId == item.heroId }
                if (favHero != null) {
                    favouriteBtn.setImageResource(R.drawable.ic_favorite_pressed)
                } else {
                    favouriteBtn.setImageResource(R.drawable.ic_favorite)
                }
            }
        }
    }
}
