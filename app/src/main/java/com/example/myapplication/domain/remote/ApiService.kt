package com.example.myapplication.domain.remote

import com.example.myapplication.domain.model.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://fakestoreapi.com/"
    }

    @GET("products")
    suspend fun getProductList(): Response<Products>

    @GET("products/{id}")
    suspend fun getProductInfo(
        @Path("id") id: Int
    ): Response<Products>

}