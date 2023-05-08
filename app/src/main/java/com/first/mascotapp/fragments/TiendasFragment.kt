package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.first.mascotapp.R
import com.first.mascotapp.databinding.FragmentVetsBinding
import com.first.mascotapp.fragments.viewModels.ServicesViewModel
import com.first.mascotapp.models.ServiceListItem

class TiendasFragment : Fragment() {
    lateinit var binding: FragmentVetsBinding

    val servicesViewModel: ServicesViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVetsBinding.inflate(inflater, container, false)
        binding.servicesViewModel = servicesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}