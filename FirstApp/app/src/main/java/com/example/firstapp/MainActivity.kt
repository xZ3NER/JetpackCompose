package com.example.firstapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstAppTheme

private val list: List<ListItem> = listOf(
    ListItem("Item 1", "Cuerpo 1"),
    ListItem("Item 2", "Cuerpo 2"),
    ListItem("Item 3", "Cuerpo 3"),
    ListItem("Item 4", "Cuerpo 4"),
    ListItem("Item 5", "Cuerpo 5"),
    ListItem("Item 7", "Cuerpo 6"),
    ListItem("Item 8", "Cuerpo 7"),
    ListItem("Item 9", "Cuerpo 8"),
    ListItem("Item 10", "Cuerpo 9"),
    ListItem("Item 11", "Cuerpo 10"),
    ListItem("Item 12", "Cuerpo 11"),
    ListItem("Item 13", "Cuerpo 12")
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Lugar donde llamaremos a nuestros componentes Composable,
        que conformarán nuestra interfaz de usuario*/
        setContent {
            //El tema tendra el mismo nombre que el proyecto (NombreProyectoTheme)
            //Podremos modificar el tema en el directorio ui/theme
            FirstAppTheme {
                MyList(items = list)
            }
        }
    }
}

@Composable
fun MyTextView(text: String, color: Color, style: TextStyle) {
    //TextView
    Text(text = text, color = color, style = style)
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
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

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    FirstAppTheme {
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
        //Podemos indicar en que lugar se aplica el modificador, p.ej 'start'
        Column(modifier = Modifier.padding(start = 8.dp)) {
            MyTextView(
                text = listItem.title,
                MaterialTheme.colors.onBackground,
                MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(15.dp))
            MyTextView(
                text = listItem.body,
                MaterialTheme.colors.primary,
                MaterialTheme.typography.subtitle2
            )
        }
    }
}

