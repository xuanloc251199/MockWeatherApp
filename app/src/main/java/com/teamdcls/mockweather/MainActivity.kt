package com.teamdcls.mockweather

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.preference.PreferenceManager
import com.teamdcls.mockweather.ui.activity.MapActivity
import com.teamdcls.mockweather.databinding.ActivityMainBinding
import com.teamdcls.mockweather.ui.activity.CitiesActivity
import com.teamdcls.mockweather.ui.activity.SettingsActivity
import com.teamdcls.mockweather.ui.fragment.CurrentFragment
import com.teamdcls.mockweather.worker.Notification.Companion.showNotification

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var flagRun = false
    override fun onCreate(savedInstanceState: Bundle?) {

        if (!flagRun) {
            changTheme()
            flagRun = true
        }

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.run {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_playlist_add_white_24dp)
        }
//        val adapter = PageViewAdapter(this)
//        val page = binding.pageView
//        page.adapter = adapter
//        val tab = binding.tabLayout
//        TabLayoutMediator(tab, page) { _, _ ->
//            run {
//
//            }
//        }

        val currentFragment = CurrentFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.frmContainerView, currentFragment)
        }

        channelNotification()
        showNotification()
    }

    private fun changTheme() {
        val theme: Boolean = PreferenceManager.getDefaultSharedPreferences(this)
            .getBoolean(getString(R.string.key_dark_theme), false)
        if (!theme) setTheme(R.style.AppTheme_LightTheme_NoActionBar)
        else setTheme(R.style.AppTheme_DarkTheme_NoActionBar)
        Log.d("theme_resume", theme.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_nav, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true.also {
                startActivity(
                    Intent(
                        this@MainActivity,
                        SettingsActivity::class.java
                    )
                )
            }
            R.id.action_map -> true.also {
                startActivity(
                    Intent(
                        this@MainActivity,
                        MapActivity::class.java
                    )
                )
            }
            android.R.id.home -> true.also {
                startActivity(
                    Intent(
                        this@MainActivity,
                        CitiesActivity::class.java
                    )
                )
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRestart() {
        super.onRestart()
        changTheme()
    }
    private fun showNotification() {
        val isShow: Boolean = PreferenceManager.getDefaultSharedPreferences(applicationContext)
            .getBoolean(getString(R.string.key_show_notification), false)
        Log.d("??", isShow.toString())
        if (isShow) {
            applicationContext.showNotification()

        }
    }
    private fun channelNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getSystemService(NotificationManager::class.java)
                .createNotificationChannel(
                    NotificationChannel(
                        "current_weather",
                        "Current Weather",
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                )
        }
    }
}