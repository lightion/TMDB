package tech.lightion.tmdb.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tech.lightion.tmdb.model.CastList

/**
 * interface to fetch lists of cast for a particular movie
 */

interface CastApi {
    @GET("/3/movie/{movieId}/credits?api_key=35ccd8d20c633fed2cb9740bdb467096")
    suspend fun getCast(@Path("movieId") movieId: Int) : Response<CastList>
}