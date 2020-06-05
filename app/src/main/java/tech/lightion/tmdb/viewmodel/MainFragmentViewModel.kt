package tech.lightion.tmdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainFragmentViewModel : ViewModel() {

    val hideBottomNavigation = MutableLiveData<Boolean>()

    val loading = MutableLiveData<Boolean>()

    fun setBottomNavVisibilityHidden(value: Boolean) {
        hideBottomNavigation.value = value
    }
}