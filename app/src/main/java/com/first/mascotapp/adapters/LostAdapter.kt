package com.first.mascotapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.models.lostItemModel

class LostAdapter (val itemList : List<lostItemModel>) : RecyclerView.Adapter<LostListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LostListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LostListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
class LostListViewHolder(val binding: lostItemModel): RecyclerView.ViewHolder(binding.root)