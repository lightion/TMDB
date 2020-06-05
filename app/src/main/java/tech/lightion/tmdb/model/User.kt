package tech.lightion.tmdb.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User (
    @PrimaryKey var userName: String = "",
   var password: String = ""
) : RealmObject()