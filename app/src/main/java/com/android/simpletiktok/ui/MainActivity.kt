package com.android.simpletiktok.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.android.simpletiktok.data.State
import com.android.simpletiktok.data.model.ItemData
import com.android.simpletiktok.data.model.Tiktok
import com.android.simpletiktok.data.request.ApiClient
import com.android.simpletiktok.databinding.ActivityMainBinding
import com.android.simpletiktok.ui.adapter.VideosAdapter
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.ln
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val apiClient by lazy { ApiClient() }
    private lateinit var adapter: VideosAdapter
    private var itemsVideo = ArrayList<ItemData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter = VideosAdapter(itemsVideo)
        lifecycleScope.launch(Dispatchers.IO) {
            flowCrypto().collect {
                when (it) {
                    is State.Fail -> {
                        Toast.makeText(this@MainActivity, "Can't play the video", Toast.LENGTH_LONG)
                            .show()
                    }
                    is State.Success -> {
                        adapter.setData(it.data.body.itemListData)
                        Log.i("Loading",it.data.body.itemListData[0].authorInfos.covers.toString())
                    }
                    is State.Loading -> {

                    }
                }
            }
            withContext(Dispatchers.Main) {
                binding.viewPagerVideos.adapter = adapter
            }
        }
    }


    private fun flowCrypto(): Flow<State<Tiktok>> = flow {
        emit(State.Loading)
        emit(getVideosList())
    }

    private fun getVideosList(): State<Tiktok> {
        val response = apiClient.makeApiRequest().execute()
        return if (response.isSuccessful) {
            Gson().fromJson(response.body?.string(), Tiktok::class.java).run {
                State.Success(this)
            }
        } else {
            State.Fail(response.message)
        }
    }
}
