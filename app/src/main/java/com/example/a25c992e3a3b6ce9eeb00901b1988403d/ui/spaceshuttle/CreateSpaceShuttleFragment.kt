package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.spaceshuttle

import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.R
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceShuttle
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentCreateSpaceShuttleBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.spaceshuttle.CreateSpaceShuttleViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CreateSpaceShuttleFragment :
    BaseFragment<FragmentCreateSpaceShuttleBinding, CreateSpaceShuttleViewModel>() {


    override fun getBinding(): FragmentCreateSpaceShuttleBinding {
        return FragmentCreateSpaceShuttleBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): CreateSpaceShuttleViewModel {
        return ViewModelProvider(this).get(CreateSpaceShuttleViewModel::class.java)
    }

    override fun initUI() {
        mViewModel.getSpaceShuttleCount()
        initObservable()
    }


    private fun initObservable() {
        mViewModel.spaceShuttleCount.observe(viewLifecycleOwner){
            if(it > 0)
                navigate()
            else
                mBinding.contentLayout.visibility = View.VISIBLE
        }
        mViewModel.savedSuccess.observe(viewLifecycleOwner) {
            if (it)
                navigate()
        }
    }

    private fun navigate() {
        findNavController().apply {
            navigate(R.id.action_createSpaceShuttleFragment_to_stationMainFragment)
        }
    }
}