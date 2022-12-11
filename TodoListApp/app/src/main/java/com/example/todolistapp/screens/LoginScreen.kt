package com.example.todolistapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolistapp.R
import com.example.todolistapp.navigation.AppScreens
import com.example.todolistapp.viewModel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController?, loginViewModel: LoginViewModel) {

    Scaffold() {
        LoginBodyContent(navController, loginViewModel)
    }
}

@Composable
fun LoginBodyContent(navController: NavController?, loginViewModel: LoginViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 100.dp)
            .padding(50.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UsernameTextField(
                loginViewModel
            )
            Spacer(modifier = Modifier.height(30.dp))
            PasswordTextField(
                navController,
                loginViewModel
            )
        }
        if (!loginViewModel.validPassword) {
            Box(
                modifier = Modifier.padding(start = 5.dp),
                contentAlignment = Alignment.CenterStart
            ) {

                Text(text = "Wrong password*", color = Color.Red, fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun UsernameTextField(loginViewModel: LoginViewModel) {
    TextField(
        value = loginViewModel.username,
        onValueChange = { loginViewModel.updateUsername(it) },
        label = { Text(text = stringResource(id = R.string.login_username)) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background
        ),
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun PasswordTextField(navController: NavController?, loginViewModel: LoginViewModel) {

    TextField(
        value = loginViewModel.password,
        onValueChange = { loginViewModel.updatePassword(it) },
        label = { Text(text = stringResource(id = R.string.login_password)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        visualTransformation =
        if (loginViewModel.pwdHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { loginViewModel.changeHidden() }) {
                val vector = painterResource(
                    if (loginViewModel.pwdHidden) R.drawable.ic_visibility
                    else R.drawable.ic_visibility_off
                )
                val description = null
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
            if (loginViewModel.checkPassword() && loginViewModel.checkUsername()) {
                navController?.navigate(AppScreens.TodoListScreen.route)
            } else {
                if (loginViewModel.validPassword) {
                    loginViewModel.changeValidStatePassword()
                }
            }
        }),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun LoginPreview() {
    LoginScreen(null, LoginViewModel())
}