package com.luismakeapp.navigationwithmvvm.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun thirdScreen(
    result: Int,
    onButtonClicked: () -> (Unit),
    onCancelButtonClicked: () -> (Unit)
){

    //UI screen
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "2 + 2 =")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = result.toString())
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { onButtonClicked() }) {
            Text(text = "Calculate")
        }
        Button(onClick = {onCancelButtonClicked()}){
            Text(text = "Start Again")
        }
    }
}