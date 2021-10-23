package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.BaseViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit.RetrofitHelper
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import retrofit2.Call
import retrofit2.Response

class SpaceStationViewModel(application: Application):BaseViewModel(application) {

    val spaceStation : MutableLiveData<List<SpaceStationItem>> = MutableLiveData<List<SpaceStationItem>>()

    fun getSpaceStation(){
        RetrofitHelper.Call?.getSpaceShuttle()?.enqueue(object : retrofit2.Callback<List<SpaceStationItem>>{
            override fun onResponse(
                call: Call<List<SpaceStationItem>>,
                response: Response<List<SpaceStationItem>>
            ) {
                spaceStation.value = response.body()
            }

            override fun onFailure(call: Call<List<SpaceStationItem>>, t: Throwable) {

            }

        })
    }
}