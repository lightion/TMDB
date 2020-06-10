package tech.lightion.tmdb.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import tech.lightion.tmdb.extensions.allowLogin
import tech.lightion.tmdb.extensions.equalUserName
import tech.lightion.tmdb.model.User
import tech.lightion.tmdb.model.database.RealmManager
import tech.lightion.tmdb.model.database.UserRepo
import tech.lightion.tmdb.utility.SingleLiveEvent

/**
 * LoginViewModel used for authentication and for storing and fetching user from the Realm Database
 */
class LoginViewModel : ViewModel() {

    val userRepo = UserRepo()

    val loginButton = SingleLiveEvent<Void>()

    val registerButton = SingleLiveEvent<Void>()

    val canUserLogin = MutableLiveData<Boolean>()

    val loginUserError = MutableLiveData<Boolean>(false)

    val userAlreadyExistError = MutableLiveData<Boolean>(false)

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

    fun allowLogin(name: String, pass: String): Boolean {
        return if (userRepo.getUsers().isEmpty())
            false
        else {
            userRepo.getUsers().allowLogin(User(name, pass))
        }
    }

    fun signUp(name: String, pass: String) {
        val user = User(name, pass)
        if (checkUserExist(user)) {
            userAlreadyExistError.value = true
        } else {
            userRepo.addUser(user)
            userAlreadyExistError.value = false
            Log.d("REALMCRUD", "${userRepo.getUsers()}")
        }
    }

    private fun checkUserExist(user: User): Boolean {
        return if (userRepo.getUsers().isEmpty())
            false
        else {
            userRepo.getUsers().equalUserName(user)
        }
    }
}