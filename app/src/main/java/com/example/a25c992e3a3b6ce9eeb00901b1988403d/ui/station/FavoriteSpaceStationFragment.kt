package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.adapter.FavoriteSpaceStationAdapter
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentFavoriteSpaceStationBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.FavoriteSpaceStationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteSpaceStationFragment : BaseFragment<FragmentFavoriteSpaceStationBinding, FavoriteSpaceStationViewModel>() {

    private lateinit var adapter: FavoriteSpaceStationAdapter

    override fun getBinding(): FragmentFavoriteSpaceStationBinding {
        return FragmentFavoriteSpaceStationBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): FavoriteSpaceStationViewModel {
        return ViewModelProvider(this).get(FavoriteSpaceStationViewModel::class.java)
    }

    override fun initUI() {
        initObservable()
        mViewModel.getSpaceStation()
    }

    private fun initObservable() {
        mViewModel.spaceStation.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                initRecyclerAdapter(it)
            }
        }
        mViewModel.changeStation.observe(viewLifecycleOwner){
            adapter.notifyItemChanged(getItemPosition(it))
        }
    }

    private fun getItemPosition(data:SpaceStationItem):Int{
        return adapter.dataSource.indexOf(data)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerAdapter(spaceStationList: List<SpaceStationItem>) {
        if (mBinding.rvFavoriteSpaceStation.adapter == null) {
            adapter = FavoriteSpaceStationAdapter()
            mBinding.rvFavoriteSpaceStation.adapter = adapter
            adapter.setData(spaceStationList,mViewModel)
        } else {
            adapter.notifyDataSetChanged()
        }
    }

}