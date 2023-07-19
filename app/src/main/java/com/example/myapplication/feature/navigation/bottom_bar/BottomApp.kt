package com.example.myapplication.feature.navigation.bottom_bar

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.myapplication.feature.navigation.AppNavController
import com.example.myapplication.feature.navigation.base.NavRoute
import com.example.myapplication.feature.presentation.bottom.cart.CartRoute
import com.example.myapplication.feature.presentation.bottom.home.HomeRoute
import com.example.myapplication.feature.presentation.bottom.profile.ProfileRoute
import com.example.myapplication.feature.presentation.bottom.search.SearchRoute


object BottomAppRoute : NavRoute<BottomAppViewModel> {
    override val route: String = this::class.java.simpleName.toString().replace("Route", "")

    @Composable
    override fun viewModel(): BottomAppViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: BottomAppViewModel) = MainBottomApp(viewModel)

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainBottomApp(viewModel: BottomAppViewModel) {
    Scaffold(bottomBar = { BottomBar(viewModel.navController) }) {
        BottomNavGraph(navController = viewModel.navController)
    }
}

/**
 * Bottom Nav Graph is a graph that contains all the screens that are accessible from the bottom nav bar.
 */
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute.route,
        route = BottomAppRoute.route
    ) {
        HomeRoute.composable(this, navController)
        SearchRoute.composable(this, navController)
        CartRoute.composable(this, navController)
        ProfileRoute.composable(this, navController)
    }
}

/**
 * Bottom Bar is the bottom navigation bar that is shown on the screen. It is used to navigate between and custom bottom ui here.
 */

@Composable
fun BottomBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        BottomAppArgs(
            route = HomeRoute.route, icons = Icons.Outlined.Home, label = "Home"
        ), BottomAppArgs(
            route = SearchRoute.route, icons = Icons.Outlined.Search, label = "Search"
        ), BottomAppArgs(
            route = CartRoute.route, icons = Icons.Outlined.ShoppingCart, label = "Cart"
        ), BottomAppArgs(
            route = ProfileRoute.route, icons = Icons.Outlined.Person, label = "Profile"
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier
            .height(56.dp)
            .border(1.dp, Color(0xFFE0E0E0)),
        backgroundColor = Color.White,
        contentColor = Color.Gray,
    ) {
        bottomNavigationItems.forEach {
            AddItem(
                bottomAppArgs = it,
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
    bottomAppArgs: BottomAppArgs,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val isSelected = currentDestination?.hierarchy?.any {
        it.route == bottomAppArgs.route
    } == true

    BottomNavigationItem(
        label = {
            Text(
                text = bottomAppArgs.route,
                fontSize = 12.sp,
                color = if (isSelected) Color.Green else Color.Gray,
            )
        },
        icon = {
            Icon(
                imageVector = bottomAppArgs.icons, contentDescription = "Navigation Icon"
            )
        },
        selected = isSelected,
        unselectedContentColor = Color.Gray,
        selectedContentColor = Color.Green,
        onClick = {
            navController.navigate(bottomAppArgs.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
}


@Preview(showSystemUi = true)
@Composable
fun PreviewBottomBar() {
    BottomBar(navController = rememberNavController())
}

data class BottomAppArgs(
    val route: String, val icons: ImageVector, val label: String
)