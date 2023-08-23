package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class GameSettings(
    @SerializedName("cup_qualifying_method")
    val cupQualifyingMethod: Any?,
    @SerializedName("cup_start_event_id")
    val cupStartEventId: Long?,
    @SerializedName("cup_stop_event_id")
    val cupStopEventId: Long?,
    @SerializedName("cup_type")
    val cupType: Long?,
    @SerializedName("league_h2h_tiebreak_stats")
    val leagueH2hTiebreakStats: List<String>,
    @SerializedName("league_join_private_max")
    val leagueJoinPrivateMax: Int,
    @SerializedName("league_join_public_max")
    val leagueJoinPublicMax: Int,
    @SerializedName("league_ko_first_instead_of_random")
    val leagueKoFirstInsteadOfRandom: Boolean,
    @SerializedName("league_max_ko_rounds_private_h2h")
    val leagueMaxKoRoundsPrivateH2h: Int,
    @SerializedName("league_max_size_private_h2h")
    val leagueMaxSizePrivateH2h: Int,
    @SerializedName("league_max_size_public_classic")
    val leagueMaxSizePublicClassic: Int,
    @SerializedName("league_max_size_public_h2h")
    val leagueMaxSizePublicH2h: Int,
    @SerializedName("league_points_h2h_draw")
    val leaguePointsH2hDraw: Int,
    @SerializedName("league_points_h2h_lose")
    val leaguePointsH2hLose: Int,
    @SerializedName("league_points_h2h_win")
    val leaguePointsH2hWin: Int,
    @SerializedName("league_prefix_public")
    val leaguePrefixPublic: String,
    @SerializedName("squad_squadplay")
    val squadSquadplay: Int,
    @SerializedName("squad_squadsize")
    val squadSquadsize: Int,
    @SerializedName("squad_team_limit")
    val squadTeamLimit: Int,
    @SerializedName("squad_total_spend")
    val squadTotalSpend: Int,
    @SerializedName("stats_form_days")
    val statsFormDays: Int,
    @SerializedName("sys_vice_captain_enabled")
    val sysViceCaptainEnabled: Boolean,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("transfers_cap")
    val transfersCap: Int,
    @SerializedName("transfers_sell_on_fee")
    val transfersSellOnFee: Double,
    @SerializedName("ui_currency_multiplier")
    val uiCurrencyMultiplier: Int,
    @SerializedName("ui_special_shirt_exclusions")
    val uiSpecialShirtExclusions: List<Any?>,
    @SerializedName("ui_use_special_shirts")
    val uiUseSpecialShirts: Boolean
)