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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolistapp.R
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
            .fillMaxSize()
            .padding(15.dp)
    ) {
        items(todoListViewModel.list) {
            Item(it,todoListViewModel)
        }
    }
}

@Composable
fun Item(listItem: TodoList,todoListViewModel: TodoListViewModel) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            RadioButton(
                selected = listItem.checked,
                onClick = {
                    todoListViewModel.changeChecked(listItem)
                })
            Spacer(modifier = Modifier.width(10.dp))
            ItemBody(listItem) {
                todoListViewModel.changeClicked(listItem)
            }
        }
        if (listItem.checked){
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_bin),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            todoListViewModel.deleteItem(listItem)
                        },
                )
            }
        }
    }
}

@Composable
fun ItemBody(listItem: TodoList,changeClick: () -> Unit) {

    Column(modifier = Modifier
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