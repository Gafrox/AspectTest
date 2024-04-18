package com.example.aspecttest.ui.equipments

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.aspecttest.network.Equipment
import com.example.aspecttest.utils.ResourceProvider

class EquipmentAdapter(
    private val navigateAction: (Equipment) -> Unit,
    private val resourceProvider: ResourceProvider
) :
    ListAdapter<Equipment, EquipmentHolder>(EquipmentDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EquipmentHolder.create(
        parent = parent,
        navigateAction = navigateAction,
        resourceProvider = resourceProvider
    )

    override fun onBindViewHolder(holder: EquipmentHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}