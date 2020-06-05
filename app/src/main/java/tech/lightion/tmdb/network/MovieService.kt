package tech.lightion.tmdb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object MovieService {

    private val BASSE_URL = "https://api.themoviedb.org"

    fun getMovieService(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASSE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}