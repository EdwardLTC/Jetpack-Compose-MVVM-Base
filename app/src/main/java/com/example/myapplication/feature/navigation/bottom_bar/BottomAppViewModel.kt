package com.example.myapplication.feature.navigation.bottom_bar

import androidx.lifecycle.ViewModel
import com.example.myapplication.feature.navigation.base.NavigationState
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BottomAppViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator{
}