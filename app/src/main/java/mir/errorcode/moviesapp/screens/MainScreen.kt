package mir.errorcode.moviesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import mir.errorcode.moviesapp.MainViewModel
import mir.errorcode.moviesapp.data.models.Movies
import mir.errorcode.moviesapp.navigation.Screens

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel){

    val allMovies = viewModel.allMovies.observeAsState(listOf()).value

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(20.dp)
        ) {
            items(items = allMovies.take(10)) { item ->
                MovieItem(item = item, navController = navController)
            }
        }
    }

}



@Composable
fun MovieItem(item: Movies, navController: NavController){

    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable {
                navController.navigate(Screens.Details.route + "/${item.id}")
            }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image.medium),
                contentDescription = "image",
                modifier = Modifier.size(128.dp)
            )
            Column {
                Text(text = item.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Row {
                    Text(text = "Rating: ", fontWeight = FontWeight.Bold)
                    Text(text = item.rating.average.toString())
                }
                Row {
                    Text(text = "Genre: ", fontWeight = FontWeight.Bold)
                    item.genres.take(2).forEach { Text(text = "$it")  }
                }
                Row {
                    Text(text = "Premiered: ", fontWeight = FontWeight.Bold)
                    Text(text = item.premiered)
                }
            }
        }

    }

}