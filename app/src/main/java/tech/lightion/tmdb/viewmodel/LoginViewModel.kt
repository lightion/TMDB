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

//        val userList = getUserData().value
//        Log.d("REALMCRUD", "$userList")
//        if(userList.isNullOrEmpty()) {
//            userRepo.addUser(user)
//            Log.d("REALMCRUD", "Added the first user")
//        } else {
//            userList.let {
//                var userExist = false
//                it.forEach { existingUser ->
//                    if (existingUser.userName == user.userName)
//                        userExist = true
//                }
//                if (userExist)
//                    loginUserError.value = true
//                else {
//                    userRepo.addUser(user)
//                    Log.d("REALMCRUD", "Added the new user")
//                }
//            }
//        }
    }

    private fun checkUserExist(user: User): Boolean {
        return if (userRepo.getUsers().isEmpty())
            false
        else {
            userRepo.getUsers().equalUserName(user)
        }
    }
//    private fun getUserData(): LiveData<List<User>> {
//        return Transformations.map(userRepo.getUsers()) {
//            it
//        }
//    }
}