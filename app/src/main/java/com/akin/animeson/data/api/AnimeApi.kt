package com.akin.animeson.data.api

import com.akin.animeson.data.Resource
import com.akin.animeson.data.models.AnimeModel
import com.akin.animeson.data.models.Result
import com.akin.animeson.data.models.users.UserModel
import com.akin.animeson.data.models.users.UserSignupModel
import com.akin.animeson.util.Constant.BASE_AUTH_URL
import com.google.gson.JsonObject
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
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

    @POST(BASE_AUTH_URL)
    suspend fun signUp(
        @Body body:JSONObject
    ) : UserSignupModel

    @GET("users")
    suspend fun getUser() : UserModel

    @PUT("users/{userId}")
    suspend fun updateUser(
        @Query("userId") userId:String
    ) : UserModel

}