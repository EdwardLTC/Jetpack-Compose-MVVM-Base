package com.example.myapplication.feature.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Products
import com.example.myapplication.domain.reponsitory.ApiRepository
import com.example.myapplication.domain.utils.doOnError
import com.example.myapplication.domain.utils.doOnLoading
import com.example.myapplication.domain.utils.doOnSuccess
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import com.example.myapplication.feature.presentation.register.RegisterRoute
import com.example.myapplication.feature.use_case.ApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
    private val useCase: ApiUseCase
) : ViewModel(), RouteNavigator by routeNavigator {

    val loginUiInfo by lazy { MutableStateFlow(LoginState()) }

    init {
        viewModelScope.launch {
            useCase.getProductList()
                .doOnLoading { Log.d("TAG", "Loading") }
                .doOnSuccess { Log.d("TAG", "Success") }
                .doOnError { Log.d("TAG", "Error") }
        }
    }

    val isDisableButtonLogin: Boolean
        get() = loginUiInfo.value.Username.isEmpty() || loginUiInfo.value.Password.isEmpty()


    fun onUserNameChanged(username: String) {
        loginUiInfo.value = loginUiInfo.value.copy(Username = username)
    }

    fun onPasswordChanged(password: String) {
        loginUiInfo.value = loginUiInfo.value.copy(Password = password)
    }

    fun onButtonLoginClicked() {
        navigateToRoute(BottomAppRoute.route, inclusive = true)
    }

    fun onRegisterClicked() {
        navigateToRoute(RegisterRoute.route)
    }

}


data class LoginState(
    val Username: String = "",
    val Password: String = "",
)