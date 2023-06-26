package com.example.myapplication.feature.presentation.home

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.feature.navigation.base.NavRoute
import androidx.hilt.navigation.compose.hiltViewModel


object HomeRoute : NavRoute<HomeViewModel> {
    override val route: String = "home"

    @Composable
    override fun viewModel(): HomeViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: HomeViewModel, arguments: Bundle?) = HomeScreen()

}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "HomeScreen")
    }
}

@Preview(name = "HomeScreen", showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}