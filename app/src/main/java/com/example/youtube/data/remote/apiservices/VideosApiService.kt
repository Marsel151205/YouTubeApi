package com.example.youtube.data.remote.apiservices

import com.example.youtube.models.YouTubeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideosApiService {

    @GET("videos")
    fun fetchVideos(
        @Query("part") part: String,
        @Query("chart") chart: String?
    ): Response<YouTubeResponse>
}