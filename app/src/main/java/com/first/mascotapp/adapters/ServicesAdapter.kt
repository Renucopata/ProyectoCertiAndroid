package com.first.mascotapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.databinding.ItemServiceBinding

class ServicesAdapter (private val images: List<String>) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemServiceBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class ViewHolder(private val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            binding.image = imageUrl

        }
    }
}