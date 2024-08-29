package com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.R
import com.example.economiapp.ui.theme.Model.data.ContactPerson
import kotlin.math.roundToInt

val listPerson = listOf(
    ContactPerson(
        "crhistian",
        R.drawable.image3
    ),
    ContactPerson(
        "Sebastian",
        R.drawable.image3
    ),
    ContactPerson(
        "Julian",
        R.drawable.image3
    ),
    ContactPerson(
        "Isaac",
        R.drawable.image3
    ),

    )

@Preview
@Composable
fun ContactSectionTransaction() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        contentPadding = PaddingValues(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .size(50.dp)

            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add",
                )
            }
            Spacer(modifier = Modifier.width(18.dp))
        }
        itemsIndexed(listPerson) { index, item ->
            Spacer(modifier = Modifier.width(8.dp))
            RowPerson(item = item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun RowPerson(item: ContactPerson) {
    var toggled by remember {
        mutableStateOf(false)
    }
    val animatedPadding by animateDpAsState(
        if (toggled) {
            12.dp
        } else {
            0.dp
        },
        label = "padding"
    )
    Box(
        Modifier
            .padding(animatedPadding)
            .clickable(
                interactionSource = remember {
                MutableInteractionSource()
            },
                indication = null
            ) {
                toggled = !toggled

            }
    ) {
        Box(
            modifier = Modifier
                .shadow(elevation = 23.dp, shape = RoundedCornerShape(15.dp))
                .height(80.dp)
                .width(80.dp)
                .background(if (!toggled) Color.LightGray else Color.Gray)
                .padding(vertical = 15.dp),
            contentAlignment = Alignment.BottomCenter
        ) {

            Text(
                text = item.nameUser,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.nameUser,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(y = (-20).dp, x = 12.dp)
                .height(55.dp)
                .width(55.dp)
                .clip(RoundedCornerShape(10.dp)),
        )
    }

}
