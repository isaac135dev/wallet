import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.economiapp.ui.theme.Ui.BottomNavigationBar
import com.example.economiapp.ui.theme.Ui.Home.HomeComponents.BalanceSection
import com.example.economiapp.ui.theme.Ui.Home.HomeComponents.DailyExpensesSection
import com.example.economiapp.ui.theme.Ui.Home.HomeComponents.MonthSection
import com.example.economiapp.ui.theme.Ui.Home.HomeComponents.ProfileSection
import com.example.economiapp.ui.theme.Ui.Theme.GreenTop

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        floatingActionButton = {
            ElevatedButton(onClick = {
                navController.navigate("TransactionHistoryView")
            }
            ) {

            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp))
                    .background(GreenTop)
            ) {
                Column {
                    ProfileSection()
                    Spacer(modifier = Modifier.height(12.dp))
                    BalanceSection()
                    Spacer(modifier = Modifier.height(12.dp))
                    MonthSection()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Box(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                DailyExpensesSection()
            }



        }
    }
}