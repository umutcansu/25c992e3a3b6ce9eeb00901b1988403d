package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.spaceshuttle

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
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
    val maxProgression = 15
    val maxProgressionValue = MutableLiveData(maxProgression.toString())
    val buttonEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val savedSuccess: MutableLiveData<Boolean> = MutableLiveData(false)


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
                checkValueValid() && name.value != null && name.value!!.isNotEmpty()
        }
    }

    private fun checkValueValid(): Boolean {
        spaceShuttle.apply {
            val c = capacity.get()
            val s = speed.get()
            val d = durability.get()

            maxProgressionValue.value = calculateScore().toString()
                return c > 0 && s > 0 && d > 0 &&
                        (c + s + d == maxProgression)

        }
    }

    private fun calculateScore(): Int {
        spaceShuttle.apply {
            val c = capacity.get()
            val s = speed.get()
            val d = durability.get()
            var result = maxProgression - (c + s + d)
            if(result <= 0)
                result = 0

            return result
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




}