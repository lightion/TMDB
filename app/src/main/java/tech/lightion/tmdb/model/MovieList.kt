package tech.lightion.tmdb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Data class used for List of movies
 */
@Parcelize
data class MovieList(
    @SerializedName("items")
    val list: ArrayList<Movie>
): Parcelable