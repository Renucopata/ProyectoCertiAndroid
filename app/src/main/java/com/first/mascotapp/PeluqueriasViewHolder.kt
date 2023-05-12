package com.first.mascotapp

import androidx.recyclerview.widget.RecyclerView

class PeluqueriasViewHolder(
    private val peluqueriasCellBinding: PeluqueriasCellBinding,
    private val clickListener: PeluqueriasClickListener
    ) : RecyclerView.ViewHolder(peluqueriasCellBinding.root)
    {
        fun bindPeluquerias(peluquerias: Peluquerias)
        {
            peluqueriasCellBinding.cover.setImageResource(peluquerias.cover)
            peluqueriasCellBinding.title.text = peluquerias.title

            peluqueriasCellBinding.cardView.setOnClickListener{
                clickListener.onClick(peluquerias)
            }
        }
}