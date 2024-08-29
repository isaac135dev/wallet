package com.example.economiapp.ui.theme.Ui

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.economiapp.ui.theme.Ui.ChartView.ChartView
import com.example.economiapp.ui.theme.Ui.Theme.EconomiAPPTheme
import com.example.economiapp.ui.theme.Ui.Theme.GreenTop
import com.example.economiapp.ui.theme.Ui.TransactionHistoryView.TransactionHistoryView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EconomiAPPTheme {
                SetBarColor(color = GreenTop)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(color = color)
        }
    }
}

@Composable
private fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") { HomeScreen(navController) }
        composable("ChartView") { ChartView(navController) }
        composable("TransactionHistoryView") { TransactionHistoryView(navController) }
        composable("screen4") {  }
    }
}