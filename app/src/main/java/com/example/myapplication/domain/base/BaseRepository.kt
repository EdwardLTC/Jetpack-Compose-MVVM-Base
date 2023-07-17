package com.example.myapplication.domain.base

import com.example.myapplication.domain.utils.ApiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> Response<T>
    ): Flow<ApiState<T>> = flow {
        emit(ApiState.Loading)
        val response = apiCall()
        if (response.isSuccessful) {
            val data = response.body()
            if (data != null) {
                emit(ApiState.Success(data = data))
            } else {
                val error = response.errorBody()
                if (error != null) {
                    emit(ApiState.Error(message = IOException(error.toString())))
                } else {
                    emit(ApiState.Error(message = IOException("Unknown error occurred")))
                }
            }
        } else {
            emit(ApiState.Error(message = IOException(response.errorBody().toString())))
        }
    }.catch { e ->
        e.printStackTrace()
        emit(ApiState.Error(message = IOException(e.message ?: "An unknown error occurred")))
    }.flowOn(dispatcher)
}