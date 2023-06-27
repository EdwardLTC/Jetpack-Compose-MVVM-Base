package com.example.myapplication.feature.presentation.auth.register

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.feature.navigation.base.NavRoute


object RegisterRoute : NavRoute<RegisterViewModel> {
    override val route: String = "register"

    @Composable
    override fun viewModel(): RegisterViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: RegisterViewModel) = RegisterScreen(
        NavigateLogin = viewModel::navToLogin
    )
}


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    NavigateLogin: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = NavigateLogin) {
            Text(text = "nav Login")
        }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun RegisterScreen() {
    RegisterScreen(NavigateLogin = { })
}