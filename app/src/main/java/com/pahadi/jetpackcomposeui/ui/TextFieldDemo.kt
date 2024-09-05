package com.pahadi.jetpackcomposeui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme

@Composable
fun TextFieldDemo() {
    val textState = remember {
        mutableStateOf("")
    }
    var textStateUsingBy by remember {
        mutableStateOf("")
    }
    var textState2 by remember {
        mutableStateOf("")
    }
  var textState3 by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleTextField(textState)
        Spacer(modifier = Modifier.height(15.dp))
//        SimpleTextFieldByKeyword(textStateUsingBy)    // not working inside f()
        TextField(
            value = textStateUsingBy,
            onValueChange = {    // using By : no longer need to use .value to set or get current value
                textStateUsingBy = it
            })
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = textState2,
            onValueChange = {
                textState2 = it
            },
            label = {
                Text(text = "Label")
            },
            placeholder = {
                Text(text = "Hint")
            },
            visualTransformation = PasswordVisualTransformation(),
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = textState3,
            onValueChange ={
            textState3 = it
        },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            },
            trailingIcon = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "apply")
                }
            }

        )

    }
}


//@Composable
//fun SimpleTextFieldByKeyword(textStateUsingBy: MutableState<String>) {
//    TextField(
//        value = textStateUsingBy, onValueChange ={    // using By : no longer need to use .value to set or get current value
//            textStateUsingBy = it
//        } )
//}

@Composable
fun SimpleTextField(textState: MutableState<String>) {
    TextField(value = textState.value, onValueChange = {
        textState.value = it
    })

}

@Preview
@Composable
fun PreviewTextFieldDemo() {
    JetpackComposeUiTheme {
        TextFieldDemo()
    }
}
