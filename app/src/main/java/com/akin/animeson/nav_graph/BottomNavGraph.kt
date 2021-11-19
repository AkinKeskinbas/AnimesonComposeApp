package com.akin.animeson.nav_graph

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.akin.animeson.domain.HomeScreenViewModel
import com.akin.animeson.ui.BottomBarScreens
import com.akin.animeson.ui.HOME_BOTTOM_GRAPH_ROUTE
import com.akin.animeson.ui.Screens
import com.akin.animeson.ui.homescreen.HomeScreen
import com.akin.animeson.ui.profile.ProfileScreen

@ExperimentalMaterialApi
fun NavGraphBuilder.BottomNavGraph(
    navController: NavController,
    viewModel: HomeScreenViewModel
){
    navigation(
        startDestination = Screens.HomeScreen.route,
        route = HOME_BOTTOM_GRAPH_ROUTE

    ){
        composable(route = BottomBarScreens.Home.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = BottomBarScreens.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreens.Search.route) {
            // SettingsScreen()
        }
        composable(route = BottomBarScreens.Chat.route) {
            // SettingsScreen()
        }
    }
}