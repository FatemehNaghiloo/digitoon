package com.fatemeh.digitoon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "film")

data class SearchItem(
    @SerializedName("Type")
    val type: String = "",

    @SerializedName("Year")
    val year: String = "",

    @PrimaryKey(autoGenerate = false)
    @SerializedName("imdbID")
    val imdbID: String = "",

    @SerializedName("Poster")
    val poster: String = "",

    @SerializedName("Title")
    val title: String = ""

)