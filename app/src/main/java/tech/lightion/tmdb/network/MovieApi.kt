package tech.lightion.tmdb.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tech.lightion.tmdb.model.Movie
import tech.lightion.tmdb.model.MovieList

/**
 * Interface to fetch list of movies
 */
interface MovieApi {

    @GET("/3/list/{movieId}?api_key=35ccd8d20c633fed2cb9740bdb467096")
    suspend fun getMovies(@Path("movieId") movieId: Int): Response<MovieList>
}