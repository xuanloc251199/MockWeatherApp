package com.teamdcls.mockweather.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.teamdcls.mockweather.ui.fragment.CurrentFragment
import com.teamdcls.mockweather.ui.fragment.DailyWeatherFragment

class PageViewAdapter(fa:FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CurrentFragment()
            1 -> DailyWeatherFragment()
            else -> CurrentFragment()
        }
    }
}