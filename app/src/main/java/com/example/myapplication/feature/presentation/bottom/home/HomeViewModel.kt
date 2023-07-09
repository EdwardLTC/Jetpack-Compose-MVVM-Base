package com.example.myapplication.feature.presentation.bottom.home

import androidx.lifecycle.ViewModel
import com.example.myapplication.dummy.dummyFood
import com.example.myapplication.feature.navigation.AppNavController
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.presentation.product_details.ProductDetailsRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {
    val data = dummyFood

    fun navigateToProductDetails(id: Int? = null) {
        AppNavController.mainAppNavController!!.navigate(ProductDetailsRoute.simpleRoute + "/$id")
    }
}