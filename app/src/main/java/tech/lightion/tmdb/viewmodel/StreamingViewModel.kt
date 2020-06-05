package tech.lightion.tmdb.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import tech.lightion.tmdb.model.Movie
import tech.lightion.tmdb.network.MovieService

class StreamingViewModel : ViewModel() {
    val itemList = MutableLiveData<List<Movie>>()
    val movieService = MovieService.getMovieService()
    var job: Job? = null



    fun setListData() {

        job = CoroutineScope(Dispatchers.IO).launch {

            val response = movieService.getMovies(1)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful)
                    itemList.value = response.body()?.list
                else
                    Log.d("RETROTEST", "${response.message()}")
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}