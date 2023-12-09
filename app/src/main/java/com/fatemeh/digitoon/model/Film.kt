package com.fatemeh.digitoon.model

import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("Response")
    val response: String = "",
    @SerializedName("totalResults")
    val totalResults: String = "",
    @SerializedName("Search")
    @TypeConverters(RoomConverter::class)
    val search: List<SearchItem>?
)