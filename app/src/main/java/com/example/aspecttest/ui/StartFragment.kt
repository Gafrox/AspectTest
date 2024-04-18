package com.example.aspecttest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aspecttest.App
import com.example.aspecttest.Screens
import com.example.aspecttest.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private val router = App.INSTANCE.router
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btn1.setOnClickListener {
                router.navigateTo(Screens.equipments())
            }
            btn2.setOnClickListener {
                router.navigateTo(Screens.combined())
            }
        }
    }
}