package tech.lightion.tmdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * A shared ViewModel between MainFragment and StreamingFragment used to hide BottomNav
 */

class MainFragmentViewModel : ViewModel() {

    val hideBottomNavigation = MutableLiveData<Boolean>()

    val loading = MutableLiveData<Boolean>()

    fun setBottomNavVisibilityHidden(value: Boolean) {
        hideBottomNavigation.value = value
    }
}