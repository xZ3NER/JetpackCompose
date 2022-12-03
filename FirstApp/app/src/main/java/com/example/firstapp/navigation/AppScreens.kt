package com.example.firstapp.navigation

//Para navegar sobre pantallas en jetpack, necesitamos una ruta
//(identificador que indica a qué pantalla queremos ir)
sealed class AppScreens(val route: String) {
    //Con esto limitamos las pantallas que tenemos en nuestra app,
    //para que a la hora de navegar, solamente podamos utilizar las que están definidas aquí
    object FirstScreen : AppScreens("first_screen")
    object SecondScreen : AppScreens("second_screen")
}
