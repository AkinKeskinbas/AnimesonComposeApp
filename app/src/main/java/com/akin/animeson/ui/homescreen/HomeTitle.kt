package com.akin.animeson.ui.homescreen


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


@Composable
fun HomeTitle(
    title: String,
    modifier: Modifier = Modifier,
    color: Color,
    size: TextUnit,
    fontFamily: FontFamily?,
    alignment: TextAlign,

) {
    Text(
        text = title,
        modifier = modifier.padding(8.dp).fillMaxWidth(),
        style = TextStyle(
            color = color,
            fontSize = size,
            fontFamily = fontFamily,
            textAlign = alignment,


        )
    )

}