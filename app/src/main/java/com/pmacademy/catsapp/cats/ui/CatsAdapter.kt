package com.pmacademy.catsapp.cats.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pmacademy.catsapp.databinding.CatsListItemBinding
import com.pmacademy.catsapp.loadFromUrl
import com.pmacademy.catsapp.cats.data.Cat
import com.pmacademy.catsapp.cats.data.CatsDiffCallback

class CatsAdapter : ListAdapter<Cat, CatsAdapter.CatsViewHolder>(CatsDiffCallback()) {

    class CatsViewHolder(private val binding: CatsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat) {
            binding.ivCatImage.loadFromUrl(cat.avatarUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val binding = CatsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
