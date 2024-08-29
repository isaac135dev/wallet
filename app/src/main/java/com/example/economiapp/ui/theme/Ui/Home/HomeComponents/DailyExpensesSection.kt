package com.example.economiapp.ui.theme.Ui.Home.HomeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Shop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.ui.theme.Model.data.CardsExpenses
import com.example.economiapp.ui.theme.Ui.Theme.WhiteCard

val expenses = listOf(
    CardsExpenses(
        day = "Lunes",
        numberDay = "20",
        month = "enero",
        balance = 50.000
    ),
    CardsExpenses(
        day = "Miercoles",
        numberDay = "12",
        month = "Febrero",
        balance = 50.000
    ),
    CardsExpenses(
        day = "Jueves",
        numberDay = "18",
        month = "marzo",
        balance = 50.000
    ),
    CardsExpenses(
        day = "Sabado",
        numberDay = "28",
        month = "Abril",
        balance = 500000.02
    )
)

@Preview
@Composable
fun DailyExpensesSection() {
    LazyColumn(
        modifier = Modifier.background(Color.White)
    ) {
        items(expenses.size) { index ->
            ExpensesItems(index)
        }
    }
}

@Composable
fun ExpensesItems(index: Int) {
    val cardExpenses = expenses[index]

    var lasttemPaddingEnd = 0.dp
    if (index == expenses.size - 1) {
        lasttemPaddingEnd = 20.dp
    }

    Box(
        modifier = Modifier.padding(top = 16.dp, bottom = lasttemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .shadow(
                    elevation = 23.dp,
                )
                .clip(RoundedCornerShape(25.dp))
                .fillMaxWidth()
                .height(200.dp)
                .background(MaterialTheme.colorScheme.background)
                .clickable {

                }
                .padding(vertical = 12.dp, horizontal = 16.dp),
        ) {
            Box(
                modifier = Modifier.padding(vertical = 10.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cardExpenses.numberDay,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(2f)
                    )
                    Text(
                        text = cardExpenses.day + "," + cardExpenses.month,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(horizontal = 2.dp)
                            .weight(10f)
                    )
                    Text(
                        text = "$ ${cardExpenses.balance}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 50.dp)
                    )
                }
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)

            )

            Column {
                BuyItems()
            }
        }
    }
}

@Composable
fun BuyItems() {

    Box(
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Rounded.Shop, contentDescription = "shope")
            }

            Column(
                modifier = Modifier
                    .padding(start = 7.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Restaurant & Comida",
                        modifier = Modifier.weight(1f),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "$ 50,000",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                }
                Text(
                    text = "$ 50,000",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }
        }
    }
}