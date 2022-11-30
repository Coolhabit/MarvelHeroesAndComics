package ru.marvelheroes.herodetails

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.marvelheroes.herodetails.model.HeroDetailSection
import ru.marvelheroes.herodetails.model.toSection
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.usecases.HeroesUseCase
import java.net.URL
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HeroDetailsViewModel @Inject constructor(
    private val useCase: HeroesUseCase
) : ViewModel() {

    var heroInfo: Hero? = null

    private val _loadDetail = MutableSharedFlow<List<HeroDetailSection>>()
    val loadDetail = _loadDetail.asSharedFlow()

    fun initDetail(id: String) {
        viewModelScope.launch {
            val heroDetails = useCase.loadHeroDetails(id)
            heroInfo = heroDetails.heroDetail.first().hero
            _loadDetail.emit(heroDetails.toSection())
        }
    }

    suspend fun loadWallpaper(url: String?): Bitmap {
        return suspendCoroutine {
            val url = URL(url)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            it.resume(bitmap)
        }
    }
}
