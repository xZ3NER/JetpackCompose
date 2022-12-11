package com.example.todolistapp.viewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.todolistapp.dataClasses.TodoList

class TodoListViewModel() : ViewModel() {

    var list = getListItems().toMutableStateList()
        private set

    fun changeChecked(item: TodoList) {
        list.find { it.title == item.title }?.let { it ->
            val index = list.indexOf(it)
            list[index] = list[index].copy(checked = !it.checked)
        }
    }


    fun changeClicked(item: TodoList) {
        list.find { it.title == item.title }?.let { it ->
            val index = list.indexOf(it)
            list[index] = list[index].copy(clicked = !it.clicked)
        }
    }

    fun deleteItem(item:TodoList) {
        list.remove(item)
    }

}

private fun getListItems() = List(30) { i -> TodoList("TITLE $i","body $i", checked = false, clicked = false) }
