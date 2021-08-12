package com.example.jetpackcompose.accompanist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun Pager(){
    // Display 10 items
    val pagerState = rememberPagerState(pageCount = 10)
    HorizontalPager(state = pagerState) { page ->
        // Our page content
        Text(
            text = "Page: $page",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

fun listImages()= mutableListOf(
    R.drawable.polynesia,
    R.drawable.mountain,
    R.drawable.img_widget
)

@ExperimentalPagerApi
@Composable
fun Pager2(){
    // Display 10 items
    val pagerState = rememberPagerState(pageCount = listImages().size)

    HorizontalPager(state = pagerState) { page ->
        // Our page content
        Image(
            painter = painterResource(id = listImages()[page]),
            contentDescription = "Naturaleza",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
        )
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun PagerPreview(){
    Pager()
}