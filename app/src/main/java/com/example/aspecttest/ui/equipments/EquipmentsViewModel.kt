package com.example.aspecttest.ui.equipments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aspecttest.App
import com.example.aspecttest.Screens
import com.example.aspecttest.network.Equipment
import com.example.aspecttest.network.apiService
import com.example.aspecttest.ui.equipmentdetail.EquipmentsDetailFragment
import com.example.aspecttest.utils.ResourceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EquipmentsViewModel(private val resourceProvider: ResourceProvider) : ViewModel(),
    EquipmentSelectionListener {

    private val router = App.INSTANCE.router
    private val _equipmentsList = MutableLiveData<List<Equipment>>()
    val equipmentsList: LiveData<List<Equipment>> = _equipmentsList

    override fun onEquipmentSelected(id: String) {
        val equipmentsDetailFragment =
            resourceProvider.getParentFragmentManager()
                .findFragmentByTag(EQUIPMENTS_DETAIL_FRAGMENT_TAG) as? EquipmentsDetailFragment
        equipmentsDetailFragment?.updateEquipmentDetail(id)
    }

    fun onMultiWindowModeTrue(id: String) {
        onEquipmentSelected(id)
    }

    fun onMultiWindowModeFalse(id: String) {
        goToEquipmentDetailScreen(id)
    }

    private fun goToEquipmentDetailScreen(id: String) {
        router.navigateTo(Screens.equipmentsDetail(id))
    }

    suspend fun getEquipmentsList() {
        val list = apiService.getEquipmentList().returnValue.sortedBy { it.code }
        withContext(Dispatchers.Main) {
            _equipmentsList.value = list
        }
    }
}

class EquipmentsViewModelFactory
@Inject constructor(
    private val resourceProvider: ResourceProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EquipmentsViewModel(resourceProvider) as T
    }
}

interface EquipmentSelectionListener {
    fun onEquipmentSelected(id: String)
}