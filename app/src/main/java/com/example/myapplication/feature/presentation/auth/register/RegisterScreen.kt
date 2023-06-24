package com.example.myapplication.feature.presentation.auth.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    NavigateLogin: () -> Unit
) {
    val navHostController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { }) {
            Text(text = "nav Login")
        }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun RegisterScreen() {
    RegisterScreen(NavigateLogin = { })
}