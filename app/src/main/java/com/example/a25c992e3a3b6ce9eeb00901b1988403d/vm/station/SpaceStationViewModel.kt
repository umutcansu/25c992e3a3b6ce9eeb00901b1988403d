package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
open class SpaceStationViewModel @Inject constructor(repository: BaseRepository) :
    BaseViewModel(repository) {

    val spaceStation: MutableLiveData<List<SpaceStation>> =
        MutableLiveData<List<SpaceStation>>()
    val changeStation: MutableLiveData<SpaceStation> = MutableLiveData()

    fun setFavorite(data: SpaceStation) {
        data.isFavorite = !data.isFavorite
        changeStation.value = data
            runBlocking {
                database.spaceStationDao().update(data)
            }
    }

    fun getSpaceStation() {
        runBlocking {
            spaceStation.value = database.spaceStationDao().getAllStation()
        }
    }


    override fun init() {

    }
}