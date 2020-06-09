package tech.lightion.tmdb.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import tech.lightion.tmdb.model.Movie
import tech.lightion.tmdb.network.MovieService

/**
 * This ViewModel is used to fetch and display Movie List from the TMDB apis
 */

class StreamingViewModel : ViewModel() {
    val itemList = MutableLiveData<List<Movie>>()
    private val movieService = MovieService.getMovieService()
    var job: Job? = null
    val loading = MutableLiveData<Boolean>()


    fun setListData() {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO).launch {

            val response = movieService.getMovies(1)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    itemList.value = response.body()?.list
                    loading.value = false
                } else
                    Log.d("RETROTEST", "${response.message()}")
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}