package com.example.fantasyfootballgame.model.BoostrapStatic


import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "fpl_event")
data class FplEvent(
    @SerializedName("average_entry_score")
    val averageEntryScore: Int,
    @SerializedName("chip_plays")
    val chipPlays: List<ChipPlay>,
    @SerializedName("cup_leagues_created")
    val cupLeaguesCreated: Boolean,
    @SerializedName("data_checked")
    val dataChecked: Boolean,
    @SerializedName("deadline_time")
    val deadlineTime: String,
    @SerializedName("deadline_time_epoch")
    val deadlineTimeEpoch: Int,
    @SerializedName("deadline_time_game_offset")
    val deadlineTimeGameOffset: Int,
    @SerializedName("finished")
    val finished: Boolean,
    @SerializedName("h2h_ko_matches_created")
    val h2hKoMatchesCreated: Boolean,
    @SerializedName("highest_score")
    val highestScore: Int,
    @SerializedName("highest_scoring_entry")
    val highestScoringEntry: Int,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("is_current")
    val isCurrent: Boolean,
    @SerializedName("is_next")
    val isNext: Boolean,
    @SerializedName("is_previous")
    val isPrevious: Boolean,
    @SerializedName("most_captained")
    val mostCaptained: Int,
    @SerializedName("most_selected")
    val mostSelected: Int,
    @SerializedName("most_transferred_in")
    val mostTransferredIn: Int,
    @SerializedName("most_vice_captained")
    val mostViceCaptained: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("top_element")
    val topElement: Int,
    @SerializedName("top_element_info")
    val topElementInfo: TopElementInfo?,
    @SerializedName("transfers_made")
    val transfersMade: Int
)