package com.example.jetpackcompose.foundation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.R

/**
 * Link examples: https://foso.github.io/Jetpack-Compose-Playground/#foundation
 * */

@Composable
fun Canvas(){

}

@Composable
fun ImageDemo(){
    val image: Painter = painterResource(id = R.drawable.polynesia)
    Image(painter = image,contentDescription = "")
}

@Preview
@Composable
fun PreviewImageDemo(){
    ImageDemo()
}

@Composable
fun LazyColumn(){

}

@Composable
fun LazyRow(){

}

@Composable
fun LazyVerticalGrid(){

}

@Composable
fun Shape(){

}

@Composable
fun Text(){

}