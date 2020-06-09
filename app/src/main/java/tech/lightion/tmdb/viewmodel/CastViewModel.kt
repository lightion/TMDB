package tech.lightion.tmdb.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import tech.lightion.tmdb.model.Cast
import tech.lightion.tmdb.network.MovieService

class CastViewModel : ViewModel() {
    val itemList = MutableLiveData<ArrayList<Cast>>()
    val castService = MovieService.getCastService()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null

    fun setListData(movieId: Int) {
        loading.value = true
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = castService.getCast(movieId)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    itemList.postValue(response.body()?.list)
                    Log.d("RETROTEST", "${response.body()?.list}")
                    loading.value = false
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}