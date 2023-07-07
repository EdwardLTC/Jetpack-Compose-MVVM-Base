package com.example.myapplication.feature.presentation.bottom.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.navigation.base.NavRoute


object CartRoute : NavRoute<CartViewModel> {
    override val route: String = this::class.java.simpleName.toString().replace("Route", "")

    @Composable
    override fun viewModel(): CartViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: CartViewModel) = CartScreen()
}

@Composable
fun CartScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "CartScreen")
    }
}

@Preview(name = "SettingScreen")
@Composable
private fun PreviewSettingScreen() {
    CartScreen()
}