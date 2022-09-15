package ru.marvelheroes.herodetails.adapter.herodetail

import android.view.View
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.marvelheroes.herodetails.R
import ru.marvelheroes.herodetails.databinding.RvSectionHeroCompilationBinding
import ru.marvelheroes.herodetails.model.HeroDetailSection
import ru.marvelheroes.presentation.adapter.HeroDetailBaseSectionViewHolder
import ru.marvelheroes.presentation.adapter.IClickCommand
import ru.marvelheroes.presentation.adapter.ItemDecoration

class HeroDetailSectionViewHolder(view: View) :
    HeroDetailBaseSectionViewHolder<HeroDetailSection.HeroDetailsCompilation>(view) {

    companion object {
        @LayoutRes
        val ID: Int = R.layout.rv_section_hero_compilation
    }

    private val binding = RvSectionHeroCompilationBinding.bind(view)

    override val sectionName: TextView
        get() = binding.include.sectionName
    override val sectionList: RecyclerView
        get() = binding.include.viewContent

    private val heroDetailAdapter: HeroDetailAdapter
        get() = sectionList.adapter as HeroDetailAdapter

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
            adapter = HeroDetailAdapter().apply {

            }
        }
    }

    override fun bind(item: HeroDetailSection.HeroDetailsCompilation) {
        heroDetailAdapter.submitList(item.heroDetails)
    }
}