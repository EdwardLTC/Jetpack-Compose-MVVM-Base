package com.example.myapplication.feature.use_case

import com.example.myapplication.domain.model.Products
import com.example.myapplication.domain.reponsitory.ProductsRepository
import com.example.myapplication.domain.utils.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApiUseCase @Inject constructor(
    private val apiRepository: ProductsRepository
) {
    suspend fun getProductList(): Flow<ApiState<Products>> {
        return apiRepository.getProductList()
    }

    suspend fun getProductInfo(id: Int): Flow<ApiState<Products>> {
        return apiRepository.getProductList()
    }
}