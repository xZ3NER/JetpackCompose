package com.example.firstapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, text: String?, param2: Int?) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "SecondScreen")
        }
    }) {
        SecondBodyContent(navController,text,param2)
    }
}

@Composable
fun SecondBodyContent(navController: NavController, text: String?, param2: Int?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Volver")

        //Si no es nulo, pinta un nuevo elemento texto con su contenido
        text?.let {
            Text(text = it)
        }
        
        param2?.let { 
            Text(text = "Parametro 2 con valor: $it")
        }

        Button(onClick = {
            //Vuelve a la pantalla anterior
            navController.popBackStack()
        }) {
            Text(text = "Navega")
        }
    }
}