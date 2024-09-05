package com.pahadi.jetpackcomposeui.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme
/*
*https://foso.github.io/Jetpack-Compose-Playground/foundation/lazyverticalgrid/
*
* */
@Composable
fun  LazyVerticalGridDemo() {
    val list = (1..10).map { it.toString() }

    LazyVerticalGrid(
//        columns = GridCells.Adaptive(124.dp),
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size){index ->
                Card(
                    colors = CardColors(Color.Red, Color.Blue, Color.Cyan, Color.Gray),
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                        ){
                        Text(text = list[index],
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                }
            }
        }
        )
}

@Preview
@Composable
fun previewLazyVerticalGridDemo() {
JetpackComposeUiTheme {
    LazyVerticalGridDemo()
}
}