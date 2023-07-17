package com.example.myapplication.di

import com.example.myapplication.domain.reponsitory.ApiRepository
import com.example.myapplication.domain.reponsitory.ApiRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providerApiRepository(apiRepositoryImpl: ApiRepositoryImp): ApiRepository
}