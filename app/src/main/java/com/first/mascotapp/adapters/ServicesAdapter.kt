package com.first.mascotapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.databinding.ItemServiceBinding
import com.first.mascotapp.models.ServiceListItem

class ServicesAdapter ( var serviceListItem: List<ServiceListItem>) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemServiceBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.serviceModel = serviceListItem[position]
        holder.binding.btnReservar.setOnClickListener {
            onItemClickListener?.onButtonClick(position)
        }

    }

    interface OnItemClickListener{
        fun onButtonClick(position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    override fun getItemCount(): Int = serviceListItem.size

    inner class ViewHolder( val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {


    }
}