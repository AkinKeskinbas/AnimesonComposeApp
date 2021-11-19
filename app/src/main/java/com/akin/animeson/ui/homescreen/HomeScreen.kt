package com.akin.animeson.ui.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.akin.animeson.domain.HomeScreenViewModel
import com.akin.animeson.ui.Screens
import com.akin.animeson.ui.theme.Roboto

@ExperimentalMaterialApi
@Composable
fun HomeScreen(navController : NavController,viewModel: HomeScreenViewModel){

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            HomeTopCard(
                imageUrl = viewModel.lastAddAnimeList.value[0].animeKapakList[0],
                title = viewModel.lastAddAnimeList.value[0].DiziAdi,
                contentDesc = viewModel.lastAddAnimeList.value[0].objectId,
                navController = navController
            )
        }
        HomeTitle(
            title = "Son Eklenenler",
            color = MaterialTheme.colors.primary,
            size = 24.sp,
            fontFamily = Roboto,
            alignment = TextAlign.Start
        )
        LazyRow() {
            itemsIndexed(items = viewModel.lastAddAnimeList.value) { index, item ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .padding(16.dp)
                ) {

                    HomeCard(
                        imageUrl = item.ResimUrl,
                        title = item.DiziAdi,
                        contentDesc = item.objectId,
                        navController = navController,
                        animeId = item.objectId,
                        episode = (item.Bolumler.size+1).toString()
                    )
                }

            }
        }
        HomeTitle(
            title = "En Çok İzlenenler",
            color = MaterialTheme.colors.primary,
            size = 24.sp,
            fontFamily = Roboto,
            alignment = TextAlign.Start
        )
        LazyRow() {
            itemsIndexed(items = viewModel.topTenAnimeList.value) { index, item ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .padding(16.dp)
                ) {
                    HomeCard(
                        imageUrl = item.ResimUrl,
                        title = item.DiziAdi,
                        contentDesc = item.objectId,
                        navController = navController,
                        animeId = item.objectId,
                        episode = null
                    )
                }


            }
        }
    }
}