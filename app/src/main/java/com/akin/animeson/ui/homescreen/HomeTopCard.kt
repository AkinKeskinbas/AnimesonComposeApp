package com.akin.animeson.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.akin.animeson.R

@Composable

fun HomeTopCard(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier,
    contentDesc: String,
    navController: NavController?
) {
    Card(
        modifier = modifier.fillMaxWidth().fillMaxHeight(0.5f),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp

    ) {
        Box(modifier = Modifier.height(200.dp).fillMaxWidth()) {
            val painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    placeholder(R.drawable.ic_launcher_background)
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
                Text(modifier = Modifier.fillMaxWidth(),text = title, style = TextStyle(Color.White, fontSize = 32.sp),textAlign = TextAlign.Center)
            }
        }
    }

}


@Preview
@Composable
fun HomeTopCardPreview() {
    HomeTopCard(
        navController = null,
        imageUrl = "https://i.pinimg.com/564x/05/06/7b/05067b11f2d8ed9a8454357bf1b0799b.jpg",
        title = "test",
        modifier = Modifier,
        contentDesc = "test"
    )
}