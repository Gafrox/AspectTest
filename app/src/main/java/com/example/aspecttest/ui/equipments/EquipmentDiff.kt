package com.example.aspecttest.ui.equipments

import androidx.recyclerview.widget.DiffUtil
import com.example.aspecttest.network.Equipment

object EquipmentDiff : DiffUtil.ItemCallback<Equipment>() {
    override fun areItemsTheSame(
        oldItem: Equipment,
        newItem: Equipment
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Equipment,
        newItem: Equipment
    ): Boolean = oldItem == newItem
}