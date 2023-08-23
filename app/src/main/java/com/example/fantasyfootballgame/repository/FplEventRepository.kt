package com.example.fantasyfootballgame.repository

import com.example.fantasyfootballgame.db.FplDatabase
import com.example.fantasyfootballgame.model.BoostrapStatic.FplEvent

class FplEventRepository(private val db: FplDatabase) {
    suspend fun upsertFplEvent(fplEvent: FplEvent) = db.getFplEventDao().upsertPlayer(fplEvent)

    fun getFplEventsFromRoom() = db.getFplEventDao().getAllFplEvents()
}