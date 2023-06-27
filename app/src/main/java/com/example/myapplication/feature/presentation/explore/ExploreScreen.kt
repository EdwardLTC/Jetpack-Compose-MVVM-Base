package com.example.myapplication.feature.presentation.explore

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.feature.navigation.base.NavRoute


object ExploreRoute : NavRoute<ExploreViewModel> {
    override val route: String = "explore"

    @Composable
    override fun viewModel(): ExploreViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: ExploreViewModel) = ExploreScreen()

}
@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "Explore_screen")
    }
}

@Preview(name = "Explore_screen", showSystemUi = true)
@Composable
private fun PreviewExplore_screen() {
    ExploreScreen()
}