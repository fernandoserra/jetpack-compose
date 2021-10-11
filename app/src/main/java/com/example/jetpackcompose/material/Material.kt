package com.example.jetpackcompose.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Datos
import kotlinx.coroutines.launch

@Composable
fun AlertDialogDemo(){
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title")
                    },
                    text = {
                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the Confirm Button")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the dismiss Button")
                        }
                    }
                )
            }
        }
    }
}
@Preview
@Composable
fun PreviewAlertDialogDemo(){
    AlertDialogDemo();
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BadgeBoxDemo(){
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                BadgeBox(badgeContent = { Text("8") }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                }
            },
            selected = false,
            onClick = {})
    }
}

@Preview
@Composable
fun PreviewBadgeBoxDemo(){
    BadgeBoxDemo()
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
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite,"") },
        text = { Text("FloatingActionButton") },
        onClick = { /*do something*/ },
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    )
}

@Preview
@Composable
fun PreviewFloatingActionButtonDemo(){
    FloatingActionButtonDemo()
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
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column {
                Text("Text in Drawer")
                Button(onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }) {
                    Text("Close Drawer")
                }
            }
        },
        content = {
            Column {
                Text("Text in Bodycontext")
                Button(onClick = {

                    scope.launch {
                        drawerState.open()
                    }

                }) {
                    Text("Click to open")
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewModalDrawerLayoutDemo(){
    ModalDrawerLayoutDemo()
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
    var sliderPosition by remember { mutableStateOf(0f) }
    Text(text = sliderPosition.toString())
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
}

@Preview
@Composable
fun PreviewSliderDemo(){
    SliderDemo()
}

@Composable
fun SnackbarDemo(){
    Column {
        val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }

        Button(onClick = { setSnackBarState(!snackbarVisibleState) }) {
            if (snackbarVisibleState) {
                Text("Hide Snackbar")
            } else {
                Text("Show Snackbar")
            }
        }
        if (snackbarVisibleState) {
            Snackbar(

                action = {
                    Button(onClick = {}) {
                        Text("MyAction")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(text = "This is a snackbar!") }
        }
    }
}

@Preview
@Composable
fun PreviewSnackbarDemo(){
    SnackbarDemo()
}

@Composable
fun SwitchDemo(){
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Preview
@Composable
fun PreviewSwitchDemo(){
    SwitchDemo()
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
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text("Demo TopBar")
            },
            backgroundColor =  MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            })

        Text("Hello World")

    }
}
@Preview
@Composable
fun PreviewTopAppBarDemo(){
    TopAppBarDemo()
}