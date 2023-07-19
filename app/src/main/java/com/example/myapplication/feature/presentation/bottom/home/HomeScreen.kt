package com.example.myapplication.feature.presentation.bottom.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.feature.navigation.base.NavRoute
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.domain.model.Product
import com.example.myapplication.dummy.dummyCategory

object HomeRoute : NavRoute<HomeViewModel> {
    override val route: String = this::class.java.simpleName.toString().replace("Route", "")

    @Composable
    override fun viewModel(): HomeViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: HomeViewModel) =
        HomeScreen(
            data = viewModel.viewState.collectAsState().value.data,
            navigateToDetails = viewModel::navigateToProductDetails
        )
}


@Composable
fun HomeScreen(
    data: List<Product>,
    navigateToDetails: (Int) -> Unit = {}
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(top = 15.dp)
    ) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 0.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in dummyCategory.indices) {
                Tab(
                    selected = i == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = i
                    },
                    text = { TextBox(text = dummyCategory[i], i == selectedTabIndex) }
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(horizontal = 25.dp)
        ) {
            items(data.size) {
                FoodComponent(product = data[it], onItemClick = { product ->
                    navigateToDetails(product.id!!)
                })
            }
        }
    }
}


@Composable
fun TextBox(text: String, isSelected: Boolean = false) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
        modifier = Modifier
            .background(
                if (isSelected) Color.Green else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(4.dp)
            )
            .wrapContentSize(align = Alignment.Center)
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 12.dp),
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 12.sp,
        )
    }
}

@Preview(name = "HomeScreen", showSystemUi = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(emptyList())
}