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

    fun convertPositionIdToFplPosition(randomElement: FplPlayer?): String {
        return randomElement?.elementType?.let {
            when (it) {
                1 -> "GK"
                2 -> "DEF"
                3 -> "MID"
                4 -> "ATT"
                else -> "INVALID"
            }
        } ?: "INVALID"
    }

    fun convertTeamIdToFplTeam(mRandomElement: FplPlayer?): String {
        return mRandomElement?.team?.let {
            when (it) {
                1 -> "Arsenal"
                2 -> "Aston Villa FC"
                3 -> "Bournemouth AFC"
                4 -> "Brentford"
                5 -> "Brighton & Hove Albion"
                6 -> "Burnley FC"
                7 -> "Chelsea FC"
                8 -> "Crystal Palace FC"
                9 -> "Everton FC"
                10 -> "Fulham FC"
                11 -> "Liverpool FC"
                12 -> "Luton Town FC"
                13 -> "Manchester City FC"
                14 -> "Manchester United FC"
                15 -> "Newcastle United FC"
                16 -> "Nottingham Forest FC"
                17 -> "Sheffield United FC"
                18 -> "Tottenham Hotspur FC"
                19 -> "West Ham United FC"
                20 -> "Wolverhampton Wanderers"
                else -> {
                    "Invalid"
                }
            }
        } ?: "Invalid"
    }
}