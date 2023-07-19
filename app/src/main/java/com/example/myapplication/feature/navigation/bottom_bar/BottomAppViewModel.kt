package com.example.myapplication.feature.navigation.bottom_bar

import androidx.lifecycle.ViewModel
import com.example.myapplication.feature.navigation.AppNavController
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomAppViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
) : ViewModel(), RouteNavigator by routeNavigator {
    val navController = AppNavController.bottomNavController!!
}