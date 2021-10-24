package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StationMainViewModel @Inject constructor(repository: BaseRepository): BaseViewModel(repository) {
    override fun init() {

    }
}