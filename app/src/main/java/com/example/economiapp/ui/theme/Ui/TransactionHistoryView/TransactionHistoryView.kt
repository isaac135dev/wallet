package com.example.economiapp.ui.theme.Ui.TransactionHistoryView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.economiapp.ui.theme.Ui.BottomNavigationBar
import com.example.economiapp.ui.theme.Ui.Theme.GreenTop
import com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents.CardSectionTransaction
import com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents.ContactSectionTransaction
import com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents.ModalScreenHistory
import com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionsComponents.TopSectionComposable

@Composable
fun TransactionHistoryView(navController: NavController) {
    Scaffold(
        containerColor = GreenTop,

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopSectionComposable()

            Spacer(modifier = Modifier.height(10.dp))

            CardSectionTransaction()

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                text = "Send money to",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )

            ContactSectionTransaction()

            ModalScreenHistory()
        }
    }
}