package com.akin.animeson

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.akin.animeson.domain.HomeScreenViewModel
import com.akin.animeson.ui.homescreen.HomeCard
import com.akin.animeson.ui.homescreen.HomeTitle
import com.akin.animeson.ui.homescreen.HomeTopCard
import com.akin.animeson.ui.splashscreen.SplashScreen
import com.akin.animeson.ui.theme.AnimesonComposeTheme
import com.akin.animeson.ui.theme.BackGroundColor
import com.akin.animeson.ui.theme.Roboto
import com.akin.animeson.ui.theme.RobotoCondensed
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimesonComposeTheme {

                val viewModel: HomeScreenViewModel = hiltViewModel()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "animeson_splash_screen"
                ) {
                    composable("animeson_splash_screen") {
                        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF151515)) {
                            SplashScreen(navController = navController)
                        }


                    }
                    composable("animeson_auth_screen") {

                    }
                    composable("animeson_home_screen") {

                        Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                HomeTopCard(
                                    imageUrl = viewModel.animeList.value[3].animeKapakList[0],
                                    title = viewModel.animeList.value[3].DiziAdi,
                                    contentDesc = viewModel.animeList.value[3].objectId,
                                    navController = navController
                                )
                            }
                            HomeTitle(
                                title = "Son Eklenenler",
                                color = Color.Black,
                                size = 24.sp,
                                fontFamily = Roboto,
                                alignment = TextAlign.Start
                            )
                            LazyRow() {
                                itemsIndexed(items = viewModel.animeList.value) { index, item ->
                                    if (!viewModel.isLoading.value) {

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth(0.4f)
                                                .padding(16.dp)
                                        ) {
                                            HomeCard(
                                                imageUrl = item.ResimUrl,
                                                title = item.DiziAdi,
                                                contentDesc = item.objectId,
                                                navController = navController
                                            )
                                        }
                                    }

                                }
                            }
                        }


                    }
                    composable("animeson_detail_screen/{animeId}", arguments = listOf(
                        navArgument("animeId") {
                            navArgument("animeId") {
                                type = NavType.StringType
                            }
                        }
                    )) {
                        val returnAnimeId = remember {
                            it.arguments?.getString("animeId")

                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TestHome() {
    AnimesonComposeTheme() {

    }
}



