package com.example.myapplication.feature.navigation.bottom_bar

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.di.MainAppNavigation
import com.example.myapplication.feature.navigation.base.NavigationState
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BottomAppViewModel @Inject constructor(
    @MainAppNavigation private val routeNavigator: RouteNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel(), RouteNavigator by routeNavigator {
    private val name: String = checkNotNull(savedStateHandle["name"])

}