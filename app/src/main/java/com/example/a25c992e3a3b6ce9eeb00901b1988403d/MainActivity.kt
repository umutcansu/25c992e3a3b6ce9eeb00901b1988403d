package com.example.a25c992e3a3b6ce9eeb00901b1988403d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit.RetrofitService
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var mViewModel:MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        if(!::mViewModel.isInitialized)
            mViewModel = getViewModel()

        initUI()
    }

    override fun onStart() {
        super.onStart()
        mViewModel.getSpaceShuttleCount()
    }

    private fun getViewModel(): MainActivityViewModel {
        return ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun initUI() {
        initObservable()
    }

    private fun initObservable() {
        mViewModel.spaceShuttleCount.observe(this) {
            if (it == 0L)
                changeNavigationStartDestination(R.id.createSpaceShuttleFragment)
            else
                changeNavigationStartDestination(R.id.stationMainFragment)
        }
    }


    private fun changeNavigationStartDestination(@IdRes starDestinationId:Int) {
        val navController = binding!!.mainActivityFragmentContainerView.findNavController()
        val navGraph = navController.navInflater.inflate(R.navigation.app_nav)
        navGraph.startDestination = starDestinationId
        navController.graph = navGraph
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}