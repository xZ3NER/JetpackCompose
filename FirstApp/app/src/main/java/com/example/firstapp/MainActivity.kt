package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapp.navigation.AppNavigation
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*Lugar donde llamaremos a nuestros componentes Composable,
        que conformarán nuestra interfaz de usuario*/
        setContent {
            //El tema tendra el mismo nombre que el proyecto (NombreProyectoTheme)
            //Podremos modificar el tema en el directorio ui/theme
            FirstAppTheme {
                //Aquí llamaremos al componente que se encarga de gestionar la navegación
                //(Lo creamos nosotros, x lo que sabe cual es la primera pantalla)
                AppNavigation()
            }
        }
    }

    @Preview(showSystemUi = false)
    @Composable
    fun DefaultPreview() {
        FirstAppTheme {
            AppNavigation()
        }
    }

}



