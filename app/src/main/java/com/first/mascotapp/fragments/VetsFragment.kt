package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.first.mascotapp.R
import com.first.mascotapp.adapters.LostAdapter
import com.first.mascotapp.adapters.ServicesAdapter
import com.first.mascotapp.databinding.FragmentVetsBinding
import com.first.mascotapp.fragments.viewModels.ServicesViewModel
import com.first.mascotapp.models.ServiceListItem


class VetsFragment : Fragment(), ServicesAdapter.OnItemClickListener {
    lateinit var binding: FragmentVetsBinding

    val servicesViewModel: ServicesViewModel by activityViewModels()
    val adapter = ServicesAdapter(listOf())

    /*val serviceList : List<ServiceListItem> = listOf(
        ServiceListItem("Semevet","Consulta general",R.drawable.semevet1),
        ServiceListItem("Semevet","Especialidad",R.drawable.semevet1)
    )*/



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVetsBinding.inflate(inflater, container, false)
        binding.servicesViewModel = servicesViewModel
        binding.lifecycleOwner = this
        return binding.root
    }
    override fun onButtonClick(position: Int) {
        view?.findNavController()?.navigate(R.id.reservarFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvVets.adapter = adapter
        adapter.setOnItemClickListener(this)
        servicesViewModel.serviceList.observe(viewLifecycleOwner){
            adapter.serviceListItem = it
            adapter.notifyDataSetChanged()
        }


        binding.rvVets.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        servicesViewModel.getServiceList(requireContext()){}

    }


}