package com.example.firstapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstapp.dataClasses.ListItem
import com.example.firstapp.navigation.AppScreens

//Cada pantalla navegable tiene q estar dividido, y tendrá un método composable
//con el mismo nombre que la clase, que inicia toda la vista de la pantalla
@Composable
fun FirstScreen(navController: NavController) {
    //Un componente que permite estructurar elementos típicos (barra superior...) de una pantalla
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "FirstScreen")
        }
    }) {
        FirstBodyContent(navController)
    }
}

@Composable
fun FirstBodyContent(navController: NavController) {
    Column() {
        Button(
            onClick = {
                //Navegamos a la siguiente pantalla gracias al navController,
                //y le pasamos el valor del parametro con + "/valorParam"
                navController.navigate(route = AppScreens.SecondScreen.route + "/Este es un parámetro"+"/7")
            }, modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Text(text = "Navigate")
        }
        MyList(items = list)
    }
}

@Composable
fun MyList(items: List<ListItem>) {
    /*
        Si es para una lista, es mejor un LazyColumn,
        ya que solo renderiza elementos que si serán visibles en pantalla,
        reduciendo la memoria consumida y mejorando la fluidez al navegar.
    */
    LazyColumn() {
        //Items es como un iterador (parecido al forEach)
        items(items) { item ->
            MyItem(item)
        }
    }
}

@Composable
private fun MyItem(listItem: ListItem) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
    ) {
        MyImage()

        /*En jetpack compose, las vistas no podrán variar (por ejemplo id.setText), por lo que
        * se tendrán que pintar cada vez que se actualice algo, en este caso utilizaremos
        * una variable que mute, y que al cambiar su estado, repinte la vista
        * utilizando by remember{mutableStateOf(valor del var)}*/
        var textExpanded by remember { mutableStateOf(false) }

        //Podemos indicar en que lugar se aplica el modificador, p.ej 'start'
        Column(modifier = Modifier
            .padding(start = 8.dp)
            .clickable {
                /*Al hacer click sobre la vista de la columna, se actualiza la variable mutable y se
            * repinta su contenido*/
                textExpanded = !textExpanded
            }) {
            MyTextView(
                text = listItem.title,
                MaterialTheme.colors.onBackground,
                MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(15.dp))
            MyTextView(
                text = listItem.body,
                MaterialTheme.colors.primary,
                MaterialTheme.typography.subtitle2,
                //Al repintar, haremos una accion u otra dependiendo de la variable mutable
                if (textExpanded) Int.MAX_VALUE else 1
            )
        }
    }
}

@Composable
fun MyTextView(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    //TextView
    Text(text = text, color = color, style = style, maxLines = lines)
}

@Composable
fun MyImage() {
    Image(
        painterResource(com.example.firstapp.R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        //Se pueden concatenar modificadores
        modifier = Modifier
            .clip(CircleShape)
            //Al tener nuestro Tema (FirstAppTheme) como padre, podemos utilizar
            //todas sus propiedades que está definido.
            //Nuestro tema hereda de Material Design, por lo que podemos acceder a MaterialTheme
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
    )
}

private val list: List<ListItem> = listOf(
    ListItem(
        "Item 1",
        "Cuerpo 1 Yet bed any for travelling assistance indulgence unpleasing. Not thoughts all exercise blessing. Indulgence way everything joy alteration boisterous the attachment. Party we years to order allow asked of. We so opinion friends me message as delight. Whole front do of plate heard oh ought. His defective nor convinced residence own. Connection has put impossible own apartments boisterous. At jointure ladyship an insisted so humanity he. Friendly bachelor entrance to on by."
    ),
    ListItem(
        "Item 2",
        "Cuerpo 2 Made last it seen went no just when of by. Occasional entreaties comparison me difficulty so themselves. At brother inquiry of offices without do my service. As particular to companions at sentiments. Weather however luckily enquire so certain do. Aware did stood was day under ask. Dearest affixed enquire on explain opinion he. Reached who the mrs joy offices pleased. Towards did colonel article any parties.\n"
    ),
    ListItem(
        "Item 3",
        "Cuerpo 3 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 4",
        "Cuerpo 4 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 5",
        "Cuerpo 5 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 6",
        "Cuerpo 6 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 7",
        "Cuerpo 7 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 8",
        "Cuerpo 8 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 9",
        "Cuerpo 9 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 10",
        "Cuerpo 10 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 11",
        "Cuerpo 11 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    ),
    ListItem(
        "Item 12",
        "Cuerpo 12 So feel been kept be at gate. Be september it extensive oh concluded of certainty. In read most gate at body held it ever no. Talking justice welcome message inquiry in started of am me. Led own hearted highest visited lasting sir through compass his. Guest tiled he quick by so these trees am. It announcing alteration at surrounded comparison."
    )
)