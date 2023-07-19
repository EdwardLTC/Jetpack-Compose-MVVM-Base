package com.example.myapplication.feature.presentation.bottom.home

import android.util.Log
import android.util.LogPrinter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.utils.doOnError
import com.example.myapplication.domain.utils.doOnLoading
import com.example.myapplication.domain.utils.doOnSuccess
import com.example.myapplication.dummy.dummyFood
import com.example.myapplication.feature.navigation.AppNavController
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.presentation.product_details.ProductDetailsRoute
import com.example.myapplication.feature.use_case.ApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
    private val apiUseCase: ApiUseCase,
) : ViewModel(), RouteNavigator by routeNavigator {

    val viewState by lazy { MutableStateFlow(HomeState()) }

    init {
        viewModelScope.launch {
            apiUseCase.getProductList()
                .doOnLoading {/*TODO: Animated Loading*/ }
                .doOnSuccess { viewState.value = HomeState(it) }
                .doOnError { Log.e("HomeViewModel", "[Error]-> ${it.message}") }
                .collect()
        }
    }

    fun navigateToProductDetails(id: Int? = null) {
        AppNavController.mainAppNavController!!.navigate(ProductDetailsRoute.simpleRoute + "/$id")
    }
}


data class HomeState(
    var data: List<Product> = emptyList()
)