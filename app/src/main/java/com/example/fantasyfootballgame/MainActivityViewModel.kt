package com.example.fantasyfootballgame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fantasyfootballgame.repository.FplPlayerRepository
import androidx.lifecycle.viewModelScope
import com.example.fantasyfootballgame.model.BoostrapStatic.BootstrapStaticCall
import com.example.fantasyfootballgame.model.BoostrapStatic.FplEvent
import com.example.fantasyfootballgame.model.BoostrapStatic.FplPlayer
import com.example.fantasyfootballgame.repository.FplEventRepository
import com.example.fantasyfootballgame.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainActivityViewModel(
    private val fplPlayerRepository: FplPlayerRepository,
    private val fplEventRepository: FplEventRepository,
) : ViewModel() {

    private val mutableLiveDataElementsApi: MutableLiveData<Resource<BootstrapStaticCall>> =
        MutableLiveData()
    private val TAG = "MainActivityViewModel"

    init {
        getElementsFromApi()
    }

    fun getElementsFromRoom(): LiveData<List<FplPlayer>> =
        fplPlayerRepository.getFplPlayersFromRoom()

    fun getFplEventsFromRoom(): LiveData<List<FplEvent>> = fplEventRepository.getFplEventsFromRoom()

    fun getElementsFromApi() = viewModelScope.launch {
        try {
            mutableLiveDataElementsApi.postValue(Resource.Loading())
            val response = fplPlayerRepository.getFplPlayersFromApi()
            mutableLiveDataElementsApi.postValue(handleGetElementApiResponse(response))
        } catch (e: Exception) {
            Log.d(TAG, "getRandomPhoto: ${e.message}")
        }
    }

    private fun handleGetElementApiResponse(response: Response<BootstrapStaticCall>): Resource<BootstrapStaticCall>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                val elementList = resultResponse.fplPlayers
                val eventList = resultResponse.fplEvents
                for (element in elementList) {
                    upsertPlayer(element)
                }
                for (event in eventList) {
                    upsertEvent(event)
                }
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun upsertPlayer(fplPlayer: FplPlayer) = viewModelScope.launch {
        fplPlayerRepository.upsertFplPlayer(fplPlayer)
    }

    private fun upsertEvent(fplEvent: FplEvent) = viewModelScope.launch {
        fplEventRepository.upsertFplEvent(fplEvent)
    }

    fun getFullNameList(mInGamePlayerList: List<FplPlayer>): MutableList<String> {
        val fullNameList = mutableListOf<String>()
        for (player in mInGamePlayerList) {
            val playerFullName = player.firstName + " " + player.secondName
            fullNameList.add(playerFullName)
        }
        return fullNameList
    }
}