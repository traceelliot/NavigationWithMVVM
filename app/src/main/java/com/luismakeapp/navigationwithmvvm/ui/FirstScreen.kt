package com.luismakeapp.navigationwithmvvm.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun firstScreen(
    onButtonClicked: (String, String) -> Unit
){

    //Variable for textfield
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }

    //UI screen
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Info")
        Spacer(modifier = Modifier.height(6.dp))
        TextField(value = name, onValueChange = { name = it })
        TextField(value = age, onValueChange = { age = it })
        Button(onClick = {
            onButtonClicked(name, age)
        }) {
            Text(text = "Next")
        }
    }
}

/*
@Preview
@Composable
fun firstScreenPreview(){
    firstScreen()
}
*/