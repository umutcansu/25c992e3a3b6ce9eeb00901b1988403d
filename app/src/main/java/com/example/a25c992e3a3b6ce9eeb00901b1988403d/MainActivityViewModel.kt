package com.example.a25c992e3a3b6ce9eeb00901b1988403d

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel@Inject constructor(repository: BaseRepository) :
    BaseViewModel(repository) {


    val spaceShuttleCount: MutableLiveData<Long> = MutableLiveData()

    fun getSpaceShuttleCount() {
        runBlocking {
            val result = database.spaceShuttleDao().getAllCount()
            spaceShuttleCount.value = result
        }
    }

    override fun init() {

    }
}