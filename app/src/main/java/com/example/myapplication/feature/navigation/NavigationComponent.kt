package com.example.myapplication.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import com.example.myapplication.feature.presentation.login.LoginRoute
import com.example.myapplication.feature.presentation.product_details.ProductDetailsRoute
import com.example.myapplication.feature.presentation.register.RegisterRoute

@Composable
fun NavigationComponent(
    navHostController: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navHostController,
        startDestination = LoginRoute.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        LoginRoute.composable(this, navHostController)
        RegisterRoute.composable(this, navHostController)
        BottomAppRoute.composable(this, navHostController)
        ProductDetailsRoute.composable(this, navHostController)
    }
}
