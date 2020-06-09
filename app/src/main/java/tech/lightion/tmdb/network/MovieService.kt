package tech.lightion.tmdb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieService {

    private val BASE_URL = "https://api.themoviedb.org"

    fun getMovieService(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    fun getCastService(): CastApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CastApi::class.java)
    }
}