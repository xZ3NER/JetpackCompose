package com.example.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTextView(text = "Hola Mundo!")
            MyButton(text = "Click me!")
        }
    }
}

@Composable
fun MyTextView(text: String) {
    Text(text = text)
}

@Composable
fun MyButton(text: String) {
    Button(onClick = {

    }) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewComponents(){
    Column() {
        MyTextView(text = "Hola Mundo!")
        MyButton(text = "Click me!")
    }
}

