package com.akin.animeson.ui.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.akin.animeson.R
import com.akin.animeson.ui.HOME_GRAPH_ROUTE
import com.akin.animeson.ui.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen( navController : NavController) {

    val scale = remember {
        Animatable(0f)

    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)

        navController.popBackStack()
        navController.navigate(Screens.HomeScreen.route)
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = "Animeson",
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.animesonlogo),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value),
                alignment = Alignment.BottomCenter
            )
        }

    }
}