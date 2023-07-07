package com.example.myapplication.feature.presentation.register

import InputTextField
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.navigation.base.NavRoute
import com.example.myapplication.feature.ui.core.Button


object RegisterRoute : NavRoute<RegisterViewModel> {
    override val route: String = "register"

    @Composable
    override fun viewModel(): RegisterViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: RegisterViewModel) = RegisterScreen(
        registerUiState = viewModel.registerUiInfo.collectAsState().value,
        onBackToLogin = viewModel::onBackToLogin,
        onUserNameChanged = viewModel::onUserNameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onVerifyPasswordChanged = viewModel::onVerifyPasswordChanged,
        onRegisterClick = viewModel::onRegister,
        isRegisterButtonEnabled = viewModel.isRegisterButtonEnabled,
    )
}


@Composable
fun RegisterScreen(
    registerUiState: RegisterState? = null,
    onBackToLogin: () -> Unit = { },
    onUserNameChanged: (String) -> Unit = { },
    onPasswordChanged: (String) -> Unit = { },
    onVerifyPasswordChanged: (String) -> Unit = { },
    onRegisterClick: () -> Unit = { },
    isRegisterButtonEnabled: Boolean = false,
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { focusManager.clearFocus() },
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "Go back",
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onBackToLogin() }
        )

        Text(
            text = "Register",
            fontSize = 36.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        )

        InputTextField(
            text = registerUiState?.Username ?: "",
            onValueChange = onUserNameChanged,
            label = "Username",
            keyboardType = KeyboardType.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )

        InputTextField(
            text = registerUiState?.Password ?: "",
            onValueChange = onPasswordChanged,
            type = InputTextFieldType.Password,
            label = "Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        )

        InputTextField(
            text = registerUiState?.VerifyPassword ?: "",
            onValueChange = onVerifyPasswordChanged,
            type = InputTextFieldType.Password,
            label = "Verify Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        )

        Button(
            text = "Register",
            onClick = onRegisterClick,
            modifier = Modifier.padding(top = 32.dp),
            enabled = isRegisterButtonEnabled,
            shape = RoundedCornerShape(8.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "By creating an account, you are agreeing to our",
                fontSize = 12.sp,
            )

            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
            ) {
                Text(
                    text = "Terms of Service",
                    fontSize = 12.sp,
                    color = Color.Green,
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { }
                )

                Text(
                    text = " and ",
                    fontSize = 12.sp,
                )

                Text(
                    text = "Privacy Policy",
                    fontSize = 12.sp,
                    color = Color.Green,
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { }
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun RegisterScreen() {
    RegisterScreen(onBackToLogin = { })
}