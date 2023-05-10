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
import com.first.mascotapp.databinding.FragmentPeluqueriasBinding
import com.first.mascotapp.databinding.FragmentVetsBinding
import com.first.mascotapp.fragments.viewModels.ServicesViewModel
import com.first.mascotapp.models.ServiceListItem


class PeluqueriasFragment : Fragment() {
    lateinit var binding: FragmentPeluqueriasBinding

    val servicesViewModel: ServicesViewModel by activityViewModels()


    val serviceList : List<ServiceListItem> = listOf(
       // ServiceListItem("Semevet","Consulta general",R.drawable.semevet1),
        //ServiceListItem("Semevet","Especialidad",R.drawable.semevet1)
    )



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeluqueriasBinding.inflate(inflater, container, false)
        binding.servicesViewModel = servicesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPeluquerias.adapter = ServicesAdapter(serviceList)


        binding.rvPeluquerias.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        servicesViewModel.getServiceList2(requireContext()){}
    }

}