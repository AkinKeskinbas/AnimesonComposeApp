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

    var lastAddAnimeList = mutableStateOf<List<Result>>(listOf())
    var topTenAnimeList = mutableStateOf<List<Result>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        getLastAddAnime()
        getTopTenAnime()
    }

    private fun getLastAddAnime(){

        viewModelScope.launch {
            isLoading.value = true
            when(val result = repository.getLastAdd()){
                is Resource.Error ->{

                    println("HomeScreenError::${result.message}")
                    errorMessage.value = result.message!!
                    isLoading.value = true
                }
                is Resource.Success->{
                    lastAddAnimeList.value = result.data!!.results
                    errorMessage.value = ""
                    isLoading.value = false
                }


            }

        }
    }
    private fun getTopTenAnime(){

        viewModelScope.launch {
            isLoading.value = true
            when(val result = repository.getTopTen()){
                is Resource.Error ->{
                    println("HomeScreenError::${result.message}")
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                is Resource.Success->{
                    topTenAnimeList.value = result.data!!.results
                    errorMessage.value = ""
                    isLoading.value = false
                }


            }

        }
    }
}