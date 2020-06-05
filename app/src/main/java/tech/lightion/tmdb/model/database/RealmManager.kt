package tech.lightion.tmdb.model.database

import io.realm.Realm
import io.realm.RealmObject
import tech.lightion.tmdb.model.User

class RealmManager {
    fun <T : RealmObject> add(model: T) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction{
            it.insertOrUpdate(model)
        }
        realm.close()
    }

//    fun find(user: User) {
//        val realm = Realm.getDefaultInstance()
//        val checkUser = realm.where(User.class).equalTo()
//    }
}