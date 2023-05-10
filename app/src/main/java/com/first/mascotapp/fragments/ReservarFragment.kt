package com.first.mascotapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.first.mascotapp.LoginActivity
import com.first.mascotapp.R
import com.first.mascotapp.databinding.FragmentReservarBinding
import com.first.mascotapp.fragments.viewModels.ReservaViewModel
import com.first.mascotapp.models.Reserva
import com.first.mascotapp.models.User

class ReservarFragment : Fragment() {
    lateinit var binding:FragmentReservarBinding
    val viewModel : ReservaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sendForm: Button = binding.btnSendForm
        sendForm.setOnClickListener {
            val id = binding.ownerID.text.toString()
            val ownerName = binding.ownerName.text.toString()
            val petName = binding.petName.text.toString()
            val date = binding.editTextDate.text.toString()
            val time = binding.editTextTime.text.toString()

            if (id.isEmpty() || ownerName.isEmpty() || petName.isEmpty() || date.isEmpty() || time.isEmpty()) {
            Toast.makeText(context,"Uno de los campos está vacío", Toast.LENGTH_SHORT).show()
            }

        else {
            val reserva = Reserva(id,ownerName,petName,date,time)
            viewModel.crearReserva(requireContext(),reserva,{
                Toast.makeText(context,"Solicitud de reserva enviada!", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            })
        }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservar, container, false)
    }


}