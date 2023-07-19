package com.example.myapplication.feature.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.utils.ApiState
import com.example.myapplication.domain.utils.doOnError
import com.example.myapplication.domain.utils.doOnLoading
import com.example.myapplication.domain.utils.doOnSuccess
import com.example.myapplication.feature.navigation.base.RouteNavigator
import com.example.myapplication.feature.navigation.bottom_bar.BottomAppRoute
import com.example.myapplication.feature.presentation.register.RegisterRoute
import com.example.myapplication.feature.use_case.ApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator,
) : ViewModel(), RouteNavigator by routeNavigator {

    val loginUiInfo by lazy { MutableStateFlow(LoginState()) }

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