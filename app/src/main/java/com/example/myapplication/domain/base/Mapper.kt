package com.example.myapplication.domain.base

interface Mapper<F, T> {
    fun mapFrom(from: F): T
}