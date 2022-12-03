package com.example.youtube.models

import com.example.youtube.base.IBaseDiffModel
import com.example.youtube.models.video.VideoItem
import com.google.gson.annotations.SerializedName

data class YouTubeResponse(
    override val id: Int,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("items")
    val items: List<VideoItem>
) : IBaseDiffModel<Int>
