package com.example.aspecttest.ui.equipments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aspecttest.R
import com.example.aspecttest.databinding.FragmentEquipmentsBinding
import com.example.aspecttest.di.DaggerAppComponent
import com.example.aspecttest.network.Equipment
import com.example.aspecttest.utils.ResourceProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val EQUIPMENTS_FRAGMENT_TAG = "equipments_fragment_tag"
const val EQUIPMENTS_DETAIL_FRAGMENT_TAG = "equipments_detail_fragment_tag"

class EquipmentsFragment : Fragment() {

    @Inject
    lateinit var resourceProvider: ResourceProvider

    @Inject
    lateinit var equipmentsViewModelFactory: EquipmentsViewModelFactory
    private val viewModel by lazy { createViewModel() }

    private lateinit var binding: FragmentEquipmentsBinding
    private var equipmentAdapter: EquipmentAdapter? = null
    private var isMultiWindowMode = false

    private fun createViewModel(): EquipmentsViewModel {
        return ViewModelProvider(this, equipmentsViewModelFactory)[EquipmentsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appComponent = DaggerAppComponent.factory().create(requireActivity(), this)
        appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEquipmentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment =
            parentFragmentManager.findFragmentByTag(EQUIPMENTS_FRAGMENT_TAG)
        if (fragment != null) {
            val containerId = (fragment.requireView().parent as? ViewGroup)?.id
            isMultiWindowMode = containerId == R.id.equipmentsContainer
        }
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getEquipmentsList()
            withContext(Dispatchers.Main) {
                viewModel.equipmentsList.observe(viewLifecycleOwner) {
                    initAdapter(it)
                }
            }
        }
    }

    private fun initAdapter(list: List<Equipment>) {
        equipmentAdapter = EquipmentAdapter(
            navigateAction = {
                if (isMultiWindowMode) {
                    viewModel.onMultiWindowModeTrue(it.id)
                } else {
                    viewModel.onMultiWindowModeFalse(it.id)
                }
            },
            resourceProvider = resourceProvider
        )
        equipmentAdapter?.submitList(list)
        with(binding) {
            rv.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            rv.adapter = equipmentAdapter
        }
    }
}