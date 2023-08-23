package com.example.fantasyfootballgame.repository

import com.example.fantasyfootballgame.data.RetrofitInstance
import com.example.fantasyfootballgame.db.FplDatabase
import com.example.fantasyfootballgame.model.BoostrapStatic.FplPlayer

class FplPlayerRepository(private val db: FplDatabase) {

    suspend fun upsertFplPlayer(fplPlayer: FplPlayer) = db.getFplPlayerDao().upsertPlayer(fplPlayer)

    fun getFplPlayersFromRoom() = db.getFplPlayerDao().getAllElements()

    suspend fun getFplPlayersFromApi() = RetrofitInstance.api.getBootstrap()

}