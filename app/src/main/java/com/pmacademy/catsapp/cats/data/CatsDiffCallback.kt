package com.pmacademy.catsapp.cats.data

import androidx.recyclerview.widget.DiffUtil
import com.pmacademy.catsapp.cats.data.Cat

class CatsDiffCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }
}
