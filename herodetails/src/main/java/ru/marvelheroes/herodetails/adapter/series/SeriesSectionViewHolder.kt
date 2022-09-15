package ru.marvelheroes.herodetails.adapter.series

import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.herodetails.R
import ru.marvelheroes.herodetails.adapter.ComicsCommand
import ru.marvelheroes.herodetails.adapter.SeriesCommand
import ru.marvelheroes.herodetails.databinding.RvSectionSeriesBinding
import ru.marvelheroes.herodetails.model.HeroDetailSection
import ru.marvelheroes.presentation.adapter.HeroDetailBaseSectionViewHolder
import ru.marvelheroes.presentation.adapter.IClickCommand
import ru.marvelheroes.presentation.adapter.ItemDecoration

class SeriesSectionViewHolder(view: View) :
    HeroDetailBaseSectionViewHolder<HeroDetailSection.SeriesSection>(view) {

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
                    R.dimen.spacing_5,
                    R.dimen.spacing_5,
                    R.dimen.spacing_5,
                    R.dimen.spacing_5
                )
            )
            adapter = SeriesAdapter().apply {
                clickListener = {
                    callback.invoke(SeriesCommand(it))
                }
            }
        }
    }

    override fun bind(item: HeroDetailSection.SeriesSection) {
        seriesAdapter.submitList(item.seriesList)
    }
}