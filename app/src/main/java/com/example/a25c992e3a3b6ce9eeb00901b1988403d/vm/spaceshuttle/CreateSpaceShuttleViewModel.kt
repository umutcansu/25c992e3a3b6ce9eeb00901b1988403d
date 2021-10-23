package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.spaceshuttle

import android.app.Application
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.BaseViewModel
import kotlinx.coroutines.launch


class CreateSpaceShuttleViewModel(application: Application):BaseViewModel(application) {

    fun getStation(){
        launch {
            val result = database.spaceShuttleDao().getAllList()
        }
    }
}