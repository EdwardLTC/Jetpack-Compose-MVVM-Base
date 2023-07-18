package com.example.myapplication.domain.remote

import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.model.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    @GET("products")
    suspend fun getProductList(): Response<List<Product>>

    @GET("products/{id}")
    suspend fun getProductInfo(
        @Path("id") id: Int
    ): Response<Product>
}