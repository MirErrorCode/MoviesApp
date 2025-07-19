package mir.errorcode.moviesapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mir.errorcode.moviesapp.data.models.Movies
import mir.errorcode.moviesapp.data.network.ApiRepository
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject  constructor(private val repository: ApiRepository): ViewModel(){

    private val _allMovies = MutableLiveData<List<Movies>>()
    val allMovies: LiveData<List<Movies>>
        get()  = _allMovies


    fun getAllMovies(){
        viewModelScope.launch {
            repository.getAllMovies().let {
                if(it.isSuccessful){
                    _allMovies.postValue(it.body())
                }else {
                    Log.d("MainViewModel", "Failed to load movies: ${it.errorBody()}")
                }
            }
        }
    }


}