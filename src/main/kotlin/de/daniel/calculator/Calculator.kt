package de.daniel.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import de.daniel.calculator.ui.Buttons
import de.daniel.calculator.ui.ExpressionField

var expression by mutableStateOf(TextFieldValue(""))

@Composable
fun Calculator() = MaterialTheme {
    Column(modifier = Modifier.width(IntrinsicSize.Min)) {
        ExpressionField()
        Buttons()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Calculator",
        state = rememberWindowState(size = DpSize.Unspecified),
        resizable = false
    ) { Calculator() }
}