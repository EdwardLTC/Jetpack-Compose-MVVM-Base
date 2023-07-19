package com.example.myapplication.feature.presentation.product_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.utils.doOnError
import com.example.myapplication.domain.utils.doOnLoading
import com.example.myapplication.domain.utils.doOnSuccess
import com.example.myapplication.dummy.dummyFood
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.presentation.bottom.home.HomeState
import com.example.myapplication.feature.use_case.ApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
    savedStateHandle: SavedStateHandle,
    private val apiUseCase: ApiUseCase,
) : ViewModel(), RouteNavigator by routeNavigator {

    private val id: Any = checkNotNull(savedStateHandle["id"]) { "Missing id" }

    val viewState by lazy { MutableStateFlow(ProductDetailsState(Product())) }

    init {
        viewModelScope.launch {
            apiUseCase.getProductInfo(id.toString().toInt())
                .doOnLoading { Log.d("ProductDetailsViewModel", "Loading") }
                .doOnSuccess { viewState.value = viewState.value.copy(data = it) }
                .doOnError { Log.e("ProductDetailsViewModel", "[Error]-> ${it.message}") }
                .collect()
        }
    }
}


data class ProductDetailsState(
    var data: Product,
)