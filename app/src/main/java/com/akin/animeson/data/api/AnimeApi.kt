package com.akin.animeson.data.api

import com.akin.animeson.data.models.AnimeModel
import com.akin.animeson.data.models.users.UserModel
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT
import retrofit2.http.Query
import java.util.*

interface AnimeApi {

    @GET("DataVideo")
    suspend fun getAllAnimes(): AnimeModel

    @GET("DataVideo")
    suspend fun getLastAddAnime(
        @Query("limit") limit: Int,
        @Query("order") order: String,
        @Query("where") where:JSONObject? ,
    ): AnimeModel

    @GET("login")
    suspend fun logIn() : UserModel

    @GET("users")
    suspend fun getUser() : UserModel

    @PUT("users/{userId}")
    suspend fun updateUser(
        @Query("userId") userId:String
    ) : UserModel

}