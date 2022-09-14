package com.teamdcls.mockweather.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.teamdcls.mockweather.model.current.DailyForecasts
import com.teamdcls.mockweather.R
import com.teamdcls.mockweather.databinding.FragmentCurrentBinding
import com.teamdcls.mockweather.model.current.CurrentWeather
import com.teamdcls.mockweather.model.current.Temperature
import com.teamdcls.mockweather.viewmodel.CurrentVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentFragment : Fragment() {

    private lateinit var binding: FragmentCurrentBinding
    private val viewModel: CurrentVM by viewModels()
    var TAG = "Current Fragment"
    private var items = arrayListOf<DailyForecasts>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherResponse.observe(viewLifecycleOwner) {
            binding.apply {
//
//                textTemperature.text = it.DailyForecasts.toString()
                val dailyForecasts = it.DailyForecasts[0]
                textMainWeather.text = dailyForecasts.Day?.IconPhrase
                textLastUpdate.text = it.Headline?.EffectiveDate.toString()
                val temperature = it.DailyForecasts[0].Temperature?.Maximum
                textTemperature.text = "${temperature?.Value} ${temperature?.Unit}"
                imageIcon.setImageResource(R.drawable.weather_icon_10d)
                textWind.text = dailyForecasts.Day?.Wind?.Speed.toString()
                textRain.text = "${dailyForecasts.Day?.Rain?.Value} ${dailyForecasts.Day?.Rain?.Unit}"
                textHumidity.text = dailyForecasts.Day?.TotalLiquid?.Value.toString()
                textSnow.text = "${dailyForecasts.Day?.Snow?.Value} ${dailyForecasts.Day?.Snow?.Unit}"
            }
        }

        binding.apply {
            cvFiveDaysForecasts.setOnClickListener {
                val activity = it.context as AppCompatActivity
                val dailyWeatherFragment = DailyWeatherFragment()
                activity.supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.frmContainerView, dailyWeatherFragment)
                }
            }
        }
    }


}