package com.example.todolistapp.viewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.todolistapp.dataClasses.TodoList

class TodoListViewModel() : ViewModel() {

    //TODO Not well implemented
    private var _todoList = getListItems().toMutableStateList()
    val list: List<TodoList>
        get() = _todoList

//    fun remove(item: TodoList) {
//        _todoList.remove(item)
//    }

    fun changeChecked(item: TodoList) =
        list.find { it.title == item.title }?.let { todoItem ->
            todoItem.checked = !todoItem.checked
            _todoList.add(_todoList.indexOf(item),todoItem)
            _todoList.remove(item)
        }
}

private fun getListItems() = List(30) { i -> TodoList("TITLE $i","body $i",false) }
