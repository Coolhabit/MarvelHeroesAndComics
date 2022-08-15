package ru.marvelheroes.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import ru.marvelheroes.data.network.MarvelApi
import ru.marvelheroes.data.network.mappers.toComics
import ru.marvelheroes.entities.dto.comics.Comics
import ru.marvelheroes.extensions.NETWORK_PAGE_SIZE
import ru.marvelheroes.extensions.NULL

class ComicsPagingSource @AssistedInject constructor(
    private val api: MarvelApi,
) : PagingSource<Int, Comics>() {

    override fun getRefreshKey(state: PagingState<Int, Comics>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val offset = state.closestPageToPosition(anchorPosition) ?: return null
        return offset.prevKey?.plus(NETWORK_PAGE_SIZE) ?: offset.nextKey?.minus(NETWORK_PAGE_SIZE)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comics> {

        val offset = params.key ?: NULL
        val limit = params.loadSize.coerceAtMost(NETWORK_PAGE_SIZE)
        val response = api.getComics(offset, limit)

        return if (response.isSuccessful) {
            val comics = checkNotNull(response.body()?.data?.results?.map { it.toComics() })
            val nextKey = if (comics.size < limit) null else offset + NETWORK_PAGE_SIZE
            val prevKey = if (offset == NETWORK_PAGE_SIZE) null else offset - NETWORK_PAGE_SIZE
            LoadResult.Page(comics, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): ComicsPagingSource
    }
}
