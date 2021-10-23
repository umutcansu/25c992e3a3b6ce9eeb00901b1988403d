package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SpaceStationViewModel @Inject constructor(repository: BaseRepository) : BaseViewModel(repository) {

    val spaceStation : MutableLiveData<List<SpaceStationItem>> = MutableLiveData<List<SpaceStationItem>>()

    fun getSpaceStation(){
        httpClient.getSpaceShuttle().enqueue(object : retrofit2.Callback<List<SpaceStationItem>>{
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