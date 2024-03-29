package com.akin.animeson.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.akin.animeson.ui.Screens


@ExperimentalMaterialApi
@Composable

fun HomeCard(
    imageUrl: String,
    title: String,
    episode: String?,
    modifier: Modifier = Modifier,
    contentDesc: String,
    navController: NavController?,
    animeId:String

) {
    Card(
        modifier = modifier.width(200.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        onClick = {
            navController?.navigate(Screens.DetailsScreen.withArgs(animeId))
        }



    ) {
        Box(modifier = Modifier.height(200.dp)) {
            val painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    placeholder(com.akin.animeson.R.drawable.ic_launcher_background)
                })
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painter,
                contentDescription = contentDesc,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Text(text = title, style = TextStyle(Color.White, fontSize = 16.sp))
                    Text(text ="Bölüm: ${episode.toString()}" , style = TextStyle(Color.White, fontSize = 16.sp))
                }

            }
        }
    }

}


@ExperimentalMaterialApi
@Preview
@Composable
fun test() {
    HomeCard(
        navController = null,
        imageUrl = "https://i.pinimg.com/564x/05/06/7b/05067b11f2d8ed9a8454357bf1b0799b.jpg",
        title = "test",
        episode = "test",
        modifier = Modifier,
        contentDesc = "test",
        animeId = "test"


    )
}