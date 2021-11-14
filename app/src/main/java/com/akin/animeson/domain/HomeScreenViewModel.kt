package com.akin.animeson.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akin.animeson.data.Resource
import com.akin.animeson.data.models.Result
import com.akin.animeson.repository.AllAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: AllAnimeRepository
) : ViewModel() {

    var animeList = mutableStateOf<List<Result>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        getAllAnime()
    }

    private fun getAllAnime(){

        viewModelScope.launch {
            isLoading.value = true
            when(val result = repository.getLastAdd()){
                is Resource.Error ->{
                    println(result.message)
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                is Resource.Success->{
                    println(result)
                    animeList.value = result.data!!.results
                    //println(animeList.value)
                    errorMessage.value = ""
                    isLoading.value = false
                }


            }

        }
    }
}