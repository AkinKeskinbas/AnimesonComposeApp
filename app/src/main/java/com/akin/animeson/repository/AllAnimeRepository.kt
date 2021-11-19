package com.akin.animeson.repository

import com.akin.animeson.data.Resource
import com.akin.animeson.data.api.AnimeApi
import com.akin.animeson.data.models.AnimeModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class AllAnimeRepository @Inject constructor(
    private val api:AnimeApi
){
    suspend fun getAllAnime() :Resource<AnimeModel>{
        val response = try {
            api.getAllAnimes()
        }catch (e : Exception){
            return Resource.Error(e.message, null)
        }
        return Resource.Success(response)
    }
    suspend fun getLastAdd() :Resource<AnimeModel>{
        val response = try {

            api.getLastAddAnime(10,"-date")
        }catch (e : Exception){
            println("repo::${e.message}")
            return Resource.Error(e.message, null)
        }
        return Resource.Success(response)
    }
    suspend fun getTopTen() :Resource<AnimeModel>{
        val response = try {

            api.getLastAddAnime(10,"-gunlukIzlenme")
        }catch (e : Exception){
            return Resource.Error("repoo::${e.message}", null)
        }
        return Resource.Success(response)
    }
}