package com.akin.animeson.ui.detailscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(id:String){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text =id,style = TextStyle(color = MaterialTheme.colors.primaryVariant,fontSize = 32.sp) )
    }
}