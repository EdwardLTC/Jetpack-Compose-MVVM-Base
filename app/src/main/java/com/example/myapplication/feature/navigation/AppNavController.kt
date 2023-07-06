package com.example.myapplication.feature.navigation

import android.annotation.SuppressLint
import androidx.navigation.NavHostController


//to access navController from anywhere in the app
object AppNavController {
    @SuppressLint("StaticFieldLeak")
    var mainAppNavController: NavHostController? = null

    @SuppressLint("StaticFieldLeak")
    var bottomNavController: NavHostController? = null
}
