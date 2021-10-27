package com.example.a25c992e3a3b6ce9eeb00901b1988403d.ui.station

import android.view.View
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

    private fun initObservable() {
        mViewModel.spaceStationSaved.observe(viewLifecycleOwner) {
            if (it) {
                navigationStart()
                visibleLoadingOrContent(CONTENT)
            }
        }
    }

    override fun initUI() {
        visibleLoadingOrContent(LOADING)
        initObservable()
    }

    private val LOADING: Int = 0
    private val CONTENT: Int = 1


    private fun visibleLoadingOrContent(state: Int) {
        if (state == LOADING) {
            mBinding.loadingLayout.visibility = View.VISIBLE
            mBinding.mainContent.visibility = View.GONE
        } else if (state == CONTENT) {
            mBinding.loadingLayout.visibility = View.GONE
            mBinding.mainContent.visibility = View.VISIBLE
        }
    }

    private fun navigationStart() {
        val navHostFragment =
            childFragmentManager.fragments.firstOrNull { it.id == R.id.stationFragmentContainerView }
        navHostFragment?.let {
            val navController = (navHostFragment as NavHostFragment).navController

            val navGraph = navController.navInflater.inflate(R.navigation.station_nav)
            navGraph.startDestination = R.id.spaceStationFragment
            navController.graph = navGraph

            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.spaceStationFragment, R.id.favoriteSpaceStationFragment
                )
            )
            activity?.actionBar?.let {
                if (it.isShowing)
                    NavigationUI.setupActionBarWithNavController(
                        activity as AppCompatActivity,
                        navController,
                        appBarConfiguration
                    )
            }
            mBinding.mainBottomNavigation.setupWithNavController(navController)
        }
    }
}