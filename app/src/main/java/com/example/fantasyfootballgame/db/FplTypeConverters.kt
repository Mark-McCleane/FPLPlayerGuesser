package com.example.fantasyfootballgame.db

import androidx.room.TypeConverter
import com.example.fantasyfootballgame.model.BoostrapStatic.ChipPlay
import com.example.fantasyfootballgame.model.BoostrapStatic.TopElementInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FplTypeConverters {

    @TypeConverter
    fun fromChipPlayList(chipPlayList: List<ChipPlay>): String {
        val gson = Gson()
        return gson.toJson(chipPlayList)
    }

    @TypeConverter
    fun toChipPlayList(chipPlayListString: String): List<ChipPlay> {
        val gson = Gson()
        val type = object : TypeToken<List<ChipPlay>>() {}.type
        return gson.fromJson(chipPlayListString, type)
    }

    @TypeConverter
    fun fromTopElementInfo(topElementInfo: TopElementInfo?): String {
        val gson = Gson()
        return gson.toJson(topElementInfo)
    }

    @TypeConverter
    fun toTopElementInfo(topElementInfoString: String?): TopElementInfo? {

        val gson = Gson()
        val type = object : TypeToken<TopElementInfo>() {}.type
        return gson.fromJson(topElementInfoString, type)
    }

}
