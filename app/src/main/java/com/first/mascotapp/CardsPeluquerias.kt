package com.first.mascotapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.first.mascotapp.databinding.ActivityPeluqueriasBinding

class CardsPeluquerias: AppCompatActivity() {

    private lateinit var binding: ActivityPeluqueriasBinding

    override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
        binding = ActivityPeluqueriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peluqueriasID = intent.getIntExtra(PELUQUERIAS_ID_EXTRA, -1)
        val peluquerias = peluqueriasFromID(peluqueriasID)
        if(peluquerias != null)
        {
            binding.cover.setImageResource(peluquerias.cover)
            binding.title.text = peluquerias.title
            //binding.description.text = peluquerias.description
        }
    }

    private fun peluqueriasFromID(peluqueriasID: Int): Peluquerias?
    {
        for(peluquerias in peluqueriasList)
        {
            if(peluquerias.id == peluqueriasID)
                return peluquerias
        }
        return null
    }

}