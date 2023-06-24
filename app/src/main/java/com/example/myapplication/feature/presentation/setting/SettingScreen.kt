package com.example.myapplication.feature.presentation.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Text(text = "SettingScreen")
    }
}

@Preview(name = "SettingScreen")
@Composable
private fun PreviewSettingScreen() {
    SettingScreen()
}