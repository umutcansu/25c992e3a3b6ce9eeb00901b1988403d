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
class FavoriteSpaceStationViewModel @Inject constructor(repository: BaseRepository) :
    BaseViewModel(repository) {

    val spaceStation: MutableLiveData<List<SpaceStationItem>> =
        MutableLiveData<List<SpaceStationItem>>()

    val changeStation: MutableLiveData<SpaceStationItem> = MutableLiveData()

    fun getSpaceStation() {
        httpClient.getSpaceShuttle().enqueue(object : retrofit2.Callback<List<SpaceStationItem>> {
            override fun onResponse(
                call: Call<List<SpaceStationItem>>,
                response: Response<List<SpaceStationItem>>
            ) {
                if (response.body().isNullOrEmpty().not())
                    spaceStation.value =
                        prepareFavoriteStation(response.body()!!).filter { it.isFavorite }.toList()


            }

            override fun onFailure(call: Call<List<SpaceStationItem>>, t: Throwable) {

            }

        })
    }

    fun prepareFavoriteStation(data: List<SpaceStationItem>): List<SpaceStationItem> {
        data.forEach { station ->
            runBlocking {
                val result: Boolean? = database.spaceStationDao().stationIsFavorite(station.name)
                station.isFavorite = result ?: false
            }
        }
        return data
    }

    fun setFavorite(data: SpaceStationItem) {
        data.isFavorite = !data.isFavorite
        changeStation.value = data
        launch {
            runBlocking {
                database.spaceStationDao().stationDeleteByName(data.name)
            }
            database.spaceStationDao()
                .insert(SpaceStation(name = data.name, isFavorite = data.isFavorite))
        }
    }

    override fun init() {

    }
}