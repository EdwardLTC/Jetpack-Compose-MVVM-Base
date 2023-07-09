package com.example.myapplication.feature.presentation.utils

import android.graphics.Paint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.feature.ui.theme.MyIcons


@Composable
fun Counter(onValueChange: (Int) -> Unit = {}) {
    val state = remember { mutableStateOf(0) }
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.White),
            onClick = {
                if (state.value > 0) {
                    state.value--
                    onValueChange(state.value)
                }
            },
            enabled = true,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Image(painter = painterResource(id = MyIcons.minus), contentDescription = "Minus")
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green)
        ) {
            Text(
                text = state.value.toString(),
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight(700)
            )
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.White),
            onClick = {
                state.value++
                onValueChange(state.value)
            },
            enabled = true,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Image(painter = painterResource(id = MyIcons.plus), contentDescription = "Plus")
        }
    }
}


@Composable
@Preview(name = "Counter Preview")
fun CounterPreview() {
    Counter()
}