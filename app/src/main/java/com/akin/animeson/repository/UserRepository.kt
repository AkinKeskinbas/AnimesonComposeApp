package com.akin.animeson.repository

import com.akin.animeson.data.Resource
import com.akin.animeson.data.api.AnimeApi
import com.akin.animeson.data.models.users.UserModel
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepository @Inject constructor(
    private  val api:AnimeApi
){
    suspend fun updateUserWithId(userId:String):Resource<UserModel>{
        val response = try {
            api.updateUser(userId)
        }catch (e: Exception){
            return Resource.Error(e.message,null)
        }
       return  Resource.Success(response)
    }
}