package com.example.fantasyfootballgame.model.BoostrapStatic


import com.google.gson.annotations.SerializedName

data class ElementType(
    @SerializedName("element_count")
    val elementCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("plural_name")
    val pluralName: String,
    @SerializedName("plural_name_short")
    val pluralNameShort: String,
    @SerializedName("singular_name")
    val singularName: String,
    @SerializedName("singular_name_short")
    val singularNameShort: String,
    @SerializedName("squad_max_play")
    val squadMaxPlay: Int,
    @SerializedName("squad_min_play")
    val squadMinPlay: Int,
    @SerializedName("squad_select")
    val squadSelect: Int,
    @SerializedName("sub_positions_locked")
    val subPositionsLocked: List<Int>,
    @SerializedName("ui_shirt_specific")
    val uiShirtSpecific: Boolean
)