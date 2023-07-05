package com.example.myapplication.feature.ui.core


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.feature.ui.theme.MyApplicationTheme

@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    enabled: Boolean = true,
    type: AppButtonType = AppButtonType.Filled,
    onClick: () -> Unit
) {
    when (type) {
        AppButtonType.Filled -> Button(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onSurface,
                containerColor = Color.Green,
            ),
            shape = shape,
        ) {
            ButtonContent(text = text)
        }

        AppButtonType.Outlined -> OutlinedButton(
            onClick = onClick,
            modifier = modifier.fillMaxWidth(),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ),

            ) {
            ButtonContent(text = text)
        }

        AppButtonType.Text -> {
            TextButton(
                onClick = onClick,
                modifier = modifier.fillMaxWidth(),
                enabled = enabled,
                shape = MaterialTheme.shapes.small
            ) {
                ButtonContent(text = text)
            }
        }
    }
}




//handling click effect



@Composable
private fun ButtonContent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.padding(8.dp),
    )
}

@Preview
@Composable
fun PreviewOutlinedButton() {
    MyApplicationTheme {
        Button(text = "Outlined", type = AppButtonType.Outlined) {
        }
    }
}

@Preview
@Composable
fun PreviewTextButton() {
    MyApplicationTheme {
        Button(text = "Text Button", type = AppButtonType.Text) {
        }
    }
}

@Preview(name = "Primary Button")
@Composable
fun PreviewAppButton() {
    MyApplicationTheme {
        Button(text = "Text") {}
    }
}

@Preview(name = "Disabled Button")
@Composable
fun PreviewDisabledAppButton() {
    MyApplicationTheme {
        Button(text = "Text", enabled = false) {}
    }
}

enum class AppButtonType {
    Filled, Outlined, Text
}