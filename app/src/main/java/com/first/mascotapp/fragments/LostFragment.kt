package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.mascotapp.R
import com.first.mascotapp.databinding.FragmentLostBinding
import com.first.mascotapp.models.lostItemModel

class LostFragment : Fragment() {
    lateinit var binding: FragmentLostBinding
    val lostList : List<lostItemModel> = listOf(lostItemModel("Mbaperro", "3 semanas", R.drawable.dog4),
    lostItemModel("cony pony", "1 semana", R.drawable.dog5 ), lostItemModel("Napoleon", "4 semanas", R.drawable.dog6),
    lostItemModel("Pastor", "5dias", R.drawable.pastordog),lostItemModel("Firulais", "2 dias", R.drawable.dog7))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvLost.adapter = null //Cambiar el adapter
    }
}