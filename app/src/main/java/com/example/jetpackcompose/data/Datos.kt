package com.example.jetpackcompose.data

import androidx.annotation.DrawableRes
import com.example.jetpackcompose.R

data class Datos(@DrawableRes val image:Int=R.drawable.img_widget, val titulo:String="", val otros:List<String> =  listOf("1")){
    
    fun listData(): List<Datos> {
        return listOf(
             Datos(R.drawable.img_widget, "Registro 1", listOf("1", "2", "3")),
             Datos(R.drawable.img_widget, "Registro 2", listOf("1", "2", "3")),
             Datos(R.drawable.img_widget, "Registro 3", listOf("1", "2", "3"))
         )
    }
}