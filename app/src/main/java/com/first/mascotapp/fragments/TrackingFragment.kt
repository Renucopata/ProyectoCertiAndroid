package com.first.mascotapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.mascotapp.R
import com.first.mascotapp.databinding.FragmentMapsBinding
import com.first.mascotapp.databinding.FragmentTrackingBinding

class TrackingFragment : Fragment() {

    private var _binding: FragmentTrackingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrackingBinding.inflate(inflater, container, false)
        return binding.root
    }
}