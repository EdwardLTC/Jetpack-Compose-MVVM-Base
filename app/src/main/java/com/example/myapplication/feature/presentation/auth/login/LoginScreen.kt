package com.example.myapplication.feature.presentation.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.feature.navigation.base.NavRoute
import androidx.hilt.navigation.compose.hiltViewModel


object LoginRoute : NavRoute<LoginViewModel> {
    override val route: String = "login"

    @Composable
    override fun viewModel(): LoginViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: LoginViewModel) = LoginScreen(
        onClickLogin = viewModel::onLoginPress
    )
}


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClickLogin: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onClickLogin) {
            Text(text = "Login")
        }
    }
}

@Preview(name = "Login_screen", showSystemUi = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(onClickLogin = { })
}