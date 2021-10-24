package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.spaceshuttle

import androidx.appcompat.widget.AppCompatSeekBar
import androidx.databinding.Observable
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.R
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseViewModel
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceShuttle
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.model.SpaceShuttleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateSpaceShuttleViewModel @Inject constructor(repository: BaseRepository) :
    BaseViewModel(repository) {

    val spaceShuttle = SpaceShuttleItem()
    val maxProgressionValue = MutableLiveData(15)
    val buttonEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val savedSuccess: MutableLiveData<Boolean> = MutableLiveData(false)
    val spaceShuttleCount: MutableLiveData<Long> = MutableLiveData(0)

    override fun init() {
        initObservable()
    }

    private fun initObservable() {
        spaceShuttle.apply {
            name.observeForever {
                checkButtonState()
            }
            capacity.addOnPropertyChangedCallback(object :
                Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    capacityTextValue.value = capacity.get().toString()
                    checkButtonState()
                }

            })
            speed.addOnPropertyChangedCallback(object :
                Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    speedTextValue.value = speed.get().toString()
                    checkButtonState()
                }

            })
            durability.addOnPropertyChangedCallback(object :
                Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    durabilityTextValue.value = durability.get().toString()
                    checkButtonState()
                }

            })
        }
    }

    private fun checkButtonState() {
        spaceShuttle.apply {
            buttonEnable.value =
                name.value != null && name.value!!.isNotEmpty() && checkValueValid()
        }
    }

    private fun checkValueValid(): Boolean {
        spaceShuttle.apply {
            val c = capacity.get()
            val s = speed.get()
            val d = durability.get()
            return c > 0 && s > 0 && d > 0 &&
                    (c + s + d == maxProgressionValue.value)

        }
    }

    private fun getSpaceShuttleEntity(): SpaceShuttle {
        return SpaceShuttle(
            name = spaceShuttle.name.value!!,
            speed = spaceShuttle.speed.get(),
            capacity = spaceShuttle.capacity.get(),
            durability = spaceShuttle.durability.get()
        )
    }

    fun saveSpaceShuttle() {
        launch {
            val result = database.spaceShuttleDao().insert(getSpaceShuttleEntity())
            savedSuccess.value = result > 0
        }
    }

    fun getSpaceShuttleCount(){
        launch {
            val result =  database.spaceShuttleDao().getAllCount()
            spaceShuttleCount.value = result
        }
    }


}