package com.example.aspecttest.ui.equipmentdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aspecttest.databinding.FragmentEquipmentsDetailBinding
import com.example.aspecttest.network.EquipmentDetail
import com.example.aspecttest.network.EquipmentIdRequest
import com.example.aspecttest.network.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ARG_PARAM_ID = "ID"

class EquipmentsDetailFragment : Fragment() {

    private var id: String? = null
    private lateinit var binding: FragmentEquipmentsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ARG_PARAM_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEquipmentsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            if (id != null) {
                val result = apiService.getEquipmentById(EquipmentIdRequest(id)).returnValue
                withContext(Dispatchers.Main) {
                    bind(result)
                }
            }
        }
    }

    fun updateEquipmentDetail(currentId: String) {
        id = currentId
        CoroutineScope(Dispatchers.IO).launch {
            val result = apiService.getEquipmentById(EquipmentIdRequest(id)).returnValue
            withContext(Dispatchers.Main) {
                bind(result)
            }
        }
    }

    private fun bind(result: EquipmentDetail) {
        with(binding) {
            tvCode.text = result.code
            tvName.text = result.name
            tvDepartment.text = result.department.name
            tvStatus.text = result.status.value
            tvHierarchyLevelType.text = result.HierarchyLevelType?.name
            tvCostCode.text = result.costCode.name

            tvInventoryNumber.text = result.inventoryNumber
            tvModel.text = result.model
            tvCommissDate.text = result.commissDate
            tvInitialValue.text = result.initialValue
            tvSerialNumber.text = result.serialNumber
            tvInstallationDate.text = result.installationDate

            tvEcology.text = result.ecology.toString()
            tvSafety.text = result.safety.toString()
            tvDormantCause.text = result.dormantCause
            tvDormantStartDate.text = result.dormantStartDate
            tvDormantEndDate.text = result.dormantEndDate
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) =
            EquipmentsDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_ID, id)
                }
            }
    }
}