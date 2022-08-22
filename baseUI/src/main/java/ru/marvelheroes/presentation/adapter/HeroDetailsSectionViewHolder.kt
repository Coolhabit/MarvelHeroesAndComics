package ru.marvelheroes.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

interface IAdapterItemProvider<T> {

    fun getAdapterItem(position: Int): T
}

abstract class HeroDetailsSectionViewHolder<T: IHeroDetailSection>(view: View) : RecyclerViewHolder<T>(view) {

    protected abstract val sectionName: TextView
    protected abstract val sectionList: RecyclerView

    fun init(callback: (ITapCommand<*>, ) -> Unit) {

        onCreated(callback)
    }
}