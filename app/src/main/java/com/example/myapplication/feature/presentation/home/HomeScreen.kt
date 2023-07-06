package com.example.myapplication.feature.presentation.home

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.feature.navigation.base.NavRoute
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.navigation.AppNavController
import com.example.myapplication.feature.presentation.auth.login.LoginRoute
import com.example.myapplication.feature.presentation.auth.register.RegisterRoute


object HomeRoute : NavRoute<HomeViewModel> {
    override val route: String = "home"

    @Composable
    override fun viewModel(): HomeViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: HomeViewModel) =
        HomeScreen()
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Button(onClick = {
            AppNavController.mainAppNavController?.navigate(LoginRoute.route)
        }) {

        }
        Button(onClick = {
            AppNavController.mainAppNavController?.navigate(RegisterRoute.route)
        }) {

        }

    }
}

@Preview(name = "HomeScreen", showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}