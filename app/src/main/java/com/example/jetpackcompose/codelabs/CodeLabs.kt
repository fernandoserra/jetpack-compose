package com.example.jetpackcompose.codelabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


/**
 * Modificadores
 * Los modificadores te permiten decorar un componible.
 * Puede cambiar su comportamiento, apariencia, agregar información como etiquetas de
 * accesibilidad, procesar la entrada del usuario o incluso agregar interacciones de alto nivel,
 * como hacer que se pueda hacer clic, desplazar, arrastrar o ampliar en algo. Los modificadores
 * son objetos regulares de Kotlin. Puede asignarlas a variables y reutilizarlas. También puede
 * encadenar varios modificadores uno tras otro para componerlos.
 * */
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .padding(8.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(MaterialTheme.colors.surface)
        .clickable(onClick = { /* Ignoring onClick */ })
        .padding(16.dp)) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column(modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewPhotographerCard(){
    PhotographerCard()
}


/**
 * Scaffold
 *
 * Scaffoldle permite implementar una interfaz de usuario con la estructura de
 * diseño básica de Material Design. Proporciona ranuras para los componentes de
 * material de nivel superior más comunes, como TopAppBar , BottomAppBar ,
 * FloatingActionButton y Drawer . Con Scaffold, te aseguras de que estos componentes
 * se colocarán y trabajarán juntos correctamente.
 * */

@Composable
fun LayoutsCodelab() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ){ innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}


@Preview
@Composable
fun PreviewLayoutsCodelab() {
    JetpackComposeTheme{
        LayoutsCodelab()
    }
}

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}