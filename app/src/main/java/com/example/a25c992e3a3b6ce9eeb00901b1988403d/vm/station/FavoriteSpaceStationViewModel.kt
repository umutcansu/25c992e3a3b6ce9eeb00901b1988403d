package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class FavoriteSpaceStationViewModel @Inject constructor(repository: BaseRepository) :
    BaseSpaceStationViewModel(repository) {

    fun getFavoriteSpaceStation() {
        runBlocking {
            spaceStation.value = database.spaceStationDao().getFavoriteStateStation()
        }
    }

    override fun init() {

    }
}