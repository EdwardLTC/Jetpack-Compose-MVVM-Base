package com.example.myapplication.feature.presentation.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.di.BottomAppNavigation
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.presentation.auth.login.LoginRoute
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @BottomAppNavigation private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {
}