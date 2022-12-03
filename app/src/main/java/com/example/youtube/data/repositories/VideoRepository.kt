package com.example.youtube.data.repositories

import com.example.youtube.base.BaseRepository
import com.example.youtube.data.remote.apiservices.VideosApiService
import javax.inject.Inject

class VideoRepository @Inject constructor(private val service: VideosApiService) : BaseRepository() {

    fun fetchVideos(part: String, chart: String?) = doRequest {
        service.fetchVideos(part, chart)
    }
}