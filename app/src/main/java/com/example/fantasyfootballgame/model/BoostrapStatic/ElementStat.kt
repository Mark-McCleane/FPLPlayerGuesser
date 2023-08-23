package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class ElementStat(
    @SerializedName("label")
    val label: String,
    @SerializedName("name")
    val name: String
)