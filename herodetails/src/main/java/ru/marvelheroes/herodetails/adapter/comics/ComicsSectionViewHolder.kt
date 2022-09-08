package ru.marvelheroes.herodetails.adapter.comics

import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.herodetails.R
import ru.marvelheroes.herodetails.adapter.ComicsCommand
import ru.marvelheroes.herodetails.databinding.RvSectionComicsBinding
import ru.marvelheroes.herodetails.model.HeroDetailSection
import ru.marvelheroes.presentation.adapter.HeroDetailBaseSectionViewHolder
import ru.marvelheroes.presentation.adapter.IClickCommand
import ru.marvelheroes.presentation.adapter.ItemDecoration

class ComicsSectionViewHolder(view: View) :
    HeroDetailBaseSectionViewHolder<HeroDetailSection.ComicsSection>(view) {

    companion object {
        @LayoutRes
        val ID: Int = R.layout.rv_section_comics
    }

    private val binding = RvSectionComicsBinding.bind(view)

    override val sectionName: TextView
        get() = binding.include.sectionName
    override val sectionList: RecyclerView
        get() = binding.include.viewContent

    private val comicsAdapter: ComicsAdapter
        get() = sectionList.adapter as ComicsAdapter

    override fun onCreated(callback: (IClickCommand<*>) -> Unit) {
        sectionList.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(
                ItemDecoration(
                    context,
                    R.dimen.spacing_5,
                    R.dimen.spacing_5,
                    R.dimen.spacing_5,
                    R.dimen.spacing_5
                )
            )
            adapter = ComicsAdapter().apply {
                clickListener = {
                    callback.invoke(ComicsCommand(it))
                }
            }
        }
    }

    override fun bind(item: HeroDetailSection.ComicsSection) {
        comicsAdapter.submitList(item.comicsList)
    }
}