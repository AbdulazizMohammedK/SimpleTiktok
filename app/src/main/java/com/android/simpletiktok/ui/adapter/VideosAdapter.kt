package com.android.simpletiktok.ui.adapter

import android.content.Intent
import android.content.Intent.*
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.android.simpletiktok.R
import com.android.simpletiktok.data.model.ItemData
import com.android.simpletiktok.databinding.ItemVideoBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.*
import kotlinx.coroutines.withContext
import kotlin.math.ln
import kotlin.math.pow

class VideosAdapter(private var videosItems: ArrayList<ItemData>) :
    RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {
    override fun getItemCount(): Int = videosItems.size

    inner class VideosViewHolder(val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(newItems: ArrayList<ItemData>) {
        videosItems = newItems
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        val videoItem = videosItems[position]
        holder.binding.apply {
            video.setVideoPath(videoItem.itemInfos.video.urls[0])
            video.setOnPreparedListener {
                holder.binding.loadingProgressBar.visibility = View.GONE
                titleVideo.text = videoItem.itemInfos.text
                countShare.text = getFormattedNumber(videoItem.itemInfos.shareCount)
                countLikes.text = getFormattedNumber(videoItem.authorStats.heartCount.toInt())
                Glide.with(holder.itemView).load(videoItem.authorInfos.covers[0]).into(profileImage)
                shareButton.setOnClickListener {
                    //TODO add logic of share
                }
                likeButton.setOnClickListener {
                    likeButton.setImageResource(R.drawable.ic_baseline_favorite_24_red)
                }
                it.start()
                val videoRatio = it.videoWidth / it.videoHeight.toFloat()
                val screenRatio = holder.binding.video.width / holder.binding.video.height.toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    holder.binding.video.scaleX = scale
                } else {
                    holder.binding.video.scaleY = 1f / scale
                }
            }
            video.setOnCompletionListener {
                it.start()
            }
        }
    }
    private fun getFormattedNumber(count: Int): String {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }
}