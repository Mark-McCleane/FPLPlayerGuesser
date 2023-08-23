package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class TopElementInfo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("points")
    val points: Int
)