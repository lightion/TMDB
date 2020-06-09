package tech.lightion.tmdb.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tech.lightion.tmdb.R

fun ImageView.loadImage(uri: String?) {
    val correctedUri = uri ?: "/oSGVmWhn4WT4TI4PCiQrpym6LfW.jpg"

    val BASE_URL = "https://image.tmdb.org/t/p/w500"
    val options = RequestOptions()
        .error(R.drawable.coff)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(BASE_URL + correctedUri)
        .into(this)
}