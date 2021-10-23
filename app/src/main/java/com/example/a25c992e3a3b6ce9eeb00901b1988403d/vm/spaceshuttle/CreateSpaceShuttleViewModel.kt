package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.spaceshuttle

import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateSpaceShuttleViewModel @Inject constructor(repository: BaseRepository): BaseViewModel(repository) {

    fun getStation(){
        launch {
            val result = database.spaceShuttleDao().getAllList()
        }
    }
}