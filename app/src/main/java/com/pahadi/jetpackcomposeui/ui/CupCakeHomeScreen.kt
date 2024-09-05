package com.pahadi.jetpackcomposeui.ui

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pahadi.jetpackcomposeui.R
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme

@Composable
fun CupCakeHomeScreen() {
    val cupCakeList = listOf<String>("One CupCake", "Two CupCake", "Three CupCake")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Spacer(modifier = Modifier.height(8.dp))
            Image(painter = painterResource(id = R.drawable.cupcake), contentDescription ="" )        // use painterResource to convert the drawable resource ID to a Painter
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Order Cupcake",
                color = Color.Black,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            val context = LocalContext.current
            cupCakeList.forEach { text ->
                Button(onClick = {
                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                },
                    modifier = Modifier.widthIn(min = 250.dp)

                    ) {
                    Text(text = text, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview
@Composable
fun previewCupCakeHomeScreen() {
    JetpackComposeUiTheme {
        CupCakeHomeScreen()
    }
}