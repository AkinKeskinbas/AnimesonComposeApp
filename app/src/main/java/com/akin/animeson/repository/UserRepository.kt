package com.akin.animeson.repository

import com.akin.animeson.data.Resource
import com.akin.animeson.data.api.AnimeApi
import com.akin.animeson.data.models.Result
import com.akin.animeson.data.models.users.UserModel
import com.akin.animeson.data.models.users.UserSignupModel
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
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
    suspend fun signUpUser(body: JSONObject):Resource<UserSignupModel>{
        val response = try {
            api.signUp(body = body)
        }catch (e: Exception){
            println("hata")
            return Resource.Error(e.message,null)
        }
        return  Resource.Success(response)
    }
}