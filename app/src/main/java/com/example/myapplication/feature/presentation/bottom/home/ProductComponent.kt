package com.example.myapplication.feature.presentation.bottom.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.domain.model.Product
import com.example.myapplication.domain.model.Rating
import com.example.myapplication.feature.ui.theme.MyIcons

@Composable
fun FoodComponent(
    product: Product,
    onItemClick: (Product) -> Unit = {},
    onAddClick: (Product) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .widthIn(max = 150.dp)
            .padding(bottom = 5.dp)
            .wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.TopEnd)
                .zIndex(2f)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(size = 10.dp)
                )
                .background(
                    color = Color(0xFFFCFCFC), shape = RoundedCornerShape(size = 10.dp)
                )
                .clickable {
                    onAddClick(product)
                }
        ) {
            Image(
                painter = painterResource(id = MyIcons.add),
                contentDescription = "Icon Add",
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(end = 15.dp, bottom = 14.dp)
                .offset(y = 14.dp)
                .clickable { onItemClick(product) }
        ) {
            Card(
                modifier = Modifier
                    .size(140.dp)
                    .padding(bottom = 8.dp)
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Food Image",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
            Text(
                text = "$${product.price}",
                color = Color.Green,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                text = "${product.title}",
                color = Color.Black,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}

@Preview(name = "FoodComponent")
@Composable
fun FoodComponentPreview() {
    val product = Product(
        category = "category",
        description = "description",
        id = 1,
        image = "image",
        price = 1.0,
        rating = Rating(1, 1.00),
        title = "title"
    )
    FoodComponent(product)
}
