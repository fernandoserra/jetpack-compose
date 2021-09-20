package com.example.jetpackcompose.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
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
        modifier= Modifier
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

/**
 * Un CircularProgressIndicator se puede utilizar para mostrar un progreso en forma circular.
 * Hay dos tipos: (Indeterminado,Determinado)
 * */

@Composable
fun CircularProgressIndicatorDemo(){
    CircularProgressIndicator()
    //CircularProgressIndicator(progress = 0.5f)
}

@Preview (showBackground = true)
@Composable
fun PreviewCircularProgressIndicatedDemo(){
    CircularProgressIndicatorDemo()
}


@Composable
fun DropdownMenuDemo(){

}

@Composable
fun CheckboxDemo(){
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Preview
@Composable
fun CheckboxDemoPreview(){
    CheckboxDemo()
}

@Composable
fun FloatingActionButtonDemo(){

}

/**
 * Un LinearProgressIndicator se puede utilizar para mostrar un progreso en línea lineal, también conocida como barra de progreso.
 * Hay dos tipos:
 * Indeterminado
 * Determinado
 * */
@Composable
fun LinearProgressIndicatorDemo(){
    LinearProgressIndicator()
    //LinearProgressIndicator(progress = 0.5f)
}

@Preview
@Composable
fun PreviewLinearProgressIndicatorDemo(){
    LinearProgressIndicatorDemo()
}

@Composable
fun ModalDrawerLayoutDemo(){

}

/**
 * Los botones de radio permiten a los usuarios seleccionar una opción de un conjunto.
 * */
@Composable
fun RadioButtonDemo(){
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RadioButtonDemoPreview(){
    RadioButtonDemo()
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