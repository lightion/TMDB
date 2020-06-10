package tech.lightion.tmdb.extensions

import tech.lightion.tmdb.model.User

/**
 * Extension equalUserName to check if the given user name exist in the database or not
 * Extension allowLogin to check if the given user exist in the database
 */

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