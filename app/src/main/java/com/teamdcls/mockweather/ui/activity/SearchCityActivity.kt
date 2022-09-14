package com.teamdcls.mockweather.ui.activity

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.teamdcls.mockweather.adapter.RecyclerViewSearchCityAdapter
import com.teamdcls.mockweather.databinding.ActivitySearchCityBinding
import com.teamdcls.mockweather.model.Cities
import com.teamdcls.mockweather.model.CityDatabase
import com.teamdcls.mockweather.reponsitory.api.cityrepository.ApiState
import com.teamdcls.mockweather.reponsitory.api.cityrepository.CitiesRepository
import com.teamdcls.mockweather.viewmodel.city.CityVM
import com.teamdcls.mockweather.viewmodel.city.CityVMFactory


class SearchCityActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchCityBinding
    private lateinit var vm: CityVM
    private lateinit var adapter: RecyclerViewSearchCityAdapter

    private lateinit var locationRequest: LocationRequest

    // private var cities: ArrayList<Cities> = arrayListOf()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySearchCityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this, CityVMFactory(CitiesRepository(),this))[CityVM::class.java]
        onSearchChange()
        collects()
        adapter = RecyclerViewSearchCityAdapter()
        binding.rcvCitySearch.adapter = adapter
        binding.rcvCitySearch.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = "Search City"
        }
        binding.btnMyLocation.setOnClickListener {

            getLatLonDevice()
        }
        locationRequest = LocationRequest.create();
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 2000
        adapter.onClickItem = {
            val cityDatabase = CityDatabase(
                city_key = it.Key!!,
                name = it.EnglishName!!,
                region = it.Region?.EnglishName!!,
                country=it.Country?.EnglishName!!,
                timeZone=it.TimeZone?.Name!!,
                lat=it.GeoPosition?.Latitude!!,
                lon = it.GeoPosition?.Longitude!!
            )
            vm.insertCity(cityDatabase)
            finish()
        }
        setContentView(binding.root)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getLatLonDevice() {
        if (checkSelfPermission(ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(ACCESS_FINE_LOCATION), 1)
        }
//            AlertDialog.Builder(this)
//                .setMessage("Location is not enable")
//                .setPositiveButton(
//                    "Open Location"
//                ) { _, _ ->
//                    startActivity(
//                        Intent(android.provider.Settings.ACTION_SETTINGS)
//                    )
//                }
//                .setNegativeButton("Cancel", null)
//                .show()
        else {
            LocationServices.getFusedLocationProviderClient(this)
                .requestLocationUpdates(locationRequest, object : LocationCallback() {
                    override fun onLocationResult(p0: LocationResult) {
                        super.onLocationResult(p0)
                        LocationServices.getFusedLocationProviderClient(this@SearchCityActivity)
                            .removeLocationUpdates(this)

                        if (p0 != null && p0.locations.size > 0) {
                            val index: Int = p0.locations.size - 1
                            val latitude: Double =
                                p0.locations[index].latitude
                            val longitude: Double =
                                p0.locations[index].longitude
                            vm.searchCityByLatLon(latitude, longitude)
                        }
                    }
                }, Looper.getMainLooper())
        }

    }

    private fun onSearchChange() {
        binding.searchCity.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    vm.searchCity(s.toString())
                    Log.d("change", s.toString())
                }

            }
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> true.also { finish() }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun collects() {

        lifecycleScope.launchWhenCreated {
            vm.dataCities.collect {
                when (it) {
                    is ApiState.Loading -> {
                        Log.d("city", "loading")

                    }
                    is ApiState.Failure -> {

                        Log.d("city", "fail")
                        it.e.printStackTrace()
                    }
                    is ApiState.Success -> {

                        val myObj = it.data as ArrayList<Cities>
//                        cities.clear()
//                        cities = myObj
                        adapter.submitData(myObj)

                    }
                    is ApiState.Empty -> {
                        Log.d("city", "empty")
                    }
                }
            }
        }

    }

}