package com.example.myapplication.feature.domain.remote

import com.example.myapplication.feature.domain.model.Product
import com.example.myapplication.feature.domain.model.Products
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProductList(): Products

    @GET("products/{id}")
    suspend fun getProductInfo(
        @Path("id") id: Int
    ): Product

}