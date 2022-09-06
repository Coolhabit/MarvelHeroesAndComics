package ru.marvelheroes.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

interface IAdapterItemProvider<T> {

    fun getAdapterItem(position: Int): T
}

abstract class HeroDetailBaseSectionViewHolder<T : IHeroDetailSection>(view: View) :
    RecyclerViewHolder<T>(view) {

    protected abstract val sectionName: TextView
    protected abstract val sectionList: RecyclerView

    fun init(itemProvider: IAdapterItemProvider<IHeroDetailSection>, callback: (IClickCommand<*>) -> Unit) {

        onCreated(callback)
    }

    protected abstract fun onCreated(callback: (IClickCommand<*>) -> Unit)

    abstract fun bind(item: T)

    override fun bind(position: Int, item: T) {

        sectionName.text = item.sectionName

        bind(item)
    }
}