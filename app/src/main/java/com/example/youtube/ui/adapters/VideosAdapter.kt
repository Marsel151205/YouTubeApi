package com.example.youtube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.youtube.base.BaseDiffUtilItemCallback
import com.example.youtube.databinding.ItemVideoBinding
import com.example.youtube.models.YouTubeResponse
import com.example.youtube.models.video.VideoItem

class VideosAdapter : ListAdapter<VideoItem, VideosAdapter.VideosViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VideosViewHolder(
        ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }


    class VideosViewHolder(private val binding: ItemVideoBinding) : ViewHolder(binding.root) {
        fun onBind(model: VideoItem) {
            binding.ivThumbnails.load(model.snippet.thumbnails.maxRes)
            binding.tvTitle.text = model.snippet.title
            binding.tvViewCount.text = model.snippet.statistics.viewCount
            binding.tvPublishedAt.text = model.snippet.publishedAt

        }

    }
}