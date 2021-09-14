package com.example.jetpackcompose.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun MainContent(){
    Box(
        Modifier
            .background(Color(0xFFEDEAE0))
            .fillMaxSize()
            .padding(8.dp)
    ) {
        val uuids = remember { mutableStateListOf<String>() }

        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(uuids) { index, item ->




                val state = rememberDismissState(
                    confirmStateChange = {
                        if(it== DismissValue.DismissedToStart){

                            uuids.remove(item)

                           // Log.i("RvTeamsFavorites", "RvTeamsFavorites: ${dat}")
                           // team.remove(team[dat])
                           // Log.i("RvTeamsFavorites", "RvTeamsFavorites: ${team.size}")
                        }
                        true
                    }
                )


                SwipeToDismiss(state = state , background ={},dismissContent = {

                    val visibility by remember {
                        mutableStateOf(
                            uuids.contains(item) && item == uuids[index]
                        )
                    }

                    AnimatedVisibility(
                        visible = visibility
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(
                                    align = Alignment.CenterVertically
                                ),
                            elevation = 4.dp,
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = if (index % 2 == 0)
                                Color(0xFF9C27B0) else Color(0xFF673AB7)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = item.take(5).capitalize(),
                                    modifier = Modifier.padding(
                                        start = 12.dp, top = 12.dp,
                                        end = 12.dp, bottom = 4.dp
                                    ),
                                    textAlign = TextAlign.Center,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                TextButton(
                                    onClick = { uuids.remove(item) },
                                    colors = ButtonDefaults.textButtonColors(
                                        backgroundColor = Color(0xFF960018),
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(text = "Eliminar")
                                }
                            }
                        }
                    }

                }) //Fin SwipeToDismiss



            }
        }

        FloatingActionButton(
            onClick = {
                UUID.randomUUID().toString().apply {
                    uuids.add(this)
                }
            },
            Modifier.align(Alignment.BottomEnd),
            backgroundColor = Color(0xFFFE4164)
        ) { Icon(Icons.Filled.Add,"") }
    }
}


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewComposable(){
    MainContent()
}