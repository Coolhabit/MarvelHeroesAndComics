package ru.marvelheroes.comicsdetails.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.comicsdetails.databinding.RvComicImageBinding
import ru.marvelheroes.entities.dto.comics.ComicImage
import ru.marvelheroes.extensions.load

class ComicImagesViewHolder(private val binding: RvComicImageBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ComicImage) {
        binding.root.load(item.path)
    }
}
