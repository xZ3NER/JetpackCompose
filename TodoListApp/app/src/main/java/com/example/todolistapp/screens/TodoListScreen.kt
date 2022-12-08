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
        items(todoListViewModel.listItems) {
            Item(it)
        }
    }
}

@Composable
fun Item(listItem: TodoList) {

    var rbSelected by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(
            selected = rbSelected,
            onClick = {
                rbSelected = !rbSelected
            })
        Spacer(modifier = Modifier.width(20.dp))
        ItemBody(title = listItem.title, body = listItem.body)
    }
}

@Composable
fun ItemBody(title: String, body: String) {
    var itemClicked by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            itemClicked = !itemClicked
        }) {
        Text(
            text = title,
            fontSize = 20.sp,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1
        )
        if (itemClicked) Text(text = body, style = MaterialTheme.typography.subtitle2)
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun TodoListPreview() {
    TodoListScreen(null, TodoListViewModel())
}