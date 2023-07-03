package com.example.myapplication.feature.navigation.bottom_bar

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomAppViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel(), RouteNavigator by routeNavigator {
    private val name: String = checkNotNull(savedStateHandle["name"])

}