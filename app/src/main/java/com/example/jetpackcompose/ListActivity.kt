package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.data.Datos

val list= Datos()

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column{
                TopAppBar() {
                    Text(text = "Listado ")
                }
                Divider(color = Color.Black)

                ReciDataList(dataList = list.listData())
            }

        }

    }
}

@Composable
fun CardShow(dato: Datos, onDatosClick: (Datos) -> Unit){

    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp,modifier = Modifier.padding(8.dp)  ) {
        //LinearLayout de orientacion vertical
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier= Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))

            Image( painterResource(R.drawable.img_widget) ,  contentDescription = "",modifier = imageModifier,contentScale = ContentScale.Crop) 
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = dato.titulo, fontSize = 30.sp, modifier=Modifier.clickable (onClick = { onDatosClick(dato) } ), style = typography.h2)

            for( data in dato.otros){
                Text(text = data,style = typography.h5, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }

        //Linear layout Horizontal
        /*Row() {
        }*/
    }

}

@Composable
fun ReciDataList(dataList:List<Datos>){
    val context = LocalContext.current
    LazyColumn(){
        items(dataList.size){ dat->
           CardShow(dato = dataList[dat], onDatosClick = {
               Toast.makeText(context, "Elemento ${it}", Toast.LENGTH_LONG)
                   .show()
           })
        }
    }
}


@Preview
@Composable
fun Preview(){
    CardShow(list,onDatosClick = {})
}
