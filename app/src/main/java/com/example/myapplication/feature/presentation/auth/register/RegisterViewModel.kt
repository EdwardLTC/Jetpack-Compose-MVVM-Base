package com.example.myapplication.feature.presentation.auth.register

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.MainAppNavigation
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.presentation.auth.login.LoginRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    @MainAppNavigation private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {
    fun navToLogin() {
        navigateToRoute(LoginRoute.route)
    }
}