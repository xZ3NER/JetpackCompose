package com.example.todolistapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistapp.R
import com.example.todolistapp.navigation.AppScreens

@Composable
fun LoginScreen(navController: NavController) {

    Scaffold() {
        LoginBodyContent(navController)
    }
}

@Composable
fun LoginBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            label = stringResource(id = R.string.login_username),
            false,
            navController
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            label = stringResource(id = R.string.login_password),
            true,
            navController
        )
    }
}

@Composable
fun TextField(label: String, isPassword: Boolean, navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    if (!isPassword) {

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(label) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background
            )
        )

    } else {
        var hidden by remember { mutableStateOf(isPassword) }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(label) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            visualTransformation =
            if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(onClick = { hidden = !hidden }) {
                    val vector = painterResource(
                        if (hidden) R.drawable.ic_visibility
                        else R.drawable.ic_visibility_off
                    )
                    val description = if (hidden) "Hide password" else "Show password"
                    Icon(
                        painter = vector,
                        contentDescription = description,
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background
            ),
            keyboardActions = KeyboardActions(onDone = {
                if (text == "passwd") {
                    navController.navigate(AppScreens.TodoListScreen.route)
                }
            })
        )
    }
}