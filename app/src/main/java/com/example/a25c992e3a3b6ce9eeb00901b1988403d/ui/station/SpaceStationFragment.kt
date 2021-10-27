package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import android.annotation.SuppressLint
import android.view.View
import android.widget.Filter
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.adapter.SpaceStationAdapter
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.helper.UIExtension.getCurrentPosition
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentSpaceStationBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.SpaceStationViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class SpaceStationFragment : BaseFragment<FragmentSpaceStationBinding, SpaceStationViewModel>() {


    private lateinit var adapter: SpaceStationAdapter
    private lateinit var filter: Filter

    override fun getBinding(): FragmentSpaceStationBinding {
        return FragmentSpaceStationBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): SpaceStationViewModel {
        return ViewModelProvider(this).get(SpaceStationViewModel::class.java)
    }

    override fun initUI() {
        initButton()
        initSearchBox()
        initFilter()
        initObservable()
        mViewModel.getSpaceStation()
        mViewModel.getCurrentSpaceShuttle()
    }

    private fun initButton() {
        mBinding.apply {
            tvPrev.setOnClickListener {
                if (rvSpaceStation.adapter != null) {
                    rvSpaceStation.scrollToPosition(getCurrentPosition() - 1)
                }
            }

            tvNext.setOnClickListener {
                if (rvSpaceStation.adapter != null) {
                    rvSpaceStation.scrollToPosition(getCurrentPosition() + 1)
                }
            }
        }
    }

    private fun initSearchBox() {
        mBinding.svSpaceStation.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter.filter(newText)
                return false
            }

        })
    }

    private fun initFilter() {
        filter = object : android.widget.Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val result = FilterResults()
                val resultList = ArrayList<SpaceStation>()
                val spaceStation = mViewModel.spaceStation.value

                if (constraint.isNullOrEmpty()) {
                    spaceStation?.forEach {
                        resultList.add(it)
                    }
                } else {
                    spaceStation?.forEach{ d ->
                        val constraintLower = constraint.toString().lowercase(Locale.ROOT)
                        val nameLower = d.name.lowercase(Locale.ROOT)
                        if (nameLower.startsWith(constraintLower))
                            resultList.add(d)
                    }
                }

                result.count = resultList.size
                result.values = resultList

                return result
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (results?.values != null)
                    @Suppress("UNCHECKED_CAST")
                    initRecyclerAdapter(results.values as ArrayList<SpaceStation>, true)
                else
                    initRecyclerAdapter(mViewModel.spaceStation.value ?: emptyList())
            }

        }

    }

    private fun getCurrentPosition(): Int {
        return mBinding.rvSpaceStation.getCurrentPosition()
    }

    private fun initObservable() {
        mViewModel.spaceStation.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                mBinding.clStationList.visibility = View.VISIBLE
                initRecyclerAdapter(it)
            }
        }
        mViewModel.changeStation.observe(viewLifecycleOwner) {
            adapter.notifyItemChanged(getCurrentPosition())
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerAdapter(
        spaceStationList: List<SpaceStation>,
        forcedList: Boolean = false
    ) {
        if (mBinding.rvSpaceStation.adapter == null || forcedList) {
            adapter = SpaceStationAdapter()
            mBinding.rvSpaceStation.adapter = adapter
            adapter.setData(spaceStationList, mViewModel)
        } else {
            adapter.notifyDataSetChanged()
        }
    }
}