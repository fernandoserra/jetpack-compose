package com.example.jetpackcompose.foundation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Datos

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

/**
 * Una LazyColumn es una lista de desplazamiento vertical que solo compone y presenta
 * los elementos visibles actualmente. Es similar a un Recyclerview
 * en el sistema clásico de Android View.
 * */
@Composable
fun LazyColumnDemo(dataList:List<Datos>){
    LazyColumn(modifier = Modifier.fillMaxHeight()){
        itemsIndexed(items = dataList){ index, item ->
            CardDemo(data = item)
        }
    }
}

@Preview
@Composable
fun PrevioewLazyColumnDemo(){
    val datos = Datos()
    LazyColumnDemo(dataList = datos.listData())
}


/**
 * Un LazyRow es una lista de desplazamiento horizontal que solo
 * compone y presenta los elementos visibles actualmente.
 * Es similar a un Recyclerview horizontal en el sistema clásico de vista de Android.
 * */
@Composable
fun LazyRowDemo(dataList: List<Datos>){
    LazyRow(modifier = Modifier.fillMaxWidth()){
        itemsIndexed(dataList){index, item ->
            CardDemo(data = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRowDemo(){
    val datos = Datos()
    LazyRowDemo(dataList = datos.listData() )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridDemo(dataList: List<Datos>){

    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(dataList.size) { index ->
                Card(
                    backgroundColor = Color.Cyan,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    elevation = 8.dp,
                ) {
                    Text(
                        text = dataList[index].titulo,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp))
                }
            }
        }
    )
}

@Preview (showBackground = true)
@Composable
fun PreviewLazyVerticalGridDemo(){
    val datos = Datos()
    LazyVerticalGridDemo(dataList = datos.listData())
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