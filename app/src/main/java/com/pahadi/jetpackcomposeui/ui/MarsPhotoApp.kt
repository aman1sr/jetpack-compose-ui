package com.pahadi.jetpackcomposeui.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pahadi.jetpackcomposeui.R
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme

@Composable
fun MarsPhotoApp() {
    Scaffold(

    ) {
        Surface(
            modifier = Modifier.fillMaxWidth()
        ) {
            HomeScreen(
                contentPadding = it
            )
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier,contentPadding: PaddingValues = PaddingValues(0.dp)) {
   Box(
       modifier = modifier
           .fillMaxWidth()
           .padding(contentPadding) // Apply contentPadding here
   ){
       Text(text = stringResource(id = R.string.instruction),
           modifier = modifier.fillMaxWidth() )
   }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineSmall
            )
    },
        modifier = modifier)
}

@Preview
@Composable
fun previewMarsphotoApp() {
    JetpackComposeUiTheme {
        MarsPhotoApp()
    }
}