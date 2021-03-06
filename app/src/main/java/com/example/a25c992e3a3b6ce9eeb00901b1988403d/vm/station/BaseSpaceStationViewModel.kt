package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

open class BaseSpaceStationViewModel @Inject constructor(repository: BaseRepository) :
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

    fun getEarthEUSDistance(targetStation: SpaceStation):Int{
        var earthStation: SpaceStation?
        runBlocking {
            earthStation =
                database.spaceStationDao().getStationByName(DatabaseConst.SPACE_SHUTTLE_DEFAULT_STATION_NAME)
        }
        if (earthStation == null)
            return 0
        return earthStation!!.calculateDistance(targetStation)
    }

    override fun init() {
        //empty body
    }
}