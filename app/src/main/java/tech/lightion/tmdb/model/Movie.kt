package tech.lightion.tmdb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    var title: String,
    val genre: String = "",
    @SerializedName("release_date")
    val releaseDate: String,
    val userScore: Int = 70,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    var imageUrl: String = ""
) : Parcelable