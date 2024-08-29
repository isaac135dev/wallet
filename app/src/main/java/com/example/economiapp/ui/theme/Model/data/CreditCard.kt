package com.example.economiapp.ui.theme.Model.data

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes

data class CreditCard(
    val balance: String,
    val nameCard: String,
    val dateCard: String,
    val validText: String,
    @DrawableRes val image: Int
)