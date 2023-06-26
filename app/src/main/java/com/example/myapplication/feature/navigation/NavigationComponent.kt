package com.example.myapplication.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import com.example.myapplication.feature.presentation.auth.login.LoginRoute
import com.example.myapplication.feature.presentation.auth.register.RegisterRoute
import com.example.myapplication.feature.presentation.home.HomeRoute

@Composable
fun NavigationComponent(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = LoginRoute.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        BottomAppRoute.composable(this, navHostController, isDisableBackHandle = true)
        LoginRoute.composable(this, navHostController)
        RegisterRoute.composable(this, navHostController)
    }
}