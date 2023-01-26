package com.luismakeapp.navigationwithmvvm.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun secondScreen(
    name: String,
    age: String,
    onButtonClicked: () -> (Unit)
){

    //UI screen
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = name)
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = age)
        Button(onClick = {
            onButtonClicked()
        }) {
            Text(text = "Next")
        }
    }
}