package com.example.todolistapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistapp.screens.LoginScreen
import com.example.todolistapp.screens.TodoListScreen
import com.example.todolistapp.viewModel.LoginViewModel
import com.example.todolistapp.viewModel.TodoListViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController, LoginViewModel())
        }

        composable(route = AppScreens.TodoListScreen.route) {
            TodoListScreen(navController, TodoListViewModel())
        }
    }
}