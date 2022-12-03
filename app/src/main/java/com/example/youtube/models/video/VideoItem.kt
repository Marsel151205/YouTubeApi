package com.example.youtube.models.video

import com.example.youtube.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class VideoItem(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    override val id: String,
    @SerializedName("snippet")
    val snippet: Snippet
) : IBaseDiffModel<String>
