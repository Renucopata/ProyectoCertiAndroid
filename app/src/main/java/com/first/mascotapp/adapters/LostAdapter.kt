package com.first.mascotapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.databinding.LostItemBinding
import com.first.mascotapp.models.LostItemModel

class LostAdapter (var itemList : List<LostItemModel>) : RecyclerView.Adapter<LostListViewHolder>() {


    //Inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostListViewHolder {
        return LostListViewHolder(LostItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }


    //Here you have to set the holder that you created down, and set the view with the values that you are going to find in your list
    //of models

    override fun onBindViewHolder(holder: LostListViewHolder, position: Int) {
        holder.binding.lostListItem = itemList[position]
    }
    //Here you get the size of the list
    override fun getItemCount(): Int {
        return itemList.size
    }

}
//Here you must declare the views on your layout
class LostListViewHolder(val binding: LostItemBinding): RecyclerView.ViewHolder(binding.root)