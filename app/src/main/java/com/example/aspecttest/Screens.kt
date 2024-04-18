package com.example.aspecttest

import com.example.aspecttest.ui.combined.CombinedFragment
import com.example.aspecttest.ui.equipmentdetail.EquipmentsDetailFragment
import com.example.aspecttest.ui.equipments.EquipmentsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun equipments() = FragmentScreen { EquipmentsFragment() }

    fun equipmentsDetail(id: String) = FragmentScreen { EquipmentsDetailFragment.newInstance(id) }

    fun combined() = FragmentScreen { CombinedFragment() }
}