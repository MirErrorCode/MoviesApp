package mir.errorcode.moviesapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import mir.errorcode.moviesapp.MainViewModel
import mir.errorcode.moviesapp.data.models.Movies

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel){

    val allMovies = viewModel.allMovies.observeAsState(listOf()).value
    allMovies.forEach { Log.d("MainScreen", "ID: ${it.id} name: ${it.name}") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(items = allMovies.take(10)) { item ->
                MovieItem(item = item)
            }
        }
    }

}



@Composable
fun MovieItem(item : Movies){
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = item.id.toString())
        Text(text = item.name)

    }
}