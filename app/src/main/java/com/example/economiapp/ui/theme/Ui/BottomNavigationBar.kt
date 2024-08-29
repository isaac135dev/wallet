package com.example.economiapp.ui.theme.Ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.PieChart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.economiapp.ui.theme.Model.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Dashboard
    ),
    BottomNavigation(
        title = "ChartView",
        icon = Icons.Rounded.PieChart
    ),
    BottomNavigation(
        title = "TransactionHistoryView",
        icon = Icons.Rounded.FilterList
    ),
    BottomNavigation(
        title = "4",
        icon = Icons.Rounded.MoreVert
    )
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            items.forEach { items ->
                NavigationBarItem(
                    selected = currentDestination == items.title,
                    onClick = {
                              navController.navigate(items.title) {
                                  popUpTo(navController.graph.startDestinationId) {
                                      saveState = true
                                  }
                                  launchSingleTop = true
                                  restoreState = true
                              }
                    },
                    icon = {
                        Icon(
                            imageVector = items.icon,
                            contentDescription = items.title
                        )
                    }
                )
            }
        }
    }
}