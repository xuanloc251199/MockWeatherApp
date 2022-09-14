package com.teamdcls.mockweather.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teamdcls.mockweather.databinding.ActivityAddCitiesBinding

class AddCitiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}