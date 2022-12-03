package com.example.youtube.ui.fragments.videos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.youtube.base.BaseViewModel
import com.example.youtube.common.Resource
import com.example.youtube.data.repositories.VideoRepository
import com.example.youtube.models.YouTubeResponse
import com.example.youtube.models.video.VideoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(private val repository: VideoRepository) :
    BaseViewModel() {

    private val videosAddList = MutableLiveData<Resource<YouTubeResponse>>()
    val videosList: LiveData<Resource<YouTubeResponse>> = videosAddList

    fun fetchVideos(part: String, chart: String?) {
        viewModelScope.launch {
            repository.fetchVideos(part, chart).collect {
                when(it) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        videosAddList.postValue(it)
                    }
                    null -> {}
                }
            }
        }
    }
}