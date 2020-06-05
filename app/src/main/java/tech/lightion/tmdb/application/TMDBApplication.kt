package tech.lightion.tmdb.application

import android.app.Application
import io.realm.Realm

class TMDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}