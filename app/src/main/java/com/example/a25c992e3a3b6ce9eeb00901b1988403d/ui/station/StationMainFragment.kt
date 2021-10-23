package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import androidx.lifecycle.ViewModelProvider
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentStationMainBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.StationMainViewModel

class StationMainFragment : BaseFragment<FragmentStationMainBinding, StationMainViewModel>() {


    override fun getBinding(): FragmentStationMainBinding {
        return FragmentStationMainBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): StationMainViewModel {
        return ViewModelProvider(this).get(StationMainViewModel::class.java)
    }

    override fun initUI() {

    }
}