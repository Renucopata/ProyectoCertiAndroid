package com.first.mascotapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.databinding.ItemServiceBinding
import com.first.mascotapp.models.ServiceListItem

class ServicesAdapter ( val serviceListItem: List<ServiceListItem>) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemServiceBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bind(serviceListItem[position])
    }

    override fun getItemCount(): Int = serviceListItem.size

    inner class ViewHolder(private val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {

        /*fun bind(imageUrl: ServiceListItem) {
            binding.ser = imageUrl

        }*/
    }
}