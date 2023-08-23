package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("code")
    val code: Int,
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("form")
    val form: Double?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("loss")
    val loss: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("played")
    val played: Int,
    @SerializedName("points")
    val points: Int,
    @SerializedName("position")
    val position: Int,
    @SerializedName("pulse_id")
    val pulseId: Int,
    @SerializedName("short_name")
    val shortName: String,
    @SerializedName("strength")
    val strength: Int,
    @SerializedName("strength_attack_away")
    val strengthAttackAway: Int,
    @SerializedName("strength_attack_home")
    val strengthAttackHome: Int,
    @SerializedName("strength_defence_away")
    val strengthDefenceAway: Int,
    @SerializedName("strength_defence_home")
    val strengthDefenceHome: Int,
    @SerializedName("strength_overall_away")
    val strengthOverallAway: Int,
    @SerializedName("strength_overall_home")
    val strengthOverallHome: Int,
    @SerializedName("team_division")
    val teamDivision: Any?,
    @SerializedName("unavailable")
    val unavailable: Boolean,
    @SerializedName("win")
    val win: Int
)