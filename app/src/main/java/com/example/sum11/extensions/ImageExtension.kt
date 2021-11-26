package com.example.sum11.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sum11.R

fun ImageView.setImage(url: String?) {
    if(!url.isNullOrEmpty()) {
        Glide.with(context).load(url).placeholder(R.color.grey).error(R.color.grey).into(this)
    } else {
        setImageResource(R.color.grey)
    }
}