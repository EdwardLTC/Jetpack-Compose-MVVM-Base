package com.example.myapplication.domain.reponsitory

import android.util.Log
import com.example.myapplication.domain.base.BaseRepository
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.model.Products
import com.example.myapplication.domain.remote.ApiService
import com.example.myapplication.domain.utils.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : BaseRepository(), ProductsRepository {
    override suspend fun getProductList(): Flow<ApiState<Products>> {
        return safeApiCall {
            apiService.getProductList()
        }
    }

    override suspend fun getProductInfo(id: Int): Flow<ApiState<Product>> = safeApiCall {
        apiService.getProductInfo(id)
    }
}