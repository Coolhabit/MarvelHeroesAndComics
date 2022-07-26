package ru.marvelheroes.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.marvelheroes.data.network.MarvelApi
import ru.marvelheroes.data.mappers.toSeries
import ru.marvelheroes.entities.dto.books.Series
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE
import ru.marvelheroes.extensions.NULL

class SeriesPagingSource(
    private val api: MarvelApi,
    private val query: String?
) : PagingSource<Int, Series>() {

    override fun getRefreshKey(state: PagingState<Int, Series>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val offset = state.closestPageToPosition(anchorPosition) ?: return null
        return offset.prevKey?.plus(NETWORK_PAGE_SIZE) ?: offset.nextKey?.minus(NETWORK_PAGE_SIZE)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Series> {

        val offset = params.key ?: NULL
        val limit = params.loadSize.coerceAtMost(NETWORK_PAGE_SIZE)
        val response = api.getComics(offset, limit, query)

        return if (response.isSuccessful) {
            val series = checkNotNull(response.body()?.data?.results?.map { it.toSeries() })
            val nextKey = if (series.size < limit) null else offset + NETWORK_PAGE_SIZE
            val prevKey = if (offset == NETWORK_PAGE_SIZE) null else offset - NETWORK_PAGE_SIZE
            LoadResult.Page(series, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }
}
