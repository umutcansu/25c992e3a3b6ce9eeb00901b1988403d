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
    SpaceStationViewModel(repository) {


    fun getFavoriteSpaceStation() {
        runBlocking {
            spaceStation.value = database.spaceStationDao().getFavoriteStateStation()
        }
    }

    override fun init() {

    }
}