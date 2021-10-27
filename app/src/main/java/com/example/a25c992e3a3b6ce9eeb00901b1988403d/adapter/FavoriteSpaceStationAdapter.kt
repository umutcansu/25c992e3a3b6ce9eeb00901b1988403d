package com.example.a25c992e3a3b6ce9eeb00901b1988403d.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.R
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.adapter.BaseAdapter
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.adapter.BaseViewHolder
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FavoriteSpaceStationItemViewBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.FavoriteSpaceStationViewModel

class FavoriteSpaceStationAdapter : BaseAdapter<SpaceStation, BaseViewHolder<ViewDataBinding>, FavoriteSpaceStationViewModel>() {

    lateinit var mViewModel: FavoriteSpaceStationViewModel
    lateinit var mBinding: FavoriteSpaceStationItemViewBinding

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = DataBindingUtil.inflate<FavoriteSpaceStationItemViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.favorite_space_station_item_view,
            parent,
            false
        )
        mBinding.vm = mViewModel
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int, data: SpaceStation) {
        mBinding = binding as FavoriteSpaceStationItemViewBinding
        mBinding.data = data
    }

    fun setData(favoriteSpaceList: List<SpaceStation>, mViewModel: FavoriteSpaceStationViewModel) {
        dataSource = favoriteSpaceList
        this.mViewModel = mViewModel
    }
}