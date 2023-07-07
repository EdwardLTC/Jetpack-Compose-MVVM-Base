package com.example.myapplication.feature.presentation.bottom.search

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.navigation.base.NavRoute


object SearchRoute : NavRoute<SearchViewModel> {
    override val route: String = this::class.java.simpleName.toString().replace("Route", "")

    @Composable
    override fun viewModel(): SearchViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: SearchViewModel) = SearchScreen()

}
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "Explore_screen")
    }
}

@Preview(name = "Explore_screen", showSystemUi = true)
@Composable
private fun PreviewExplore_screen() {
    SearchScreen()
}