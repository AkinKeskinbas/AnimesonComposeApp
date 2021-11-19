package com.akin.animeson.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home : BottomBarScreens(
        route = Screens.HomeScreen.route,
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile : BottomBarScreens(
        route = Screens.ProfileScreen.route,
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Settings : BottomBarScreens(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )

}
