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
fun Screen2(
    modifier: Modifier = Modifier,
    onNextClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Top
    ) {
        Button(onClick = { onNextClicked.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Next")
        }
        Button(onClick = { onBackClicked.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Cancel")
        }
    }
}