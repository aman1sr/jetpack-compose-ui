package com.pahadi.jetpackcomposeui.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pahadi.jetpackcomposeui.R
import com.pahadi.jetpackcomposeui.ui.theme.JetpackComposeUiTheme
import com.pahadi.jetpackcomposeui.ui.theme.Typography

@Composable
fun UnScrambleUi() {
    Text(text = "test",
        style = Typography.bodyLarge)
}

@Composable
fun GameLayout(
    currentWord: String,
    wordCount: Int,
    isGuessWrong: Boolean,
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    modifier: Modifier = Modifier
){
    val mediumPadding = 16.dp
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Text(
            modifier = Modifier
                .clip(shapes.medium)
                .background(colorScheme.surfaceTint)
                .padding(horizontal = 10.dp, vertical = 4.dp)
                .align(Alignment.End),
            text = stringResource(id = R.string.word_count, wordCount),
            style = typography.titleMedium,
            color = colorScheme.onPrimary
        )
        Text(
            text = currentWord,
            style = typography.displayMedium
        )
        Text(
            text = stringResource(id = R.string.instruction),
            style = typography.titleMedium
        )

        OutlinedTextField(
            value = userGuess,
            singleLine = true,
            shape = shapes.large,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            ),
            onValueChange = onUserGuessChanged,
            label = {
                if (isGuessWrong) {
                    Text("wrong guess")
                } else {
                    Text("right guess")
                }
            },
            isError = isGuessWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onKeyboardDone() }
            )
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeUiTheme {
        GameLayout(
            "balsls",
            1,
            false,
            "basfsdf",
            onUserGuessChanged = {
                Log.d("compose_d", "user guess : $it ")
            },
            onKeyboardDone = {

            }
        )
    }
}