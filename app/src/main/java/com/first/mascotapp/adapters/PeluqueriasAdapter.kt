package com.first.mascotapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.first.mascotapp.Peluquerias
import com.first.mascotapp.PeluqueriasClickListener
import com.first.mascotapp.PeluqueriasViewHolder

class PeluqueriasAdapter(
    private val peluquerias: List<Peluquerias>,
    private val clickListener: PeluqueriasClickListener
    )
    : RecyclerView.Adapter<PeluqueriasViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeluqueriasViewHolder
        {
            val from = LayoutInflater.from(parent.context)
            val binding = PeluqueriasCellBinding.inflate(from, parent, false)
            return PeluqueriasViewHolder(binding, clickListener)
        }

        override fun onBindViewHolder(holder: PeluqueriasViewHolder, position: Int)
        {
            holder.bindPeluquerias(peluquerias[position])
        }

        override fun getItemCount(): Int = peluquerias.size
}