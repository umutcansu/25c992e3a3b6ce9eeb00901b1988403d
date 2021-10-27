package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.adapter.SpaceStationAdapter
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.helper.UIExtension.getCurrentPosition
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentSpaceStationBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.SpaceStationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpaceStationFragment : BaseFragment<FragmentSpaceStationBinding, SpaceStationViewModel>() {


    private lateinit var adapter: SpaceStationAdapter

    override fun getBinding(): FragmentSpaceStationBinding {
        return FragmentSpaceStationBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): SpaceStationViewModel {
        return ViewModelProvider(this).get(SpaceStationViewModel::class.java)
    }

    override fun initUI() {
        initButton()
        initObservable()
        mViewModel.getSpaceStation()
    }

    private fun initButton() {
        mBinding.apply {
            tvPrev.setOnClickListener {
                if(rvSpaceStation.adapter != null){
                    rvSpaceStation.scrollToPosition(getCurrentPosition() - 1 )
                }
            }

            tvNext.setOnClickListener {
                if(rvSpaceStation.adapter != null){
                    rvSpaceStation.scrollToPosition(getCurrentPosition() + 1)
                }
            }
        }
    }

    private fun getCurrentPosition() : Int {
        return mBinding.rvSpaceStation.getCurrentPosition()
    }

    private fun initObservable() {
        mViewModel.spaceStation.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                mBinding.clStationList.visibility = View.VISIBLE
                initRecyclerAdapter(it)
            }
        }
        mViewModel.changeStation.observe(viewLifecycleOwner){
            adapter.notifyItemChanged(getCurrentPosition())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerAdapter(spaceStationList: List<SpaceStation>) {
        if (mBinding.rvSpaceStation.adapter == null) {
            adapter = SpaceStationAdapter()
            mBinding.rvSpaceStation.adapter = adapter
            adapter.setData(spaceStationList,mViewModel)
        } else {
            adapter.notifyDataSetChanged()
        }
    }
}