package com.example.todolistapp.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object TodoListScreen: AppScreens("todo_list_screen")
}
