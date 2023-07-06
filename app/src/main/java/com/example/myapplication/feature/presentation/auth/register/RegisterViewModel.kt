package com.example.myapplication.feature.presentation.auth.register

import androidx.lifecycle.ViewModel
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val routeNavigator: RouteNavigator
) : ViewModel(), RouteNavigator by routeNavigator {

    val registerUiInfo by lazy {
        MutableStateFlow(
            RegisterState("", "", "")
        )
    }

    val isRegisterButtonEnabled: Boolean
        get() = registerUiInfo.value.Username.isNotEmpty() &&
                registerUiInfo.value.Password.isNotEmpty() &&
                registerUiInfo.value.VerifyPassword.isNotEmpty() &&
                registerUiInfo.value.Password == registerUiInfo.value.VerifyPassword


    fun onUserNameChanged(username: String) {
        registerUiInfo.value = registerUiInfo.value.copy(Username = username)
    }

    fun onPasswordChanged(password: String) {
        registerUiInfo.value = registerUiInfo.value.copy(Password = password)
    }

    fun onVerifyPasswordChanged(verifyPassword: String) {
        registerUiInfo.value = registerUiInfo.value.copy(VerifyPassword = verifyPassword)
    }

    fun onBackToLogin() {
        navigateUp()
    }

    fun onRegister() {
        /*todo*/
    }

}

data class RegisterState(
    val Username: String = "",
    val Password: String = "",
    val VerifyPassword: String = "",
)