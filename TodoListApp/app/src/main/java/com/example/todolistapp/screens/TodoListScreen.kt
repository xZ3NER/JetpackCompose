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

val list = listOf(
    TodoList("TITLE 1", "body 1"),
    TodoList("TITLE 2", "body 2"),
    TodoList("TITLE 3", "body 3"),
    TodoList("TITLE 4", "body 4"),
    TodoList("TITLE 5", "body 5"),
    TodoList("TITLE 6", "body 6"),
    TodoList("TITLE 7", "body 7"),
    TodoList("TITLE 8", "body 8"),
    TodoList("TITLE 9", "body 9"),
    TodoList("TITLE 10", "body 10"),
    TodoList("TITLE 11", "body 11"),
    TodoList("TITLE 12", "body 12"),
    TodoList("TITLE 13", "body 13"),
    TodoList("TITLE 14", "body 14"),
    TodoList("TITLE 15", "body 15"),
    TodoList("TITLE 15", "body 15"),
    TodoList("TITLE 15", "body 15"),
    TodoList(
        "Jetpack Compose",
        "Ver videos de jetpack compone, mutablestateOf, variables, modificarlos, etc...Ver videos de jetpack compone, mutablestateOf, variables, modificarlos, etc...Ver videos de jetpack compone, mutablestateOf, variables, modificarlos, etc...Ver videos de jetpack compone, mutablestateOf, variables, modificarlos, etc..."
    )
)

@Composable
fun TodoListScreen(navController: NavController?) {
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable { navController?.popBackStack() })
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "TodoList")
        }
    }) {
        TodoListBodyContent(navController)
    }
}

@Composable
fun TodoListBodyContent(navController: NavController?) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        items(list) {
            PaintItem(it)
        }
    }
}

@Composable
fun PaintItem(listItem: TodoList) {

    var selected by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        RadioButton(selected = selected, onClick = {
            selected = !selected
        })
        Spacer(modifier = Modifier.width(20.dp))
        Item(title = listItem.title, body = listItem.body)
    }

}

@Composable
fun Item(title: String, body: String) {
    var clicked by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            clicked = !clicked
        }) {
        Text(
            text = title,
            fontSize = 20.sp,
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1
        )
        if (clicked) Text(text = body, style = MaterialTheme.typography.subtitle2)
    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun TodoListPreview() {
    TodoListScreen(null)
}