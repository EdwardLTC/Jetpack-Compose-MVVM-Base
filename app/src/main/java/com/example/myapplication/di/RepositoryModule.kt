package com.example.myapplication.di

import com.example.myapplication.domain.reponsitory.ProductsRepository
import com.example.myapplication.domain.reponsitory.ProductsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun providerApiRepository(apiRepositoryImpl: ProductsRepositoryImp): ProductsRepository
}