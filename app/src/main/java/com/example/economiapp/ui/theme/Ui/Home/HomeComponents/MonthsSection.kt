package com.example.economiapp.ui.theme.Ui.Home.HomeComponents

import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.ui.theme.Model.data.Months
import com.example.economiapp.ui.theme.Ui.Theme.GreenTop
import com.example.economiapp.ui.theme.Ui.Theme.GreenTopLight
import java.text.SimpleDateFormat
import java.util.Locale

val monthsList = listOf(
    Months(
        months = "Enero",
        numberMonths = 1
    ),
    Months(
        months = "Febrero",
        numberMonths = 2
    ),
    Months(
        months = "Marzo",
        numberMonths = 3
    ),
    Months(
        months = "Abril",
        numberMonths = 4
    ),
    Months(
        months = "Mayo",
        numberMonths = 5
    ),
    Months(
        months = "Junio",
        numberMonths = 6
    ),
    Months(
        months = "Julio",
        numberMonths = 7
    ),
    Months(
        months = "Agosto",
        numberMonths = 8
    ),
    Months(
        months = "Septiembre",
        numberMonths = 9
    ),
    Months(
        months = "Octubre",
        numberMonths = 10
    ),
    Months(
        months = "Nobiembre",
        numberMonths = 11
    ),
    Months(
        months = "Diciembre",
        numberMonths = 12
    )
)

@Preview
@Composable
fun MonthSection() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val currentMonth = calendar.get(Calendar.MONTH) + 1
    val dayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)
    val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    val month = SimpleDateFormat("MMMM", Locale.getDefault()).format(calendar.time)
    val year = calendar.get(Calendar.YEAR)

    val lazyListState = rememberLazyListState()

    val currentIndex = monthsList.indexOfFirst { it.numberMonths == currentMonth }

    LaunchedEffect(key1 = currentIndex) {
        if (currentIndex != 1) {
            lazyListState.scrollToItem(currentIndex)
        }
    }

    LazyRow (
        state = lazyListState,
        horizontalArrangement = Arrangement.Center
    ){
        items(monthsList.size) {index ->
            val month = monthsList[index]
            MonthsItems(month, currentMonth)
        }
    }
}

@Composable
fun MonthsItems(month: Months, currentMonth: Int) {
    val itemColor = if (month.numberMonths == currentMonth) GreenTopLight else { GreenTop }

    val lastItemPaddingEnd = if (month == monthsList.last()) 16.dp else 0.dp

    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(itemColor)
                .width(80.dp)
                .clickable {
                }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = month.months,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
        }
    }
}
