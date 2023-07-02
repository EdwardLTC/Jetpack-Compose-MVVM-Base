package com.example.myapplication.feature.presentation.explore

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.BottomAppNavigation
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel  @Inject constructor(
    @BottomAppNavigation private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {

}