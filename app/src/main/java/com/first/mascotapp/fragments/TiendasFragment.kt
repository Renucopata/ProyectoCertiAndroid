package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.first.mascotapp.R
import com.first.mascotapp.adapters.ServicesAdapter
import com.first.mascotapp.databinding.FragmentTiendasBinding
import com.first.mascotapp.databinding.FragmentVetsBinding
import com.first.mascotapp.fragments.viewModels.ServicesViewModel
import com.first.mascotapp.models.ServiceListItem

class TiendasFragment : Fragment() {
    lateinit var binding: FragmentTiendasBinding

    val servicesViewModel: ServicesViewModel by activityViewModels()
    val serviceList : List<ServiceListItem> = listOf(
        ServiceListItem("Semevet","Consulta general",R.drawable.semevet1),
        ServiceListItem("Semevet","Especialidad",R.drawable.semevet1)
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTiendasBinding.inflate(inflater, container, false)
        binding.servicesViewModel = servicesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTiendas.adapter = ServicesAdapter(serviceList)


        binding.rvTiendas.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


    }
}