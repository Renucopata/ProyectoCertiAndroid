package com.first.mascotapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.GridLayoutManager
import com.first.mascotapp.*
import com.first.mascotapp.adapters.PeluqueriasAdapter
import com.first.mascotapp.databinding.FragmentPeluqueriasBinding


class PeluqueriasFragment : Fragment(), PeluqueriasClickListener {
    private lateinit var binding: FragmentPeluqueriasBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = FragmentPeluqueriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peluqueriasPopulares()

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = PeluqueriasAdapter(peluqueriasList, mainActivity)
        }
    }
    override fun onClick(peluquerias: Peluquerias)
    {
        val intent = Intent(applicationContext, CardsPeluquerias::class.java)
        intent.putExtra(PELUQUERIAS_ID_EXTRA, peluquerias.id)
        startActivity(intent)
    }

    private fun peluqueriasPopulares()
    {
        val vet1 = Peluquerias(
            R.drawable.vet1,
            "Veterinaria Buen Pastor",
            "El lugar perfecto para tus mascotas"
        )
        peluqueriasList.add(vet1)

        val vet2 = Peluquerias(
            R.drawable.vet2,
            "Centro Médico Veterinario",
            "Nos preocupamos por el bienestar de tu mascota",
        )
        peluqueriasList.add(vet2)

        peluqueriasList.add(vet1)
        peluqueriasList.add(vet2)
    }

    //val servicesViewModel: ServicesViewModel by activityViewModels()


    //val serviceList : List<ServiceListItem> = listOf(
       // ServiceListItem("Semevet","Consulta general",R.drawable.semevet1),
        //ServiceListItem("Semevet","Especialidad",R.drawable.semevet1)
    //)

    //override fun onCreateView(
        //inflater: LayoutInflater, container: ViewGroup?,
        //savedInstanceState: Bundle?
    //): View? {
        //binding = FragmentPeluqueriasBinding.inflate(inflater, container, false)
        //binding.servicesViewModel = servicesViewModel
        //binding.lifecycleOwner = this
        //return binding.root
    //}

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //super.onViewCreated(view, savedInstanceState)
        //binding.rvPeluquerias.adapter = ServicesAdapter(serviceList)


        //binding.rvPeluquerias.layoutManager =
            //LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //servicesViewModel.getServiceList(requireContext()){}
    //}


}