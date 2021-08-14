package com.example.jetpackcompose.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.jetpackcompose.R


@Composable
fun LoadImageUrl(url: String?, placeholder: Int = R.mipmap.ic_launcher): MutableState<Bitmap?>  {

    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)
    val context = LocalContext.current

    /*val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
    Glide.with(context).load(imageUrl)
        .placeholder(placeholder)
        .apply(requestOptions)
        .centerCrop()
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) { }
            override fun onResourceReady(
                resource: Bitmap,
                transition: Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }
        })*/


    // get network image
    Glide.with(context)
        .asBitmap()
        .load(url)
        .placeholder(placeholder)
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) { }
            override fun onResourceReady(
                resource: Bitmap,
                transition: Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }
        })

    return bitmapState
}



