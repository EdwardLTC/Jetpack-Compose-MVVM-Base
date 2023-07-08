package com.example.myapplication.feature.presentation.bottom.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.ImageLoader
import coil.compose.AsyncImage
import com.example.myapplication.dummy.Food
import com.example.myapplication.feature.ui.theme.MyIcons
import org.jetbrains.annotations.Async
import java.time.format.TextStyle

@Composable
fun FoodComponent(food: Food, onItemClick: (Food) -> Unit = {}) {
    Column(
        modifier = Modifier
            .widthIn(max = 150.dp)
            .padding(bottom = 5.dp)
            .clickable { onItemClick(food) }
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(40.dp)
                    .zIndex(2f)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE0E0E0),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .background(
                        color = Color(0xFFFCFCFC), shape = RoundedCornerShape(size = 10.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = MyIcons.add),
                    contentDescription = "Icon Add",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .offset(y = 14.dp)
                    .size(140.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE0E0E0),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .background(
                        color = Color(0xFFFCFCFC), shape = RoundedCornerShape(size = 16.dp)
                    )
                    .padding(20.dp)
            ) {
                AsyncImage(
                    model = food.image,
                    contentDescription = "Food Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = 1.dp,
                            color = Color(0xFFE0E0E0),
                            shape = RoundedCornerShape(size = 16.dp)
                        ),
                    contentScale = ContentScale.Crop,
                    imageLoader = ImageLoader(context = LocalContext.current)
                )
            }
        }
        Column(modifier = Modifier.padding(top = 20.dp, start = 5.dp, bottom = 10.dp)) {
            Text(
                text = "$${food.price}",
                color = Color.Green,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                text = food.name,
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
    val food = Food(
        name = "Burger",
        price = 10,
        image = "https://images.pexels.com/photos/6210774/pexels-photo-6210774.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        description = "Burger is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled."
    )
    FoodComponent(food)
}
