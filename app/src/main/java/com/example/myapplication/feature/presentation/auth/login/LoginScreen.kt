package com.example.myapplication.feature.presentation.auth.login

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.navigation.NamedNavArgument


object LoginRoute : NavRoute<LoginViewModel> {
    override val route: String = "login"

    @Composable
    override fun viewModel(): LoginViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: LoginViewModel, arguments: Bundle?) = LoginScreen(
        onClickLogin = viewModel::onLoginPress,
        onNavigateToRegister = viewModel::navigateToRegister
    )
}


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onClickLogin: () -> Unit,
    onNavigateToRegister: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Button(onClick = onClickLogin) {
                Text(text = "Login")
            }
            Button(onClick = onNavigateToRegister) {
                Text(text = "nav Register")
            }

        }

    }
}

@Preview(name = "Login_screen", showSystemUi = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(onClickLogin = { })
}