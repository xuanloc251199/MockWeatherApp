package com.teamdcls.mockweather.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.teamdcls.mockweather.R
import com.teamdcls.mockweather.databinding.ActivityCitiesBinding

class CitiesActivity : AppCompatActivity() {
   private lateinit var binding : ActivityCitiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = "Cities"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            android.R.id.home-> true.also { finish() }
            else->super.onOptionsItemSelected(item)
        }
    }

}