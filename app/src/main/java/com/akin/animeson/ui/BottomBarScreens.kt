package com.akin.animeson.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector,


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
    object Search : BottomBarScreens(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object Chat : BottomBarScreens(
        route = "chat",
        title = "Chat",
        icon = Icons.Default.Chat
    )

}
