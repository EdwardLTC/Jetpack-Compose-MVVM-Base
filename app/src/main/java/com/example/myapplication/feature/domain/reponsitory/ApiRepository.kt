package com.example.myapplication.feature.domain.reponsitory

import android.util.Log
import com.example.myapplication.feature.domain.model.Product
import com.example.myapplication.feature.domain.model.Products
import com.example.myapplication.feature.domain.remote.ApiService
import com.example.myapplication.feature.domain.utils.Resource
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityScoped
import okhttp3.internal.format
import javax.inject.Inject

@ActivityScoped
class ApiRepository @Inject constructor(
    private val api: ApiService
) {
    suspend fun getProductList(): Resource<Products> {
        val response = try {
            api.getProductList()
        } catch (e: Exception) {
            return Resource.Error(message = e.message ?: "An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getProductInfo(id: Int): Resource<Product> {
        val response = try {
            api.getProductInfo(id)
        } catch (e: Exception) {
            return Resource.Error(message = e.message ?: "An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}