package com.pahadi.jetpackcomposeui.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme

@Composable
fun SelectOptionScreen() {
    val cupcakeList =
        listOf<String>("Vanilla", "Chocolate", "Red Velvet", "Salted Caramel", "Coffee")

    val (selectedOption, onOptionSelected) = remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            cupcakeList.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                RadioButton(
                    selected =(text == selectedOption),
                    onClick = { onOptionSelected(text) })
                    Text(text = text,
                        style = MaterialTheme.typography.bodyMedium.merge(),
                        modifier = Modifier.padding(start = 16.dp),
                        textAlign = TextAlign.Center
                        )
                }
            }
// have a line & subtotal

        }

// bottom Row 2 button
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            val context = LocalContext.current
            Button(modifier = Modifier
                .weight(1f)
                .padding(8.dp),
                onClick = {
                Toast.makeText(context, "Cancel pressed", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Cancel")
            }

            val containerColor: Color = selectedOption?.let { Color.Magenta } ?: Color.White

            Button(modifier = Modifier.weight(1f),
                onClick = {
                Toast.makeText(context, "Next pressed", Toast.LENGTH_SHORT).show()
            },
                colors = ButtonDefaults.buttonColors(containerColor = containerColor)
                ) {
                Text(text = "Next", color = Color.Black)
            }

        }

    }
}


@Preview
@Composable
fun previewSelectOptionScreen() {
    JetpackComposeUiTheme {
        SelectOptionScreen()
    }
}