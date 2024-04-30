package com.example.laboratoriopersonal.ui.browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.laboratoriopersonal.databinding.FragmentBrowserBinding

class BrowserFragment : Fragment() {

    private var _binding: FragmentBrowserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowserBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configuración del WebView
        binding.webview.loadUrl("https://www.eltiempo.com/")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
