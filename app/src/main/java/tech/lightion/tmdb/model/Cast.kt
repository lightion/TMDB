package tech.lightion.tmdb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Model class for the cast
 */

@Parcelize
data class Cast(
    @SerializedName("cast_id")
    val castId: Int,
    @SerializedName("character")
    val character: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    var castImage: String = ""

) : Parcelable