package com.akin.animeson.nav_graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akin.animeson.Loader
import com.akin.animeson.domain.HomeScreenViewModel
import com.akin.animeson.ui.BottomBar
import com.akin.animeson.ui.HOME_GRAPH_ROUTE
import com.akin.animeson.ui.Screens
import com.akin.animeson.ui.detailscreen.DetailScreen
import com.akin.animeson.ui.homescreen.HomeScreen
import com.akin.animeson.ui.splashscreen.SplashScreen

@ExperimentalMaterialApi

fun NavGraphBuilder.HomeNavGraph(
    navController: NavHostController,
    viewModel: HomeScreenViewModel
){
    navigation(
        startDestination = Screens.HomeScreen.route,
        route =HOME_GRAPH_ROUTE
    ){
        composable(Screens.SplashScreen.route) {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                SplashScreen(navController = navController)
            }

        }
        composable(route = Screens.HomeScreen.route) {

            if (!viewModel.isLoading.value) {
                Scaffold(
                    bottomBar = { BottomBar(navController = navController) }
                ) {
                   HomeScreen(viewModel = viewModel, navController =navController )

                }
                //HomeScreen(viewModel = viewModel, navController = navController)

            } else {
                Box(modifier = Modifier.fillMaxSize(), Alignment.BottomCenter) {
                    Loader()
                }
            }


        }
        composable(
            route = Screens.DetailsScreen.route + "/{animeId}",
            arguments = listOf(
                navArgument("animeId") {
                    type = NavType.StringType
                    defaultValue = "NnhCVhBJNJ"
                }

            )) {
            val returnAnimeId = remember {
                it.arguments?.getString("animeId")

            }
            DetailScreen(id = returnAnimeId!!)

        }
    }
}