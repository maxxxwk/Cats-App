package com.pmacademy.catsapp

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadFromUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher)
        .into(this)
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}
