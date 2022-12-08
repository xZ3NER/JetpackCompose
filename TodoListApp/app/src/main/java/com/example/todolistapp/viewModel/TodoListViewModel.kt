package com.example.todolistapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.dataClasses.TodoList

class TodoListViewModel(): ViewModel() {

    val listItems = listOf(
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
}