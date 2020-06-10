package tech.lightion.tmdb.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Model user class used for the realm database and authentication
 */

open class User (
    @PrimaryKey var userName: String = "",
   var password: String = ""
) : RealmObject()