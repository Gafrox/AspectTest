package com.example.aspecttest.ui.combined

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aspecttest.databinding.FragmentCombinedBinding

class CombinedFragment : Fragment() {

    private lateinit var binding: FragmentCombinedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCombinedBinding.inflate(inflater, container, false)
        return binding.root
    }
}