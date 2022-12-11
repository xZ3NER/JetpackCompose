package com.example.todolistapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel(): ViewModel() {

    var username by mutableStateOf("")
        private set

    fun updateUsername(text:String) {
        username = text
    }

    var password by mutableStateOf("")
        private set

    fun updatePassword(text:String) {
        password = text
    }

    var pwdHidden by mutableStateOf(true)
        private set

    fun changeHidden() {
        pwdHidden = !pwdHidden
    }

//    var validUsername by mutableStateOf(true)
//        private set

    var validPassword by mutableStateOf(true)
        private set

//    fun changeValidStateUsername() {
//        validUsername = !validUsername
//    }

    fun changeValidStatePassword() {
        validPassword = !validPassword
    }

    fun checkUsername(): Boolean {
        return this.username == "peng"
    }

    fun checkPassword(): Boolean {
        return this.password == "peng"
    }

}