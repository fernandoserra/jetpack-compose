package com.example.jetpackcompose.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Datos


@Composable
fun CardDemo(data: Datos){
    Card(modifier=Modifier.fillMaxWidth(),elevation = 5.dp)
    {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = data.titulo)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewCardDemo(){
    CardDemo(data = Datos(R.drawable.img_widget,"Ejemplo 1", emptyList()))
}