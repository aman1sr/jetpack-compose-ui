package com.pahadi.jetpackcomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pahadi.jetpackcomposeui.ui.CupCakeHomeScreen
import com.pahadi.jetpackcomposeui.ui.SelectOptionScreen
import com.pahadi.jetpackcomposeui.ui.TextFieldDemo
import com.pahadi.jetpackcomposeui.ui.basicnavigationDemo.HomeScreen
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeUiTheme {
//               Surface {
//                   UnScrambleUi()     //https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state#1
//               }
                Surface(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 100.dp)
                ) {
//                MarsPhotoApp()
//                    LazyVerticalGridDemo()
//                    HomeScreen()
//                    CupCakeHomeScreen()
//                    SelectOptionScreen()
                    TextFieldDemo()
                }
            }
        }
    }
}


