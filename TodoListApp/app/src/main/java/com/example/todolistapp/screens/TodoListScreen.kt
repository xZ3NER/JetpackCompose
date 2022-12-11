package com.example.todolistapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolistapp.dataClasses.TodoList
import com.example.todolistapp.viewModel.TodoListViewModel

@Composable
fun TodoListScreen(navController: NavController?, todoListViewModel: TodoListViewModel) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable { navController?.popBackStack() })
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "TodoList")
        }
    }) {
        TodoListBodyContent(navController, todoListViewModel)
    }
}

@Composable
fun TodoListBodyContent(navController: NavController?, todoListViewModel: TodoListViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        items(todoListViewModel.list) {
            Item(it,todoListViewModel) {
                todoListViewModel.changeChecked(it)
            }
        }
    }
}

@Composable
fun Item(listItem: TodoList,todoListViewModel: TodoListViewModel, changeCheck: () -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(
            selected = listItem.checked,
            onClick = {
               changeCheck()
            })
        Spacer(modifier = Modifier.width(20.dp))
        ItemBody(listItem) {
            todoListViewModel.changeClicked(listItem)
        }
    }
}

@Composable
fun ItemBody(listItem: TodoList,changeClick: () -> Unit) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            changeClick()
        }) {
        Text(
            text = listItem.title,
            fontSize = 20.sp,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1
        )
        if (listItem.clicked) Text(text = listItem.body, style = MaterialTheme.typography.subtitle2)
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun TodoListPreview() {
    TodoListScreen(null, TodoListViewModel())
}