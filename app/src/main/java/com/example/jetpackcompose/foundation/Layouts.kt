package com.example.jetpackcompose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R


/**
 * Los elementos secundarios del diseño de Box se apilarán unos sobre otros.
 * Puede utilizar el modificador de alineación para especificar dónde se debe dibujar el componible.
 * */
@Composable
fun BoxDemo(){
    //Box(Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {
    Box(Modifier.fillMaxSize().background(color = Color.Cyan)) {
        Box(
            Modifier.align(Alignment.TopCenter).size(180.dp, 300.dp).background( Color.Blue)
        )
        Text("Ejemplos con Box", modifier = Modifier.align(Alignment.Center), fontSize = 24.sp)
    }
}

@Preview
@Composable
fun PreviewBoxDemo(){
    BoxDemo()
}

@Composable
fun BoxWithConstraintsDemo(){

}


@Composable
fun ColumnDemo(){

}


@Composable
fun ConstraintLayoutDemo(){

}


@Composable
fun RowDemo(){

}


@Composable
fun SpacerDemo(){

}
