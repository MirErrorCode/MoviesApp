package mir.errorcode.moviesapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import mir.errorcode.moviesapp.MainViewModel


@Composable
fun DetailsScreen(navController: NavController, viewModel: MainViewModel, itemId: String) {

    Text("Details screen: item id: ${itemId}")



}