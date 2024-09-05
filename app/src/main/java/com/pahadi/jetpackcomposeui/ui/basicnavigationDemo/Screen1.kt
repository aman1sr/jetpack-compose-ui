package com.pahadi.jetpackcomposeui.ui.basicnavigationDemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Screen1(
    modifier: Modifier = Modifier,
    onNextClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center
        ) {
        Button(onClick = { onNextClicked.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Next")
        }
        Button(onClick = { onBackClicked.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Cancel")
        }
    }
}