package com.example.aspecttest.ui.equipments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aspecttest.R
import com.example.aspecttest.databinding.ItemEquipmentBinding
import com.example.aspecttest.network.Equipment
import com.example.aspecttest.utils.ResourceProvider
import javax.inject.Inject

private const val STATUS_CODE_INSTALLED = "installed"
private const val STATUS_CODE_WITHDRAWN = "withdrawn"

private const val CRITICALITY_CODE_1 = "1"
private const val CRITICALITY_CODE_2 = "2"
private const val CRITICALITY_CODE_3 = "3"
private const val CRITICALITY_CODE_4 = "4"
private const val CRITICALITY_CODE_5 = "5"


class EquipmentHolder @Inject constructor(
    private val binding: ItemEquipmentBinding,
    private val navigateAction: (Equipment) -> Unit,
    private val resourceProvider: ResourceProvider
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: Equipment) {
        with(binding) {
            val statusColor = when (item.status_code) {
                STATUS_CODE_INSTALLED -> resourceProvider.getColor(R.color.green)
                STATUS_CODE_WITHDRAWN -> resourceProvider.getColor(R.color.gray)
                else -> resourceProvider.getColor(R.color.white)
            }
            val criticalityColor = when (item.criticality_code) {
                CRITICALITY_CODE_1, CRITICALITY_CODE_2 -> resourceProvider.getColor(R.color.red)
                CRITICALITY_CODE_3 -> resourceProvider.getColor(R.color.yellow)
                CRITICALITY_CODE_4 -> resourceProvider.getColor(R.color.green)
                CRITICALITY_CODE_5 -> resourceProvider.getColor(R.color.gray)
                else -> resourceProvider.getColor(R.color.white)
            }
            tvCode.text = item.code
            tvName.text = item.name
            tvStatus.text = item.ststus
            tvCriticality.text = item.criticality
            tvStatus.setBackgroundColor(statusColor)
            tvCriticality.setBackgroundColor(criticalityColor)
            root.setOnClickListener {
                navigateAction(item)
            }
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
            navigateAction: (Equipment) -> Unit,
            resourceProvider: ResourceProvider
        ): EquipmentHolder = EquipmentHolder(
            binding = ItemEquipmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            navigateAction = navigateAction,
            resourceProvider = resourceProvider
        )
    }
}