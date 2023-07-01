package com.example.myapplication.feature.presentation.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.feature.domain.reponsitory.ApiRepository
import com.example.myapplication.feature.domain.utils.Resource
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import com.example.myapplication.feature.presentation.auth.register.RegisterRoute
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
    private val repository: ApiRepository
) : ViewModel(), RouteNavigator by routeNavigator {


    fun loadProduct() {
        viewModelScope.launch {
            when (val result = repository.getProductList()) {
                is Resource.Success -> {
                    val data = result.data
                }

                is Resource.Error -> {
                    val message = result.message
                    Log.d("LoginViewModel", "loadProduct: $message")
                }

                else -> {}
            }
        }
    }

    fun onLoginPress() {
        navigateToRoute(BottomAppRoute.route + "{hello}", inclusive = true)
    }

    fun navigateToRegister() {
        navigateToRoute(RegisterRoute.route)
    }

}