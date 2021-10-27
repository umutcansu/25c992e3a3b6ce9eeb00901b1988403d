package com.example.a25c992e3a3b6ce9eeb00901b1988403d.vm.station

import androidx.lifecycle.MutableLiveData
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.core.BaseRepository
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.database.DatabaseConst
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceShuttle
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.database.entity.SpaceStation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
open class SpaceStationViewModel @Inject constructor(repository: BaseRepository) :
    BaseSpaceStationViewModel(repository) {

    val currentShuttle: MutableLiveData<SpaceShuttle> =
        MutableLiveData<SpaceShuttle>(null)
    val errorState: MutableLiveData<String> =
        MutableLiveData<String>("")

    val STOCK_ERROR: String = "Yetersiz Stok"
    val EQUALS_STATION_ERROR: String = "Zaten Aynı İstasyondayız!"
    val FINISHED_MISSION: String = "Görev Başarılı Dünya'ya Dönüyoruz!!!"

    fun getSpaceStation() {
        runBlocking {
            spaceStation.value = database.spaceStationDao().getAllStation()
        }
    }

    fun getCurrentSpaceShuttle() {
        runBlocking {
            currentShuttle.value = database.spaceShuttleDao().getCurrentSpaceShuttle()
        }
    }

    fun travel(targetStation: SpaceStation) {
        if (currentShuttle.value == null)
            return

        val shuttle = currentShuttle.value!!

        if(targetStation.name == shuttle.currentStation){
            errorState.value = EQUALS_STATION_ERROR
            return
        }


        if (targetStation.need > 0 && shuttle.UGS >= targetStation.need) {
            val need = targetStation.need //İhtiyaç olan giysi adedi
            shuttle.UGS -= need // Uzay aracı stoğundan azaltma yapılır
            targetStation.need -= need // hedef istasyonun ihtiyacı azalır
            targetStation.stock += need // hedef istasyonun stok miktarı artar
            val distance = calculateDistanceForCurrentStation(targetStation) // mesafe hesaplanır
            shuttle.EUS -= distance // Uzay süresi azaltılır
            val time =
                distance * DatabaseConst.EUS_FACTOR / shuttle.speed // uzay aracının hızına göre ne kadar sürede yolculuk yaptığı hesaplanır
            val damageForSecond =
                shuttle.DS / DatabaseConst.DS_FACTOR // kaç saniyede bir hasar aldığı hesaplanır
            val damage: Int =
                time / damageForSecond // yapılan yolculuk süresice ne kadar hasar gördü
            shuttle.damage -= damage // Uzay aracının hasar kapasitesinden düşüklür
            shuttle.currentStation = targetStation.name //mevcut istasyon değiştirlir.
            targetStation.isFinished = true
            runBlocking { // Database update edilir.
                database.spaceStationDao().update(targetStation)
                database.spaceShuttleDao().update(shuttle)
                getSpaceStation()
                currentShuttle.value = shuttle
            }

        } else {
            errorState.value = STOCK_ERROR
            return
        }

        if (checkMissionFinished(shuttle)) {
            errorState.value = FINISHED_MISSION
            shuttle.currentStation = DatabaseConst.SPACE_SHUTTLE_DEFAULT_STATION_NAME
            runBlocking {
                database.spaceShuttleDao().update(shuttle)
            }
        }

    }

    private fun checkMissionFinished(currentShuttle: SpaceShuttle): Boolean {
        return currentShuttle.UGS <= 0 || currentShuttle.EUS <= 0 || currentShuttle.damage <= 0 || checkAllStationFinished()
    }

    private fun checkAllStationFinished(): Boolean {
        return spaceStation.value?.filter { it.name != DatabaseConst.SPACE_SHUTTLE_DEFAULT_STATION_NAME }
            ?.all { it.isFinished } ?: false
    }

    private fun calculateDistanceForCurrentStation(targetStation: SpaceStation): Int {
        if (currentShuttle.value == null)
            return 0

        var currentStation: SpaceStation?
        runBlocking {
            currentStation =
                database.spaceStationDao().getStationByName(currentShuttle.value!!.currentStation)
        }
        if (currentStation == null)
            return 0
        return currentStation!!.calculateDistance(targetStation)
    }

    override fun init() {

    }
}