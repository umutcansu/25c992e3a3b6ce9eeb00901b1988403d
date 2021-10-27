package com.example.a25c992e3a3b6ce9eeb00901b1988403d.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.R
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.adapter.BaseAdapter
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.adapter.BaseViewHolder
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.SpaceStationItemViewBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.SpaceStationViewModel

class SpaceStationAdapter:
    BaseAdapter<SpaceStation, BaseViewHolder<ViewDataBinding>, SpaceStationViewModel>() {

    lateinit var mViewModel: SpaceStationViewModel
    lateinit var mBinding: SpaceStationItemViewBinding

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = DataBindingUtil.inflate<SpaceStationItemViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.space_station_item_view,
            parent,
            false
        )
        mBinding.vm = mViewModel
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int, data: SpaceStation) {
        mBinding = binding as SpaceStationItemViewBinding
        mBinding.data = data
    }

    fun setData(spaceList: List<SpaceStation>, mViewModel: SpaceStationViewModel) {
        dataSource = spaceList
        this.mViewModel = mViewModel
    }

}
