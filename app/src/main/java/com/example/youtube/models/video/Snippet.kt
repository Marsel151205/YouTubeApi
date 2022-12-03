package com.example.youtube.models.video

import com.google.gson.annotations.SerializedName

data class Snippet(
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("statistics")
    val statistics: Statistics
)

data class Thumbnails(
    @SerializedName("maxres")
    val maxRes: MaxRes
)

data class MaxRes(
    @SerializedName("url")
    val url: String
)

data class Statistics(
    @SerializedName("viewCount")
    val viewCount: String
)
