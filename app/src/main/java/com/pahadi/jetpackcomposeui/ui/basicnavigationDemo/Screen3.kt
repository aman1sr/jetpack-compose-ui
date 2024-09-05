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
fun Screen3(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Bottom
    ) {

        Button(onClick = { onBackClicked.invoke() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Cancel")
        }
    }
}