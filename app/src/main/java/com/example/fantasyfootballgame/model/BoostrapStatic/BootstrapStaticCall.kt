package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class BootstrapStaticCall(
    @SerializedName("element_stats")
    val elementStats: List<ElementStat>,
    @SerializedName("element_types")
    val elementTypes: List<ElementType>,
    @SerializedName("elements")
    val fplPlayers: List<FplPlayer>,
    @SerializedName("events")
    val fplEvents: List<FplEvent>,
    @SerializedName("game_settings")
    val gameSettings: GameSettings,
    @SerializedName("phases")
    val phases: List<Phase>,
    @SerializedName("teams")
    val teams: List<Team>,
    @SerializedName("total_players")
    val totalPlayers: Int
)