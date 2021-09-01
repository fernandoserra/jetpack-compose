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
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Cyan)) {
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .size(180.dp, 300.dp)
                .background(Color.Blue)
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

/**
 * Una columna mostrará a cada niño debajo de los niños anteriores.
 * Es similar a LinearLayout con orientación vertical.
 * */
@Composable
fun ColumnDemo(){
    Column {
        Text(text = "Mensaje 1", Modifier.padding(10.dp))
        Text(text = "Mensaje 2", Modifier.padding(10.dp))
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewColumnDemo(){
    ColumnDemo()
}


@Composable
fun ConstraintLayoutDemo(){

}

/**
 * Una fila mostrará a cada niño junto a los niños anteriores.
 * Es similar a LinearLayout con orientación horizontal.
 * */
@Composable
fun RowDemo(){
    Row {
       Text(text = "Mensaje 1", Modifier.padding(10.dp))
       Text(text = "Mensaje 2", Modifier.padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRowDemo(){
    RowDemo()
}

/**
 * Spacer es un Composable que se puede usar cuando desee agregar
 * un espacio adicional entre Composables
 * */
@Composable
fun SpacerDemo(){
    Column {
        Text(text = "Mensaje 1")
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Mensaje 2")
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewSpacerDemo(){
    SpacerDemo()
}
