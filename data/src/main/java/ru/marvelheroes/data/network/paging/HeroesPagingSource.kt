package ru.marvelheroes.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.marvelheroes.data.network.MarvelApi
import ru.marvelheroes.data.network.mappers.toHero
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE
import ru.marvelheroes.entities.dto.hero.Hero
import ru.marvelheroes.extensions.NULL

class HeroesPagingSource(
    private val api: MarvelApi,
) : PagingSource<Int, Hero>() {

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val offset = state.closestPageToPosition(anchorPosition) ?: return null
        return offset.prevKey?.plus(NETWORK_PAGE_SIZE) ?: offset.nextKey?.minus(NETWORK_PAGE_SIZE)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {

        val offset = params.key ?: NULL
        val limit = params.loadSize.coerceAtMost(NETWORK_PAGE_SIZE)
        val response = api.getHeroes(offset, limit)

        return if (response.isSuccessful) {
            val heroes = checkNotNull(response.body()?.data?.results?.map { it.toHero() })
            val nextKey = if (heroes.size < limit) null else offset + NETWORK_PAGE_SIZE
            val prevKey = if (offset == NETWORK_PAGE_SIZE) null else offset - NETWORK_PAGE_SIZE
            LoadResult.Page(heroes, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }
}
