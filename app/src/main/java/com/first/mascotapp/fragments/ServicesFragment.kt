package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.first.mascotapp.R
import com.first.mascotapp.adapters.ServicesAdapter
import com.first.mascotapp.databinding.FragmentServicesBinding
import com.first.mascotapp.fragments.viewModels.ServicesViewModel

class ServicesFragment : Fragment() {
    lateinit var binding: FragmentServicesBinding

     val servicesViewModel: ServicesViewModel by activityViewModels()
   /* private val images = listOf(
        "https://example.com/image1.jpg",
        "https://example.com/image2.jpg",
        "https://example.com/image3.jpg"
    )*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentServicesBinding.inflate(inflater, container, false)
        binding.servicesViewModel = servicesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnVets.setOnClickListener {
            view.findNavController().navigate(R.id.vetsFragment)
        }
       // binding.rvServices.adapter = ServicesAdapter(images)

    }


}