package com.teamdcls.mockweather.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.teamdcls.mockweather.R
import com.teamdcls.mockweather.databinding.FragmentCurrentBinding

class CurrentFragment : Fragment() {

    private lateinit var binding: FragmentCurrentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCurrentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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