package com.example.jetpackcompose.foundation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.R

/**
 * Link examples: https://foso.github.io/Jetpack-Compose-Playground/#foundation
 * */

@Composable
fun CanvasDemo(){

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
fun LazyColumnDemo(){

}

@Composable
fun LazyRowDemo(){

}

@Composable
fun LazyVerticalGridDemo(){

}

@Composable
fun ShapeDemo(){

}

@Composable
fun TextDemo(){
    Column {
        Text("Hola mundo")
        Text("Hola mundo cursiva" , style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Hola mundo underline, linethrough and bold",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                        TextDecoration.LineThrough
                    )
                ), fontWeight = FontWeight.Bold
            )
        )
    }

}

@Preview (showBackground = true)
@Composable
fun PreviewTextDemo(){
    TextDemo()
}