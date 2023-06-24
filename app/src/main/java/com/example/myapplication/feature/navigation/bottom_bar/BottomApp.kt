package com.example.myapplication.feature.navigation.bottom_bar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.feature.navigation.base.NavRoute
import com.example.myapplication.feature.presentation.explore.ExploreRoute
import com.example.myapplication.feature.presentation.home.HomeRoute


object BottomAppRoute : NavRoute<BottomAppViewModel> {
    override val route: String = "bottom_app/{name}"

    @Composable
    override fun viewModel(): BottomAppViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: BottomAppViewModel) = MainBottomApp()

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainBottomApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}

/**
 * Bottom Nav Graph is a graph that contains all the screens that are accessible from the bottom nav bar.
 */
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeRoute.route) {
        HomeRoute.composable(this, navController)
        ExploreRoute.composable(this, navController)
    }
}

/**
 * Bottom Bar is the bottom navigation bar that is shown on the screen. It is used to navigate between and custom bottom ui here.
 */
@Composable
fun BottomBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        HomeRoute.route,
        ExploreRoute.route
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        bottomNavigationItems.forEach { route ->
            AddItem(
                route = route,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

/**
 * AddItem is a single item in the bottom navigation bar, customise single item here.
 */
@Composable
fun RowScope.AddItem(
    route: String,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = "Home")
        },
        icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
