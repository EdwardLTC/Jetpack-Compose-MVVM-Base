package com.example.myapplication.domain.utils

sealed class ApiState<out T> {
    data class Success<out R>(val data: R) : ApiState<R>()
    data class Error(val message: Throwable) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[message=$message]"
            Loading -> "Loading"
        }
    }
}

fun <T, R> ApiState<T>.map(transform: (T) -> R): ApiState<R> {
    return when (this) {
        is ApiState.Success -> ApiState.Success(transform(data))
        is ApiState.Error -> ApiState.Error(message)
        ApiState.Loading -> ApiState.Loading
    }
}