package com.example.myapplication.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import com.example.myapplication.feature.navigation.bottom_bar.BottomBar
import com.example.myapplication.feature.navigation.bottom_bar.BottomNavGraph
import com.example.myapplication.feature.navigation.bottom_bar.MainBottomApp
import com.example.myapplication.feature.presentation.auth.login.LoginRoute
import com.example.myapplication.feature.presentation.auth.register.RegisterRoute
import com.example.myapplication.feature.presentation.explore.ExploreRoute
import com.example.myapplication.feature.presentation.home.HomeRoute

@Composable
fun NavigationComponent(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navHostController,
        startDestination = LoginRoute.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        LoginRoute.composable(this, navHostController)
        RegisterRoute.composable(this, navHostController)
//        BottomAppRoute.composable(this, navHostController)
        composable(BottomAppRoute.route) {
            MainBottomApp(navHostController)
        }
    }
}


fun NavGraphBuilder.bottomAppGraph(navController: NavHostController) {
    navigation(
        startDestination = HomeRoute.route,
        route = BottomAppRoute.route
    ) {
        HomeRoute.composable(this, navController)
        ExploreRoute.composable(this, navController)
    }
}

