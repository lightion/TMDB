package tech.lightion.tmdb.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> T.asLiveData(): LiveData<T> {
    val result = MutableLiveData<T>()
    result.postValue(this)
    return result
}