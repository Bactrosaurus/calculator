package de.daniel.calculator.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.unit.dp
import de.daniel.calculator.expression
import de.daniel.calculator.util.evaluateExpression

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ExpressionField() {
    val modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .onPreviewKeyEvent {
            if (it.key == Key.Enter || it.key == Key.NumPadEnter) {
                evaluateExpression()
                true
            } else {
                false
            }
        }

    TextField(
        value = expression,
        onValueChange = { expression = it },
        label = { Text("Expression") },
        modifier = modifier
    )
}