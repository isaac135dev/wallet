package com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.R
import com.example.economiapp.ui.theme.Model.data.HistoryTransaction

val items = listOf(
    HistoryTransaction(
        "Juliana",
        "-40.000",
        "04/20/2024",
        R.drawable.ic_launcher_foreground
    ),
    HistoryTransaction(
        "Ana",
        "-100.000",
        "10/01/2024",
        R.drawable.ic_launcher_foreground
    ),
    HistoryTransaction(
        "Centro Comercial Altavista",
        "-500.000",
        "01/30/2023",
        R.drawable.ic_launcher_foreground
    ),
    HistoryTransaction(
        "Asadero",
        "-55.023",
        "02/10/2023",
        R.drawable.ic_launcher_foreground
    )
)

@Preview
@Composable
fun ModalScreenHistory() {
    var isVisible by remember {
        mutableStateOf(false)
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .height(25.dp)
                    .clickable {
                        isVisible = !isVisible
                    },
                contentAlignment = Alignment.Center
            ) {
                Divider(
                    Modifier
                        .width(50.dp)
                        .height(5.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(MaterialTheme.colorScheme.background)
                )
            }

            if (!isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraintsScope = this
                    val with = boxWithConstraintsScope.maxWidth / 2

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.width(with),
                                text = "History",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                modifier = Modifier.width(with),
                                text = "",
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(items.size) { index ->
                                CurrencyItem(index, with)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index: Int, with: Dp) {
    val currency = items[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(14.dp))
            .clickable {

            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (
            modifier = Modifier.width(with),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.LightGray)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = currency.image),
                    contentDescription = currency.nameUser,
                    tint = Color.White
                )
            }
            Column {

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = currency.nameUser,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    text = currency.date,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }

        }

        Text(
            modifier = Modifier
                .width(with)
                .padding(start = 10.dp),
            text = "$ ${currency.currency}",
            fontWeight = FontWeight.Bold,
            fontSize = 16 .sp,
            color = Color.Gray,
            textAlign = TextAlign.End
        )
    }
}
