package ru.marvelheroes.data.ioc

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.marvelheroes.data.extensions.md5
import ru.marvelheroes.data.network.MarvelApi
import ru.marvelheroes.data.utils.API
import ru.marvelheroes.data.utils.ApiConstants
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val HASH = "hash"
private const val APIKEY = "apikey"
private const val TS = "ts"
private const val TS_VALUE = "1"
private const val TIMEOUT = 30L

@Module
class RemoteModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .callTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val defaultRequest = chain.request()
            val hashSignature = "$TS_VALUE${API.PRIVATE_KEY}${API.PUBLIC_KEY}".md5()
            val defaultHttpUrl = defaultRequest.url
            val httpUrl = defaultHttpUrl.newBuilder()
                .addQueryParameter(TS, TS_VALUE)
                .addQueryParameter(APIKEY, API.PUBLIC_KEY)
                .addQueryParameter(HASH, hashSignature)
                .build()

            val requestBuilder = defaultRequest.newBuilder().url(httpUrl)

            chain.proceed(requestBuilder.build())
        }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideMarvelApi(retrofit: Retrofit): MarvelApi = retrofit.create(MarvelApi::class.java)
}
