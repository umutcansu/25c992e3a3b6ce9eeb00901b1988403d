package com.example.a25c992e3a3b6ce9eeb00901b1988403d.model

import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData

data class SpaceShuttleItem(var name: MutableLiveData<String> = MutableLiveData(""),
                            var speed: ObservableInt = ObservableInt(0),
                            var capacity: ObservableInt = ObservableInt(0),
                            var durability: ObservableInt = ObservableInt(0)){
    val speedTextValue: MutableLiveData<String> = MutableLiveData(speed.get().toString())
    val capacityTextValue: MutableLiveData<String> = MutableLiveData(capacity.get().toString())
    val durabilityTextValue: MutableLiveData<String> = MutableLiveData(durability.get().toString())
}
