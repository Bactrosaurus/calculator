package de.daniel.calculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import de.daniel.calculator.expression
import de.daniel.calculator.util.evaluateExpression

private val topPadding = Modifier.padding(top = 6.dp)
private val bottomPadding = Modifier.padding(bottom = 6.dp)
private val endPadding = Modifier.padding(end = 8.dp)
private val startPadding = Modifier.padding(start = 8.dp)
private val startEndPadding = Modifier.padding(start = 8.dp, end = 8.dp)
private val maxWidth = Modifier.fillMaxWidth()
private val maxHeight = Modifier.fillMaxHeight()

@Composable
fun Buttons() {
    Row {
        NumButtons()
        OperationButtons()
        ClearButtons()
    }
}

@Composable
private fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier,
    clearExpression: Boolean = false,
    dropLastChar: Boolean = false,
    evaluateExpression: Boolean = false
) {
    fun setExpression() {
        when {
            clearExpression -> expression = TextFieldValue("")
            dropLastChar -> expression = TextFieldValue(expression.text.dropLast(1))
            evaluateExpression -> evaluateExpression()
            else -> expression = TextFieldValue(expression.text.plus(text))
        }
    }
    Button(onClick = { setExpression() }, modifier = modifier) { Text(text) }
}

@Composable
private fun ClearButtons() {
    Column(modifier = endPadding) {
        CalculatorButton("C", clearExpression = true)
        CalculatorButton("Del", dropLastChar = true)
        CalculatorButton("=", modifier = topPadding.then(Modifier.height(84.dp)), evaluateExpression = true)
    }
}

@Composable
private fun OperationButtons() {
    Column(modifier = startEndPadding) {
        CalculatorButton("+")
        CalculatorButton("-")
        CalculatorButton("*")
        CalculatorButton("/")
    }
}

@Composable
private fun NumButtons() {
    Column(modifier = Modifier.width(IntrinsicSize.Min)) {
        Row {
            CalculatorButton("1", startEndPadding)
            CalculatorButton("2")
        }

        Row {
            CalculatorButton("4", startEndPadding)
            CalculatorButton("5")
        }

        Row {
            CalculatorButton("7", startEndPadding)
            CalculatorButton("8")
        }

        CalculatorButton("0", startPadding.then(maxWidth))
    }

    Column(modifier = startPadding) {
        CalculatorButton("3")
        CalculatorButton("6")
        CalculatorButton("9")
        CalculatorButton(".")
    }
}