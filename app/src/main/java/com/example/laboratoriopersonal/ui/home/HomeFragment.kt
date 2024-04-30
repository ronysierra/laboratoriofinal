package com.example.laboratoriopersonal.ui.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.laboratoriopersonal.R
import com.example.laboratoriopersonal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        videoView = binding.videoView
        val btnPlay = binding.btnPlay
        val btnPause = binding.btnPause
        val btnForward = binding.btnForward
        val btnBackward = binding.btnBackward

        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.my_video
        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        btnPlay.setOnClickListener {
            videoView.start()
        }

        btnPause.setOnClickListener {
            videoView.pause()
        }

        btnForward.setOnClickListener {
            videoView.seekTo(videoView.currentPosition + 10000) // Avanza 10 segundos
        }

        btnBackward.setOnClickListener {
            videoView.seekTo(videoView.currentPosition - 10000) // Retrocede 10 segundos
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
