package com.example.myapplication.domain.mapper

import com.example.myapplication.domain.base.Mapper
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.model.Products
import javax.inject.Inject

class ProductMapper @Inject constructor() : Mapper<Product?, Products> {
    override fun mapFrom(from: Product?): Products {
        TODO("Not yet implemented")
    }
}