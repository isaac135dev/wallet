package com.example.economiapp.ui.theme.Model.data

import androidx.annotation.DrawableRes
import java.sql.Date

data class HistoryTransaction (
    val nameUser: String,
    val currency: String,
    val date: String,
    @DrawableRes val image: Int
)