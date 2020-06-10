package tech.lightion.tmdb.application

import android.app.Application
import io.realm.Realm

/**
 * Application class, to initialize the Realm db only once
 */
class TMDBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}