package com.example.databindingtemplate


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.databindingtemplate.databinding.FragmentTileBinding

/**
 * A simple [Fragment] subclass.
 */
class TileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
 //       return inflater.inflate(R.layout.fragment_tile, container, false)
        return FragmentTileBinding.inflate(inflater,container,false).apply {
            viewModel=TileVM()
        }.root
    }


}
//override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//    vehicleHealthViewModel = viewModelProvider(viewModelFactory)
//
//    observeVehicleHealthItemsUpdates()
//    observeNoVehicleConnectivityNotification()
//    configureVehicleHealthItemClickListeners()
//
//    return FragmentVehicleHealthBinding.inflate(inflater, container, false).apply {
//        lifecycleOwner = this@VehicleHealthFragment
//        viewModel = vehicleHealthViewModel
//        adapter = vehicleHealthAdapter
//        isHeaderLoading = _isHeaderLoading
//        addVehicleSummaryHeaderFragment(this)
//    }.root
//}
