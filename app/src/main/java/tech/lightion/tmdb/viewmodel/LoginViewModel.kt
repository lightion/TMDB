package tech.lightion.tmdb.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import tech.lightion.tmdb.utility.SingleLiveEvent

class LoginViewModel : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    val realm = Realm.getDefaultInstance()
    val config = RealmConfiguration.Builder().name("tmdb.realm").build()

    val loginButton = SingleLiveEvent<Void>()

    val registerButton = SingleLiveEvent<Void>()

    val canUserLogin = MutableLiveData<Boolean>(false)

    val loginUserError = MutableLiveData<Boolean>(false)

    val userName = ObservableField("")
    val password = ObservableField<String>()

    fun loginButtonClickEvent() {
        loginButton.call()
    }
    fun performLogin(name: String, pass: String) {
        canUserLogin.postValue(allowLogin(name, pass))
    }

    fun registerButtonClickEvent() {
        registerButton.call()
    }

    fun allowLogin(name: String, pass: String) : Boolean = name == "admin" && pass == "123"

    fun signUp(name: String, pass: String) {

    }
}