package com.example.youtube.ui.fragments.videos

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentVideosBinding
import com.example.youtube.ui.adapters.VideosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment :
    BaseFragment<FragmentVideosBinding, VideosViewModel>(R.layout.fragment_videos) {

    override val binding by viewBinding(FragmentVideosBinding::bind)
    override val viewModel: VideosViewModel by viewModels()
    private val videosAdapter = VideosAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupRequest() {
        viewModel.fetchVideos("snippet,contentDetails,statistics", "mostPopular")
    }

    override fun setupSubscribe() {
        subscribeToVideosList()
    }

    private fun setupRecyclerView() {
        binding.rvVideos.adapter = videosAdapter
    }

    private fun subscribeToVideosList() {
        viewModel.videosList.subscribe(
            onSuccess = {
                videosAdapter.submitList(it.items)
            },
            onError = {
                Log.e("YouTube", it )
            }
        )
    }
}