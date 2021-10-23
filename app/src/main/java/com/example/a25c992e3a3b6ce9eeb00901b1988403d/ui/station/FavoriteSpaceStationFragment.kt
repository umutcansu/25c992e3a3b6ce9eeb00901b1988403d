package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import androidx.lifecycle.ViewModelProvider
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentFavoriteSpaceStationBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.FavoriteSpaceStationViewModel

class FavoriteSpaceStationFragment : BaseFragment<FragmentFavoriteSpaceStationBinding, FavoriteSpaceStationViewModel>() {


    override fun getBinding(): FragmentFavoriteSpaceStationBinding {
        return FragmentFavoriteSpaceStationBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): FavoriteSpaceStationViewModel {
        return ViewModelProvider(this).get(FavoriteSpaceStationViewModel::class.java)
    }

    override fun initUI() {

    }

}