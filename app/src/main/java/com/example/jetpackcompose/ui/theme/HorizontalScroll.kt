package com.example.jetpackcompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Gallery
import com.example.jetpackcompose.utils.LoadImageUrl

fun listImages()= mutableListOf(
    R.drawable.polynesia,
    R.drawable.mountain,
    R.drawable.img_widget
)

@Composable
fun HorizontalScroll(){
    LazyRow(
        modifier = Modifier.fillMaxSize()){
        itemsIndexed(items = listImages()){index,item->
            Image(
                painter = painterResource(id = item),
                contentDescription = "Naturaleza",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .fillParentMaxWidth()
               )
        }
    }
}


@Composable
fun HorizontalScrollImagen(){
    val gallery=Gallery()
    LazyRow(
        modifier = Modifier.fillMaxSize()){
        itemsIndexed(items = gallery.listGallery()){index,item->

            val imagen = LoadImageUrl(item.url).value

            imagen?.let {img->
                Image(
                    bitmap=img.asImageBitmap(),
                    contentDescription = "Naturaleza",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(300.dp)
                        .fillParentMaxWidth()
                )
            }

        }
    }
}

@Preview
@Composable
fun HorizontalScrollPreview(){
    HorizontalScroll()
}