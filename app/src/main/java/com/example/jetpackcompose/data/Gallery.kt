package com.example.jetpackcompose.data

data class Gallery(val title:String="",val url:String="") {

    fun listGallery()= mutableListOf(
        Gallery("Naturaleza 1","https://cdn.pixabay.com/photo/2015/12/01/20/28/forest-1072828_1280.jpg"),
        Gallery("Naturaleza 2","https://cdn.pixabay.com/photo/2015/01/28/23/35/hills-615429_1280.jpg"),
        Gallery("Naturaleza 3","https://cdn.pixabay.com/photo/2017/03/12/14/48/indian-almond-2137221_1280.jpg"),
        Gallery("Naturaleza 4","https://cdn.pixabay.com/photo/2021/07/21/08/33/lavenders-6482579_1280.jpg")
    )
}