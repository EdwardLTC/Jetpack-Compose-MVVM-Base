package com.example.myapplication.feature.presentation.product_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.model.Rating
import com.example.myapplication.dummy.Food
import com.example.myapplication.feature.navigation.base.NavRoute
import com.example.myapplication.feature.ui.core.Button
import com.example.myapplication.feature.ui.theme.MyIcons
import kotlinx.coroutines.flow.MutableStateFlow


object ProductDetailsRoute : NavRoute<ProductDetailsViewModel> {
    override val route: String =
        this::class.java.simpleName.toString().replace("Route", "") + "/{id}"

    val simpleRoute: String =
        this::class.java.simpleName.toString().replace("Route", "")

    @Composable
    override fun viewModel(): ProductDetailsViewModel = hiltViewModel()

    @Composable
    override fun Content(viewModel: ProductDetailsViewModel) =
        ProductDetailsScreen(
            product = viewModel.viewState.collectAsState().value.data
        )
}

@Composable
fun ProductDetailsScreen(
    product: Product?,
    onBackClick: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(top = 5.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            TitleComponent(
                Modifier
                    .fillMaxWidth()
                    .zIndex(2f),
                onBackClick = onBackClick
            )
            if (product != null) {
                Column(modifier = Modifier.padding(16.dp)) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(product.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Food Image",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .height(200.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Text(
                        text = "$${product.price}",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        color = Color.Green,
                        fontWeight = FontWeight(700)
                    )

                    Text(
                        text = "${product.title}",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(),
                        color = Color.Black,
                        fontWeight = FontWeight(700)
                    )

                    Text(
                        text = "Product Details",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Left,
                        color = Color.Black,
                        fontWeight = FontWeight(700),
                        modifier = Modifier.padding(top = 16.dp)
                    )

                    Text(
                        text = "${product.description}",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Left,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Button(
                    text = "Login",
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 18.dp)
                        .padding(horizontal = 16.dp, vertical = 30.dp),
                    enabled = true,
                    shape = RoundedCornerShape(8.dp)
                )
            }
        }
    }
}

@Composable
fun TitleComponent(modifier: Modifier = Modifier, onBackClick: () -> Unit = {}) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)

        ) {
            Image(
                painter = painterResource(id = MyIcons.back),
                contentDescription = "Icon Back",
                Modifier
                    .size(24.dp)
                    .clickable { onBackClick() }
            )
            Text(text = "Product Details", fontSize = 20.sp, textAlign = TextAlign.Center)
            Image(
                painter = painterResource(id = MyIcons.heart),
                contentDescription = "Icon Back",
                Modifier.size(24.dp)
            )

        }
        Divider(color = Color.Gray, thickness = 0.7.dp)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(
        product = Product(
            id = 1,
            title = "Product 1",
            description = "Description 1",
            image = "https://picsum.photos/200/300",
            price = 10.0,
            category = "Category 1",
            rating = Rating()
        ),
    )
}

