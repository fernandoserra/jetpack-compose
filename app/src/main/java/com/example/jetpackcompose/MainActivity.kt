package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.accompanist.Pager
import com.example.jetpackcompose.accompanist.Pager2
import com.example.jetpackcompose.ui.theme.HorizontalScroll
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //JetpackComposeTheme {
            //AppTheme {
                // A surface container using the 'background' color from the theme
                //Surface(color = MaterialTheme.colors.background) {
                    Column {
                        /*Greeting("Android")
                        Divider(color = Color.Black)
                        Greeting("Android2")
                        Divider(color = Color.Black)
                        Greeting("Android3")
                        Divider(color = Color.Black)
                        ButtonToast()
                        Divider(color = Color.Black)
                        ButtonRedirect()


                        //HorizontalScroll()
                        //Pager()
                        Divider(color = Color.Black)*/
                        Pager2()
                     }



                //}
           // }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", Modifier.padding(24.dp))

}

@Preview(name="Default",showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Greeting("Android")
        Msj()
    }
}

/*Nombres de  funciones Composable es preferible
  colocarla en mayuscula para no confundirlas con
  el nombre de una funcion normalmente*/
@Composable
fun Msj(){
    val size=55.sp
    AppTheme() {
        Text(text = "Hola 22", fontSize = size)
    }
}

@Composable
fun ButtonToast(){
    val context = LocalContext.current
    Button(onClick = {
       Toast.makeText(context, "You just clicked a Clickable", Toast.LENGTH_LONG)
            .show()
    }) {
        Text(text = "Toas")
    }
}

@Composable
fun ButtonRedirect(){
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(Intent(
            context,
            ListActivity::class.java
        ))
    }) {
        Text(text = "Redireccionar")
    }
}

@Composable
fun AppTheme(content:@Composable() () ->Unit){
    JetpackComposeTheme{
        Surface(color= Color.Cyan) {
            Column() {
                content()
            }

        }
    }
}