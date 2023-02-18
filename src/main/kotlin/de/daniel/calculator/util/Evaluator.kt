package de.daniel.calculator.util

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import de.daniel.calculator.expression
import org.mariuszgromada.math.mxparser.Expression

fun evaluateExpression() {
    val result = Expression(expression.text).calculate()
    expression = TextFieldValue(
        if (result % 1.0 != 0.0) String.format("%s", result) else String.format("%.0f", result),
        selection = TextRange(expression.text.length)
    )
}