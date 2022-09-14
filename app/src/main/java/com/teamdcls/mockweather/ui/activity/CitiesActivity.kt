package com.teamdcls.mockweather.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamdcls.mockweather.R
import com.teamdcls.mockweather.adapter.CitiesAdapter
import com.teamdcls.mockweather.databinding.ActivityCitiesBinding
import com.teamdcls.mockweather.model.CityDatabase
import com.teamdcls.mockweather.viewmodel.CitiesVM
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CitiesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCitiesBinding
    private lateinit var adapter: CitiesAdapter
    private val vm: CitiesVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = "Cities"
        }

        binding.addCities.setOnClickListener {
            val intent = Intent(this,AddCitiesActivity::class.java)
            startActivity(intent)
        }
        adapter = CitiesAdapter()
        binding.rcvCity.adapter = adapter
        lifecycleScope.launch {
            vm.citi.collect {
                adapter.submitData(it)
            }
        }
        vm.cities.observe(this) {
            adapter.submitData(it)
        }
        binding.rcvCity.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.addCities.setOnClickListener {
            startActivity(Intent(this, SearchCityActivity::class.java))
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> true.also { finish() }
            else -> super.onOptionsItemSelected(item)
        }
    }

}