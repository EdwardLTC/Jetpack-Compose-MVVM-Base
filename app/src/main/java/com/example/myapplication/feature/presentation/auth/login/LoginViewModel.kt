package com.example.myapplication.feature.presentation.auth.login

import androidx.lifecycle.ViewModel
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {
    fun onLoginPress() {
        navigateToRoute(BottomAppRoute.route)
    }
}