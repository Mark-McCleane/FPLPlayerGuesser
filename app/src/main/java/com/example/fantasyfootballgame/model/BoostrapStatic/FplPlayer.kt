package com.example.fantasyfootballgame.model.BoostrapStatic


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fpl_players")
data class FplPlayer(
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("bonus")
    val bonus: Int,
    @SerializedName("bps")
    val bps: Int,
    @SerializedName("chance_of_playing_next_round")
    val chanceOfPlayingNextRound: Int,
    @SerializedName("chance_of_playing_this_round")
    val chanceOfPlayingThisRound: Int,
    @SerializedName("clean_sheets")
    val cleanSheets: Int,
    @SerializedName("clean_sheets_per_90")
    val cleanSheetsPer90: Double,
    @SerializedName("code")
    val code: Int,
    @SerializedName("corners_and_indirect_freekicks_order")
    val cornersAndIndirectFreekicksOrder: Int,
    @SerializedName("corners_and_indirect_freekicks_text")
    val cornersAndIndirectFreekicksText: String,
    @SerializedName("cost_change_event")
    val costChangeEvent: Int,
    @SerializedName("cost_change_event_fall")
    val costChangeEventFall: Int,
    @SerializedName("cost_change_start")
    val costChangeStart: Int,
    @SerializedName("cost_change_start_fall")
    val costChangeStartFall: Int,
    @SerializedName("creativity")
    val creativity: String,
    @SerializedName("creativity_rank")
    val creativityRank: Int,
    @SerializedName("creativity_rank_type")
    val creativityRankType: Int,
    @SerializedName("direct_freekicks_order")
    val directFreekicksOrder: Int,
    @SerializedName("direct_freekicks_text")
    val directFreekicksText: String,
    @SerializedName("dreamteam_count")
    val dreamteamCount: Int,
    @SerializedName("element_type")
    val elementType: Int,
    @SerializedName("ep_next")
    val epNext: String,
    @SerializedName("ep_this")
    val epThis: String,
    @SerializedName("event_points")
    val eventPoints: Int,
    @SerializedName("expected_assists")
    val expectedAssists: String,
    @SerializedName("expected_assists_per_90")
    val expectedAssistsPer90: Double,
    @SerializedName("expected_goal_involvements")
    val expectedGoalInvolvements: String,
    @SerializedName("expected_goal_involvements_per_90")
    val expectedGoalInvolvementsPer90: Double,
    @SerializedName("expected_goals")
    val expectedGoals: String,
    @SerializedName("expected_goals_conceded")
    val expectedGoalsConceded: String,
    @SerializedName("expected_goals_conceded_per_90")
    val expectedGoalsConcededPer90: Double,
    @SerializedName("expected_goals_per_90")
    val expectedGoalsPer90: Double,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("form")
    val form: String,
    @SerializedName("form_rank")
    val formRank: Int,
    @SerializedName("form_rank_type")
    val formRankType: Int,
    @SerializedName("goals_conceded")
    val goalsConceded: Int,
    @SerializedName("goals_conceded_per_90")
    val goalsConcededPer90: Double,
    @SerializedName("goals_scored")
    val goalsScored: Int,
    @SerializedName("ict_index")
    val ictIndex: String,
    @SerializedName("ict_index_rank")
    val ictIndexRank: Int,
    @SerializedName("ict_index_rank_type")
    val ictIndexRankType: Int,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("in_dreamteam")
    val inDreamteam: Boolean,
    @SerializedName("influence")
    val influence: String,
    @SerializedName("influence_rank")
    val influenceRank: Int,
    @SerializedName("influence_rank_type")
    val influenceRankType: Int,
    @SerializedName("minutes")
    val minutes: Int,
    @SerializedName("news")
    val news: String?,
    @SerializedName("news_added")
    val newsAdded: String?,
    @SerializedName("now_cost")
    val nowCost: Int,
    @SerializedName("now_cost_rank")
    val nowCostRank: Int,
    @SerializedName("now_cost_rank_type")
    val nowCostRankType: Int,
    @SerializedName("own_goals")
    val ownGoals: Int,
    @SerializedName("penalties_missed")
    val penaltiesMissed: Int,
    @SerializedName("penalties_order")
    val penaltiesOrder: Int,
    @SerializedName("penalties_saved")
    val penaltiesSaved: Int,
    @SerializedName("penalties_text")
    val penaltiesText: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("points_per_game")
    val pointsPerGame: String,
    @SerializedName("points_per_game_rank")
    val pointsPerGameRank: Int,
    @SerializedName("points_per_game_rank_type")
    val pointsPerGameRankType: Int,
    @SerializedName("red_cards")
    val redCards: Int,
    @SerializedName("saves")
    val saves: Int,
    @SerializedName("saves_per_90")
    val savesPer90: Double,
    @SerializedName("second_name")
    val secondName: String,
    @SerializedName("selected_by_percent")
    val selectedByPercent: String,
    @SerializedName("selected_rank")
    val selectedRank: Int,
    @SerializedName("selected_rank_type")
    val selectedRankType: Int,
    @SerializedName("special")
    val special: Boolean,
    @SerializedName("squad_number")
    val squadNumber: Int,
    @SerializedName("starts")
    val starts: Int,
    @SerializedName("starts_per_90")
    val startsPer90: Double,
    @SerializedName("status")
    val status: String,
    @SerializedName("team")
    val team: Int,
    @SerializedName("team_code")
    val teamCode: Int,
    @SerializedName("threat")
    val threat: String,
    @SerializedName("threat_rank")
    val threatRank: Int,
    @SerializedName("threat_rank_type")
    val threatRankType: Int,
    @SerializedName("total_points")
    val totalPoints: Int,
    @SerializedName("transfers_in")
    val transfersIn: Int,
    @SerializedName("transfers_in_event")
    val transfersInEvent: Int,
    @SerializedName("transfers_out")
    val transfersOut: Int,
    @SerializedName("transfers_out_event")
    val transfersOutEvent: Int,
    @SerializedName("value_form")
    val valueForm: String,
    @SerializedName("value_season")
    val valueSeason: String,
    @SerializedName("web_name")
    val webName: String,
    @SerializedName("yellow_cards")
    val yellowCards: Int,
)