package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class ChipPlay(
    @SerializedName("chip_name")
    val chipName: String,
    @SerializedName("num_played")
    val numPlayed: Int
)