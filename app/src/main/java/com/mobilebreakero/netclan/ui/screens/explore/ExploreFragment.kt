package com.mobilebreakero.netclan.ui.screens.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.mobilebreakero.netclan.R
import com.mobilebreakero.netclan.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null
    private var exploreViewModel: ExploreViewModel? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         exploreViewModel =
             ViewModelProvider(this)[ExploreViewModel::class.java]

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textExplore

        exploreViewModel!!.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = requireView().findViewById<TabLayout>(R.id.tab_layout)
        val tabTitles = listOf("INDIVIDUAL", "PROFESSIONAL", "MERCHANT")
        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[0]))
        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[1]))
        tabLayout.addTab(tabLayout.newTab().setText(tabTitles[2]))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val selectedTabIndex = tab.position
                when (selectedTabIndex) {
                    0 -> exploreViewModel?.setText("This is Individual Fragment")
                    1 -> exploreViewModel?.setText("This is Professional Fragment")
                    2 -> exploreViewModel?.setText("This is Merchant Fragment")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}