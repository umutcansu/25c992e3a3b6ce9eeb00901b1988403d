package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import androidx.lifecycle.ViewModelProvider
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentSpaceStationBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.SpaceStationViewModel

class SpaceStationFragment : BaseFragment<FragmentSpaceStationBinding, SpaceStationViewModel>() {


    override fun getBinding(): FragmentSpaceStationBinding {
        return FragmentSpaceStationBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): SpaceStationViewModel {
        return ViewModelProvider(this).get(SpaceStationViewModel::class.java)
    }

    override fun initUI() {
        mViewModel.getSpaceStation()
    }
}