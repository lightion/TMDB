package tech.lightion.tmdb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * List for the cast
 */

@Parcelize
data class CastList(
    @SerializedName("cast")
    val list: ArrayList<Cast>
) : Parcelable