package ru.coolhabit.marvelheroes.heroes.presentation.detail.adapter.series

import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.coolhabit.marvelheroes.heroes.R
import ru.coolhabit.marvelheroes.heroes.databinding.RvSectionSeriesBinding
import ru.coolhabit.marvelheroes.heroes.presentation.detail.model.HeroDetailSection
import ru.marvelheroes.presentation.adapter.HeroDetailBaseSectionViewHolder
import ru.marvelheroes.presentation.adapter.IClickCommand
import ru.marvelheroes.presentation.adapter.ItemDecoration

class SeriesSectionViewHolder(view: View) :
    HeroDetailBaseSectionViewHolder<HeroDetailSection.ComicsAndSeriesCompilation>(view) {

    companion object {
        @LayoutRes
        val ID: Int = R.layout.rv_section_series
    }

    private val binding = RvSectionSeriesBinding.bind(view)

    override val sectionName: TextView
        get() = binding.include.sectionName
    override val sectionList: RecyclerView
        get() = binding.include.viewContent

    private val seriesAdapter: SeriesAdapter
        get() = sectionList.adapter as SeriesAdapter

    override fun onCreated(callback: (IClickCommand<*>) -> Unit) {
        sectionList.apply {
            itemAnimator = null
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(
                ItemDecoration(
                    context,
                    R.dimen.size_0,
                    R.dimen.size_0,
                    R.dimen.size_0,
                    R.dimen.size_0
                )
            )
            adapter = SeriesAdapter().apply {

            }
        }
    }

    override fun bind(item: HeroDetailSection.ComicsAndSeriesCompilation) {
        seriesAdapter.submitList(item.bookList)
    }
}