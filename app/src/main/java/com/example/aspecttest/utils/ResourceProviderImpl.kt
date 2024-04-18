package com.example.aspecttest.utils

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.aspecttest.ui.equipments.EquipmentsFragment
import javax.inject.Inject

interface ResourceProvider {
    fun getColor(resId: Int): Int
    fun getParentFragmentManager(): FragmentManager
}

class ResourceProviderImpl
@Inject constructor(
    private val context: Context,
    private val fragment: EquipmentsFragment
) :
    ResourceProvider {

    override fun getColor(resId: Int): Int {
        return context.getColor(resId)
    }

    override fun getParentFragmentManager() = fragment.parentFragmentManager
}