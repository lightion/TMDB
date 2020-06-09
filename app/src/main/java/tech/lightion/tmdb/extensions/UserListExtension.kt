package tech.lightion.tmdb.extensions

import tech.lightion.tmdb.model.User

fun List<User>.equalUserName(user: User) : Boolean {
    this.forEach {
        if(it.userName.equals(user.userName))
            return true
    }
    return false
}

fun List<User>.allowLogin(user: User) : Boolean {
    this.forEach {
        if (it.userName.equals(user.userName) && it.password.equals(user.password))
            return true
    }
    return false
}