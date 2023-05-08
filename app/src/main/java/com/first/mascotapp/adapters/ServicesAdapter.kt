package com.first.mascotapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.databinding.ItemServiceBinding
import com.first.mascotapp.models.ServiceListItem

class ServicesAdapter ( val serviceListItem: List<ServiceListItem>) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemServiceBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.serviceModel = serviceListItem[position]

    }

    override fun getItemCount(): Int = serviceListItem.size

    inner class ViewHolder( val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {


    }
}