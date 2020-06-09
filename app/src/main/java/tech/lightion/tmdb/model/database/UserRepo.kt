package tech.lightion.tmdb.model.database

import androidx.lifecycle.LiveData
import tech.lightion.tmdb.extensions.asLiveData
import tech.lightion.tmdb.model.User

class UserRepo() {

    fun addUser(user: User) {
        RealmManager.add(user)
    }

    fun getUsers() : List<User>{
        return RealmManager.findAll()
    }
}