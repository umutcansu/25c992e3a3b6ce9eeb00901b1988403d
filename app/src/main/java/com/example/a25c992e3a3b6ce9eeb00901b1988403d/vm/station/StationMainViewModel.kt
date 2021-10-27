package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceStationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class StationMainViewModel @Inject constructor(repository: BaseRepository) :
    BaseViewModel(repository) {
    val spaceStationSaved: MutableLiveData<Boolean> = MutableLiveData()
    val spaceStationIsLoad: MutableLiveData<Boolean> = MutableLiveData()

    override fun init() {
        getSpaceStationIsLoad()
    }

    fun getSpaceStationIsLoad() {
        runBlocking {
            spaceStationIsLoad.value = database.spaceStationDao().stationIsLoad()
        }
    }

    fun getSpaceStation() {
        runBlocking {
            database.spaceStationDao().deleteAll()
            getSpaceStationAPI()
        }
    }

    private fun getSpaceStationAPI() {
        httpClient.getSpaceShuttle()
            .enqueue(object : retrofit2.Callback<List<SpaceStationItem>> {
                override fun onResponse(
                    call: Call<List<SpaceStationItem>>,
                    response: Response<List<SpaceStationItem>>
                ) {
                    if (response.body().isNullOrEmpty().not()) {
                        saveSpaceStations(response.body()!!)
                        spaceStationSaved.value = true
                    }
                }

                override fun onFailure(call: Call<List<SpaceStationItem>>, t: Throwable) {

                }

            })
    }

    private fun saveSpaceStations(spaceStations: List<SpaceStationItem>) {
        spaceStations.forEach { station ->
            runBlocking {
                database.spaceStationDao()
                    .insert(convertSpaceStationItem(station))
            }
        }
    }

    private fun convertSpaceStationItem(spaceStationItem: SpaceStationItem): SpaceStation {
        spaceStationItem.apply {
            return SpaceStation(
                name = name,
                isFavorite = false,
                capacity = capacity,
                coordinateX = coordinateX,
                coordinateY = coordinateY,
                stock = stock,
                need = need
            )
        }
    }
}