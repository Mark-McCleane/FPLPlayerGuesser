package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class Phase(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("start_event")
    val startEvent: Int,
    @SerializedName("stop_event")
    val stopEvent: Int
)