package com.example.myapplication.di

import com.example.myapplication.feature.navigation.base.BottomRouteNavigator
import com.example.myapplication.feature.navigation.base.MainRouteNavigator
import com.example.myapplication.feature.navigation.base.RouteNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Qualifier

@Qualifier
annotation class MainAppNavigation

@Qualifier
annotation class BottomAppNavigation


@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {
    @Provides
    @ViewModelScoped
    @MainAppNavigation
    fun bindRouteNavigator(): RouteNavigator = MainRouteNavigator()

    @Provides
    @ViewModelScoped
    @BottomAppNavigation
    fun bindBottomRouteNavigator(): RouteNavigator = BottomRouteNavigator()
}