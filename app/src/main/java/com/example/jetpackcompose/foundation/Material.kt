package com.example.jetpackcompose.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Datos


@Composable
fun AlertDialogDemo(){

}

@Composable
fun BadgeBoxDemo(){

}

@Composable
fun ButtonDemo(){
    Button(onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Blue
    )) {
        Text("Button", color = Color.White)
    }
}

@Preview
@Composable
fun PreviewButtonDemo(){
    ButtonDemo()
}


@Composable
fun CardDemo(data: Datos){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier=Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 10.dp)
    {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(text = data.titulo)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewCardDemo(){
    CardDemo(data = Datos(R.drawable.img_widget,"Ejemplo 1", emptyList()))
}

@Composable
fun CircularProgressIndicatorDemo(){

}

@Composable
fun DropdownMenuDemo(){

}

@Composable
fun CheckboxDemo(){

}

@Composable
fun FloatingActionButtonDemo(){

}

@Composable
fun LinearProgressIndicatorDemo(){

}

@Composable
fun ModalDrawerLayoutDemo(){

}

@Composable
fun RadioButtonDemo(){

}

@Composable
fun ScaffoldDemo(){

}

@Composable
fun SliderDemo(){

}

@Composable
fun SnackbarDemo(){

}

@Composable
fun SwitchDemo(){

}

@Composable
fun SurfaceDemo(){

}

@Composable
fun TextFieldDemo(){
    Column(Modifier.padding(16.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        Text("Texto: " + textState.value.text)
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewTextFieldDemo(){
    TextFieldDemo()
}

@Composable
fun TopAppBarDemo(){

}