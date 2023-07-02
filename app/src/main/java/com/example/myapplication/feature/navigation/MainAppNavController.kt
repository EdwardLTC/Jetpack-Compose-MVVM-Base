package com.example.myapplication.feature.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavHostController


//to access navController from anywhere in the app
object MainAppNavController {
    @SuppressLint("StaticFieldLeak")
    private var navController: NavHostController? = null

    fun getNavController(): NavHostController? {
        return navController
    }

    fun setNavController(controller: NavHostController) {
        navController = controller
    }
}