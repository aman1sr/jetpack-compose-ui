package com.pahadi.jetpackcomposeui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme
import com.pahadi.jetpackcomposeui.ui.theme.Typography

@Composable
fun UnScrambleUi() {
    Text(text = "test",
        style = Typography.bodyLarge)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeUiTheme {
        UnScrambleUi()
    }
}