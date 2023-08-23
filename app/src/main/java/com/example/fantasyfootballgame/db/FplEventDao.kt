package com.example.fantasyfootballgame.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fantasyfootballgame.model.BoostrapStatic.FplEvent

@Dao
interface FplEventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPlayer(fplEvent: FplEvent)


    @Query("Select * from fpl_event")
    fun getAllFplEvents(): LiveData<List<FplEvent>>
}