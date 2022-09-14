package com.teamdcls.mockweather.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.teamdcls.mockweather.databinding.FragmentTemperatureMapBinding


class TemperatureMapFragment : Fragment() {

    private var _binding: FragmentTemperatureMapBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTemperatureMapBinding.inflate(inflater, container, false)

        binding.temperatureMap.run {
            settings.run {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
            }
            loadUrl("https://www.windy.com/-Temperature-temp?temp,16.564,107.408,9")
            // loadUrl("file:///android_asset/wind_map.html?lat=30}&lon=-20&k=2.0&appid=${getString(R.string.app_id)}")
            setInitialScale(1)
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url!!)
                    return true
                }

            }

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}