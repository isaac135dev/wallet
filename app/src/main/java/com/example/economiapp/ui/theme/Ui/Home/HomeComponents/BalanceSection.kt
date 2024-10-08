package com.example.economiapp.ui.theme.Ui.Home.HomeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardDoubleArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.ui.theme.Model.data.Currency
import com.example.economiapp.ui.theme.Ui.Theme.GreenTop

val currencies = listOf(
    Currency(
        name = "Total",
        value = 622000.00f,
    ),
)

@Preview
@Composable
fun BalanceSection() {
    BoxWithConstraints (
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(GreenTop)
    ){
        val boxWithConstraintsScope = this
        val with = boxWithConstraintsScope.maxWidth / 2

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ){
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.width(with),
                text = "Ingreso",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.width(with),
                    text = "$300,000",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(currencies.size) {index ->
                    CurrencyItem(
                        index,
                        with
                    )

                }
            }

        }
    }
}

@Composable
fun CurrencyItem(index: Int, with: Dp) {
    val currency = currencies[index]

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            modifier = Modifier.width(with),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier
                    .padding(start = 10.dp),
                text = currency.name,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Text(
            modifier = Modifier
                .width(with)
                .padding(start = 10.dp),
            text = "$ ${currency.value}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
    }
}
