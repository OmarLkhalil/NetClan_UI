package com.mobilebreakero.netclan.ui.screens.explore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobilebreakero.netclan.databinding.FragmentIndvidualBinding

class FragmentIndividual : Fragment() {

    private var _binding: FragmentIndvidualBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIndvidualBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}