package com.example.myapplication.feature.presentation.bottom.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.navigation.base.NavRoute


object ProfileRoute : NavRoute<ProfileViewModel> {
    override val route: String = this::class.java.simpleName.toString().replace("Route", "")

    @Composable
    override fun viewModel(): ProfileViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: ProfileViewModel) =
        ProfileScreen()
}


@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "ProfileScreen")
    }
}

@Preview(name = "ProfileScreen", showSystemUi = true)
@Composable
private fun PreviewProfileScreen() {
    ProfileScreen()
}