package com.teamdcls.mockweather.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.teamdcls.mockweather.databinding.FragmentWaveMapBinding


class WaveMapFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentWaveMapBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWaveMapBinding.inflate(inflater, container, false)
        binding.windMap.run {
            settings.run {
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true
            }
            loadUrl("https://www.windy.com/-Waves-waves?waves,16.543,107.417,10,m:d6KajbD")
            //loadUrl("file:///android_asset/wind_map.html?lat=30}&lon=0&k=2.0&appid=${getString(R.string.app_id)}")
            setInitialScale(1)
            webViewClient = object : WebViewClient() {
                @Deprecated("Deprecated in Java")
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url!!)
                    return true
                }

            }

        }
        //binding.windMap.loadUrl("javascript:map.removeLayer(rainLayer);map.removeLayer(tempLayer);map.addLayer(windLayer);" )
        return binding.root
    }


}