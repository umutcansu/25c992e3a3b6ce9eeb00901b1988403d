package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.spaceshuttle

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.R
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentCreateSpaceShuttleBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.spaceshuttle.CreateSpaceShuttleViewModel


class CreateSpaceShuttleFragment : BaseFragment<FragmentCreateSpaceShuttleBinding, CreateSpaceShuttleViewModel>() {


    override fun getBinding(): FragmentCreateSpaceShuttleBinding {
        return FragmentCreateSpaceShuttleBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): CreateSpaceShuttleViewModel {
        return ViewModelProvider(this).get(CreateSpaceShuttleViewModel::class.java)
    }

    override fun initUI() {
        mBinding.tvInfo.setOnClickListener { navigate() }
    }

    private fun navigate(){
        findNavController().apply {
            navigate(R.id.action_createSpaceShuttleFragment_to_stationMainFragment)
        }
    }
}