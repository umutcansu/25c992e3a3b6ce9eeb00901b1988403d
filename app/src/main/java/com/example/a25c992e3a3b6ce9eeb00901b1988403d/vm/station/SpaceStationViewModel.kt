package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceShuttle
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
open class SpaceStationViewModel @Inject constructor(repository: BaseRepository) :
    BaseSpaceStationViewModel(repository) {

    val currentShuttle: MutableLiveData<SpaceShuttle> =
        MutableLiveData<SpaceShuttle>(null)

    fun getSpaceStation() {
        runBlocking {
            spaceStation.value = database.spaceStationDao().getAllStation()
        }
    }

    fun getCurrentSpaceShuttle(){
        runBlocking {
            currentShuttle.value = database.spaceShuttleDao().getCurrentSpaceShuttle()
        }
    }

    override fun init() {

    }
}