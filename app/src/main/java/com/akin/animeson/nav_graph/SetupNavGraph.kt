package com.akin.animeson.nav_graph

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.akin.animeson.domain.HomeScreenViewModel
import com.akin.animeson.ui.HOME_GRAPH_ROUTE
import com.akin.animeson.ui.ROOT_GRAPH_ROUTE

@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: HomeScreenViewModel
) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {

        HomeNavGraph(navController = navController, viewModel)
        BottomNavGraph(navController = navController, viewModel = viewModel)

    }
}