package com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.R
import com.example.economiapp.ui.theme.Model.data.CreditCard

val cardItemsTrans = listOf(
    CreditCard(
        "300.000",
        "standar",
        "12/22",
        "Valida hasta",
        R.drawable.ic_visa
    ),
    CreditCard(
        "50.000",
        "premium",
        "04/22",
        "Valida hasta",
        R.drawable.ic_mastercard
    ),
    CreditCard(
        "100.000",
        "standar",
        "09/27",
        "Valida hasta",
        R.drawable.ic_visa
    ),
    CreditCard(
        "1,300.000",
        "premium",
        "11/27",
        "Valida hasta",
        R.drawable.ic_mastercard
    ),
    CreditCard(
        "800.000",
        "standar",
        "01/29",
        "Valida hasta",
        R.drawable.ic_visa
    ),

    )

@Preview
@Composable
fun CardSectionTransaction() {
    LazyRow(
        contentPadding = PaddingValues(20.dp)
    ) {
        itemsIndexed(cardItemsTrans) { index, item ->
            Spacer(modifier = Modifier.width(8.dp))
            CardView(item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun CardView(item: CreditCard) {
    var isFlipped by remember { mutableStateOf(false) }
    val rotation = animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 600, easing = LinearOutSlowInEasing)
    )
    Box(
        modifier = Modifier
            .width(210.dp)
            .height(260.dp)
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 12f * density
            }
            .shadow(elevation = 23.dp, shape = RoundedCornerShape(25.dp))
            .clip(RoundedCornerShape(25.dp))
            .background(Color.LightGray)
            .clickable {
                isFlipped = !isFlipped
            }
            .padding(vertical = 12.dp, horizontal = 16.dp)

    ) {
        if (rotation.value <= 90f) {
            FrontSide(item)
        } else {
            BackSide()
        }

    }
}

@Composable
fun FrontSide(item: CreditCard) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = item.image),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "$${item.balance}",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = item.nameCard,
            fontSize = 14.sp,
            fontWeight = FontWeight.Thin
        )



        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = item.validText,
            fontSize = 10.sp,
            fontWeight = FontWeight.W200
        )
        Text(
            text = item.dateCard,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun BackSide() {
    Box(
        modifier = Modifier
            .graphicsLayer {
                rotationY = 180f
            }
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Back Side",
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}