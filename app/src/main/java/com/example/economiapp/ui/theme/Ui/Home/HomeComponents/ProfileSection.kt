package com.example.economiapp.ui.theme.Ui.Home.HomeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.economiapp.ui.theme.Ui.Theme.GreenTopLight

@Preview
@Composable
fun ProfileSection() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box (
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                .height(45.dp)
                .background(GreenTopLight),
            contentAlignment = Alignment.Center
        ){
            Row(
                modifier = Modifier.width(180.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "profile"
                )
                Text(
                    text = "Salary Wallet",
                    fontSize = 18.sp
                )
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "profile"
                )
            }
        }

       Box {
           Row {
               Icon(
                   modifier = Modifier.padding(horizontal = 10.dp),
                   imageVector = Icons.Rounded.Notifications,
                   contentDescription = "notification"
               )
               Icon(
                   imageVector = Icons.Rounded.MoreVert,
                   contentDescription = "notification"
               )
           }
       }
    }
}