package com.example.myapplication.di

import com.example.myapplication.feature.navigation.base.MainRouteNavigator
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {
    @Provides
    @ViewModelScoped
    fun bindRouteNavigator(): RouteNavigator = MainRouteNavigator()
}