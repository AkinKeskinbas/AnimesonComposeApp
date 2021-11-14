package com.akin.animeson.di

import android.content.Context
import com.akin.animeson.BuildConfig
import com.akin.animeson.data.api.AnimeApi
import com.akin.animeson.repository.AllAnimeRepository
import com.akin.animeson.util.Constant.BASE_URL
import com.akin.animeson.util.Constant.KEY
import com.akin.animeson.util.Constant.VALUE
import com.parse.Parse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAnimeRepository(
        api: AnimeApi
    ) = AllAnimeRepository(api)

    @Singleton
    @Provides
    fun provideAnimeApi():AnimeApi {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
        builder.readTimeout(10, TimeUnit.SECONDS)
        builder.connectTimeout(5, TimeUnit.SECONDS)
        builder.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val request = chain.request().newBuilder().addHeader(VALUE, KEY).build()
            chain.proceed(request)
        })

        val client: OkHttpClient = builder.build()

        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(AnimeApi::class.java)
    }

}