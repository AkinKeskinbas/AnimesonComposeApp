package com.akin.animeson.data.api

import com.akin.animeson.data.models.AnimeModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimeApi {

    @GET("DataVideo")
    suspend fun getAllAnimes(): AnimeModel

    @GET("DataVideo")
    suspend fun getLastAddAnime(
        @Query("limit") limit: Int,
        @Query("order") order: String
    ): AnimeModel

}