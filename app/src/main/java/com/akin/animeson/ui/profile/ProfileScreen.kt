package com.akin.animeson.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        println("test")
        Text(text ="Profile Screen",style = TextStyle(color = MaterialTheme.colors.primaryVariant,fontSize = 32.sp) )
    }
}