package ru.marvelheroes.comicsdetails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.marvelheroes.comicsdetails.databinding.RvComicImageBinding
import ru.marvelheroes.entities.dto.comics.ComicImage
import javax.inject.Inject

class ComicImagesAdapter @Inject constructor() : ListAdapter<ComicImage, ComicImagesViewHolder>(ComicImagesDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicImagesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvComicImageBinding.inflate(inflater, parent, false)
        return ComicImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ComicImagesDiffUtils : DiffUtil.ItemCallback<ComicImage>() {

        override fun areItemsTheSame(oldItem: ComicImage, newItem: ComicImage): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ComicImage, newItem: ComicImage): Boolean {
            return oldItem.path == newItem.path
        }
    }
}
