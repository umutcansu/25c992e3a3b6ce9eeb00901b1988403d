package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.R
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseFragment
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.FragmentStationMainBinding
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station.StationMainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StationMainFragment : BaseFragment<FragmentStationMainBinding, StationMainViewModel>() {


    override fun getBinding(): FragmentStationMainBinding {
        return FragmentStationMainBinding.inflate(layoutInflater)
    }

    override fun getViewModel(): StationMainViewModel {
        return ViewModelProvider(this).get(StationMainViewModel::class.java)
    }

    override fun initUI() {
        val navHostFragment = childFragmentManager.fragments.firstOrNull { it.id == R.id.stationFragmentContainerView }
        navHostFragment?.let {
            val navController = (navHostFragment as NavHostFragment).navController
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.spaceStationFragment, R.id.favoriteSpaceStationFragment
                )
            )
            NavigationUI.setupActionBarWithNavController(activity as AppCompatActivity,navController,appBarConfiguration)
            mBinding.mainBottomNavigation.setupWithNavController(navController)
        }

    }
}