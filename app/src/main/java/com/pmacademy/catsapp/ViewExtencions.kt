package com.pmacademy.catsapp

import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadFromUrl(url: String, @DrawableRes placeholderRes: Int? = null) {
    Glide.with(this.context)
        .load(url).also {
            if (placeholderRes != null) {
                it.placeholder(placeholderRes)
            }
        }.into(this)
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}
