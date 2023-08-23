package com.example.fantasyfootballgame.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fantasyfootballgame.model.BoostrapStatic.FplPlayer

@Dao
interface FplPlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertPlayer(fplPlayer: FplPlayer)


    @Query("Select * from fpl_players")
    fun getAllElements(): LiveData<List<FplPlayer>>
}
