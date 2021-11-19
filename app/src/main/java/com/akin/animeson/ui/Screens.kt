package com.akin.animeson.ui

const val HOME_GRAPH_ROUTE = "home"
const val HOME_BOTTOM_GRAPH_ROUTE = "bottomNav"
const val ROOT_GRAPH_ROUTE = "root"
sealed class Screens(val route:String){
    object HomeScreen : Screens("animeson_home_screen")
    object SplashScreen : Screens("animeson_splash_screen")
    object DetailsScreen : Screens("animeson_detail_screen")
    object ProfileScreen : Screens("animeson_profile_screen")

    fun withArgs(vararg args: String):String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}

