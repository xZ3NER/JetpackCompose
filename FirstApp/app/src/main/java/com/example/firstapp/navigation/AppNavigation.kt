package com.example.firstapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.firstapp.screens.FirstScreen
import com.example.firstapp.screens.SecondScreen

//Desde aquí manejaremos la navegación de las distintas pantallas de nuestra app
//(antes importar la libreria indicada en build.gradle)
@Composable
fun AppNavigation() {
    //Controlador de navegación que tenemos que propagar entre todas las pantallas,
    //ya que tenemos que acceder a él para trabajar la navegación (pasarlo como param)
    val navController = rememberNavController()

    //Necesita una ruta de inicio (startDestination)
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        //Un navhost esta formado por varios composable que define cada una de nuestras pantallas
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController)
        }

        //Si queremos pasar parametros a otra pantalla, definimos la key del parametro
        // como + "/{keyName}", luego una lista de navArguments con las llaves, y su tipo
        composable(route = AppScreens.SecondScreen.route + "/{text}" + "/{param2}",
        arguments = listOf(navArgument(name = "text") {
            type = NavType.StringType
        }, navArgument(name = "param2") {
            type = NavType.IntType
        })
            ) {
            //Aquí le pasamos la variable al SecondScreen, recuperando de sus argumentos (puede ser nulo)
            //la string q coincida con esa key
            SecondScreen(navController,it.arguments?.getString("text"),it.arguments?.getInt("param2"))
        }
    }
}