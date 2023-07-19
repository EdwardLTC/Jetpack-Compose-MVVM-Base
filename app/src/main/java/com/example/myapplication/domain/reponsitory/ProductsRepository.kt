package com.example.myapplication.domain.reponsitory

import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.utils.ApiState
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductList(): Flow<ApiState<List<Product>>>

    suspend fun getProductInfo(id: Int): Flow<ApiState<Product>>

}