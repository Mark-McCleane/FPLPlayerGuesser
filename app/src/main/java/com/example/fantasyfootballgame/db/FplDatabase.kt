package com.example.fantasyfootballgame.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fantasyfootballgame.model.BoostrapStatic.FplPlayer
import com.example.fantasyfootballgame.model.BoostrapStatic.FplEvent

@Database(entities = [FplPlayer::class, FplEvent::class], version = 1)
@TypeConverters(FplTypeConverters::class)
abstract class FplDatabase : RoomDatabase() {
    abstract fun getFplPlayerDao(): FplPlayerDao
    abstract fun getFplEventDao(): FplEventDao

    companion object {
        @Volatile
        private var instance: FplDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FplDatabase::class.java,
                "fpl_element_database.db"
            ).build()
    }
}