package com.example.myapplication.domain.reponsitory

import com.example.myapplication.domain.model.Products
import com.example.myapplication.domain.utils.ApiState
import kotlinx.coroutines.flow.Flow


interface ApiRepository {
    suspend fun getProductList(): Flow<ApiState<Products>>

    suspend fun getProductInfo(id: Int): Flow<ApiState<Products>>

}