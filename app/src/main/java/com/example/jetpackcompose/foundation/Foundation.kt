package com.example.jetpackcompose.foundation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column{
        TypeShape(shape = RectangleShape)
        Spacer(modifier = Modifier.height(10.dp))
        TypeShape(shape = CircleShape)
        Spacer(modifier = Modifier.height(10.dp))
        TypeShape(shape = RoundedCornerShape(10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        TypeShape(shape = CutCornerShape(10.dp))
    }

}

@Composable
fun TypeShape(shape: Shape){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(shape)
                .background(Color.Red)
        )
    }
}


@Preview
@Composable
fun PreviewShapeDeo(){
    ShapeDemo()
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