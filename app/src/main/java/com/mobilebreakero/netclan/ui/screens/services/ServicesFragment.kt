package com.mobilebreakero.netclan.ui.screens.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mobilebreakero.netclan.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val servicesViewModel =
            ViewModelProvider(this)[ServicesViewModel::class.java]

        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textMin: TextView = binding.textKmMin


        val seekBar: SeekBar = binding.appCompatSeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                servicesViewModel.setProgress(progress)
                textMin.text = progress.toString() + " Km"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        servicesViewModel.progress.observe(viewLifecycleOwner) { newProgress ->
            seekBar.progress = newProgress
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
