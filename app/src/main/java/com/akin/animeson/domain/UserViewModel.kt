package com.akin.animeson.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akin.animeson.data.Resource
import com.akin.animeson.data.models.Result
import com.akin.animeson.data.models.users.UserModel
import com.akin.animeson.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
):ViewModel() {
    var userList = mutableStateOf<List<UserModel>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun updateUserWithId(userId:String){
        viewModelScope.launch {
            isLoading.value = true
            when(val result = userRepository.updateUserWithId(userId)){
                is Resource.Error ->{
                    println("HomeScreenEror::${result.message}")

                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                is Resource.Success->{


                    //println(animeList.value)
                    errorMessage.value = ""
                    isLoading.value = false
                }


            }
        }
    }
}