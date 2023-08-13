package com.mobilebreakero.netclan.ui.screens.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mobilebreakero.netclan.databinding.FragmentNetworkBinding

class NetworkFragment : Fragment() {

    private var _binding: FragmentNetworkBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val networkViewModel =
            ViewModelProvider(this)[NetworkViewModel::class.java]

        _binding = FragmentNetworkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNetwork
        networkViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}