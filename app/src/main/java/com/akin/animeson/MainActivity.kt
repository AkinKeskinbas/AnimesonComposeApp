package com.akin.animeson

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.akin.animeson.domain.HomeScreenViewModel
import com.akin.animeson.nav_graph.SetupNavGraph
import com.akin.animeson.ui.BottomBar
import com.akin.animeson.ui.Screens
import com.akin.animeson.ui.theme.AnimesonComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @SuppressLint("RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimesonComposeTheme {
                val viewModel: HomeScreenViewModel = hiltViewModel()
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                if (currentRoute!=Screens.SplashScreen.route){
                    Scaffold(
                        bottomBar = {  BottomBar(navController = navController) }

                    ) {
                        SetupNavGraph(navController = navController, viewModel =viewModel )

                    }
                }else{
                    SetupNavGraph(navController = navController, viewModel =viewModel )
                }


            }
        }
    }
}


@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loadingchikka))
    LottieAnimation(composition)

}

@Preview
@Composable
fun TestHome() {
    AnimesonComposeTheme() {

    }
}



