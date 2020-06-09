package tech.lightion.tmdb.model.database

import io.realm.Realm
import io.realm.RealmObject

object RealmManager {
    fun <T : RealmObject> add(model: T) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            it.insertOrUpdate(model)
        }
        realm.close()
    }

    inline fun <reified T : RealmObject> findAll(): List<T> {
        val realm = Realm.getDefaultInstance()
        val list = realm.copyFromRealm(
            realm.where(T::class.java)
                .findAll()
        )
        realm.close()
        return list
    }
}