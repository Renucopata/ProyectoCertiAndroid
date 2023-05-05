package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.first.mascotapp.R
import com.first.mascotapp.adapters.LostAdapter
import com.first.mascotapp.databinding.FragmentLostBinding
import com.first.mascotapp.fragments.viewModels.LostViewModel
import com.first.mascotapp.models.LostItemModel

class LostFragment : Fragment() {
    lateinit var binding: FragmentLostBinding
    val lostViewModel: LostViewModel by activityViewModels()


    val lostList : List<LostItemModel> = listOf(
        LostItemModel("Mbaperro", "3 semanas", R.drawable.dog4),
    LostItemModel("cony pony", "1 semana", R.drawable.dog5 ), LostItemModel("Napoleon", "4 semanas", R.drawable.dog6),
    LostItemModel("Pastor", "5dias", R.drawable.pastordog), LostItemModel("Firulais", "2 dias", R.drawable.dog7)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLostBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvLost.adapter = LostAdapter(lostList)
            // Con SafeArgs (recomendado)
            //view.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(it))

            // Sin SafeArgs, no tiene el argumento
            //view.findNavController().navigate(R.id.rvLost)

        binding.rvLost.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}