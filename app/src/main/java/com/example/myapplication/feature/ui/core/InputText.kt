import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import com.example.myapplication.R
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.feature.ui.theme.MyIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    searchQuery: () -> Unit = {},
    label: String = "",
    icon: ImageVector = Icons.Default.Email,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Done,
    enabled: Boolean = true,
    maxLine: Int = 3,
    type: InputTextFieldType = InputTextFieldType.Classic,
    onValueChange: (String) -> Unit,
) {

    when (type) {
        InputTextFieldType.Classic -> TextField(
            value = text,
            label = { Text(text = label) },
            enabled = enabled,
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = MaterialTheme.colorScheme.onSurface
            ),
            onValueChange = onValueChange,
            shape = MaterialTheme.shapes.extraSmall,
            placeholder = { Text(text = label) },
            maxLines = maxLine
        )

        InputTextFieldType.Password -> {
            var passwordVisibility: Boolean by remember { mutableStateOf(false) }
            TextField(
                value = text,
                label = { Text(text = label) },
                enabled = enabled,
                modifier = modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction,
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = MaterialTheme.colorScheme.onSurface
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        val displayIcon =
                            if (passwordVisibility) painterResource(MyIcons.eye_on) else painterResource(MyIcons.eye_off)
                        Icon(
                            painter = displayIcon,
                            contentDescription = "Icon"
                        )
                    }
                },
                onValueChange = onValueChange,
                shape = MaterialTheme.shapes.extraSmall,
                placeholder = { Text(text = label) },
                maxLines = maxLine,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            )
        }


        InputTextFieldType.Outlined -> OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            label = { Text(label) },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            maxLines = maxLine
        )

        InputTextFieldType.WithIcon -> OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon",
                )
            },
            label = { Text(label) },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                focusedLabelColor = MaterialTheme.colorScheme.onSurface
            ),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            maxLines = maxLine
        )

        InputTextFieldType.IconClickable -> OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            leadingIcon = {
                androidx.compose.material.IconButton(onClick = searchQuery) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Icon",
                    )
                }
            },
            label = { Text(label) },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.onSurface,
                focusedLabelColor = MaterialTheme.colorScheme.onSurface
            ),
            enabled = enabled,
            shape = MaterialTheme.shapes.small,
            maxLines = maxLine
        )
    }
}

@Preview
@Composable
fun PreviewOutlinedTextField() {
    InputTextField(text = "Outlined", type = InputTextFieldType.Outlined) {}
}

@Preview
@Composable
fun PreviewPasswordTextField() {
    InputTextField(text = "Password", type = InputTextFieldType.Password) {}
}

@Preview
@Composable
fun PreviewClassicTextField() {
    InputTextField(text = "Classic", type = InputTextFieldType.Classic) {
    }
}

@Preview
@Composable
fun PreviewWithIconTextField() {
    InputTextField(
        text = "With Icon",
        type = InputTextFieldType.WithIcon,
        icon = Icons.Default.Send,
    ) {}

}

enum class InputTextFieldType {
    Classic, Outlined, WithIcon, IconClickable, Password
}