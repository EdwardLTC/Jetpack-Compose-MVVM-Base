package com.example.myapplication.feature.presentation.auth.login

import InputTextField
import InputTextFieldType
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.feature.navigation.base.NavRoute
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.ui.core.Button


object LoginRoute : NavRoute<LoginViewModel> {
    override val route: String = "login"

    @Composable
    override fun viewModel(): LoginViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: LoginViewModel) = LoginScreen(
        loginUiInfo = viewModel.loginUiInfo.collectAsState().value,
        onUserNameChanged = viewModel::onUserNameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        isDisableButtonLogin = viewModel.isDisableButtonLogin,
        onLoginClick = viewModel::onButtonLoginClicked,
        onRegisterClick = viewModel::onRegisterClicked,
    )
}


@Composable
fun LoginScreen(
    loginUiInfo: LoginState?,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    isDisableButtonLogin: Boolean = false,
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},

) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { focusManager.clearFocus() }
    ) {
        Text(
            text = "Login",
            fontSize = 36.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        )

        InputTextField(
            text = loginUiInfo?.Username ?: "",
            onValueChange = onUserNameChanged,
            label = "Username",
            keyboardType = KeyboardType.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )

        InputTextField(
            text = loginUiInfo?.Password ?: "",
            onValueChange = onPasswordChanged,
            type = InputTextFieldType.Password,
            label = "Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )

        Text(
            text = "Forgot password?",
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF52CC6D),
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )

        Button(
            text = "Login",
            onClick = onLoginClick,
            modifier = Modifier.padding(top = 18.dp),
            enabled = !isDisableButtonLogin,
            shape = RoundedCornerShape(8.dp)
        )

        //draw line
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 18.dp, start = 6.dp, end = 6.dp)
        ) {
            Divider(
                color = Color(0xFFE0E0E0),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth(0.45f)
            )
            Text(
                text = "or",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Divider(
                color = Color(0xFFE0E0E0),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .padding(horizontal = 28.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 16.sp,
            )
            Text(
                text = " Create one",
                fontSize = 16.sp,
                color = Color(0xFF52CC6D),
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onRegisterClick()
                }
            )
        }
    }
}

@Preview(name = "Login_screen", showSystemUi = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(null, {}, {})
}