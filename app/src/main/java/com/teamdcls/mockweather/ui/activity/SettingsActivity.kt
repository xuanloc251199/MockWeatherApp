package com.teamdcls.mockweather.ui.activity

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.viewModels
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.teamdcls.mockweather.R
import com.teamdcls.mockweather.databinding.ActivitySettingsBinding
import com.teamdcls.mockweather.viewmodel.SettingsVM
import com.teamdcls.mockweather.worker.Notification.Companion.cancelNotification
import com.teamdcls.mockweather.worker.Notification.Companion.showNotification

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private val vm: SettingsVM by viewModels()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = "Settings"
        }
        vm.darkTheme.observe(this) {
            if (it) setTheme(R.style.AppTheme_DarkTheme)
            else setTheme(R.style.AppTheme_LightTheme)
        }
        vm.showNotification.observe(this)
        {
            if (it && !isNotificationVisible()) applicationContext.showNotification()
            else if (!it && isNotificationVisible()) applicationContext.cancelNotification()
        }
        setContentView(binding.root)
        setContentView(binding.root)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> true.also { finish() }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class SettingsFragment : PreferenceFragmentCompat(), Preference.OnPreferenceChangeListener {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            findPreference<Preference>(getString(R.string.key_dark_theme))!!.onPreferenceChangeListener =
                this
            findPreference<Preference>(getString(R.string.key_pressure_unit))!!.onPreferenceChangeListener =
                this
            findPreference<Preference>(getString(R.string.key_speed_unit))!!.onPreferenceChangeListener =
                this
            findPreference<Preference>(getString(R.string.key_auto_update))!!.onPreferenceChangeListener =
                this
            findPreference<Preference>(getString(R.string.key_sound_notification))!!.onPreferenceChangeListener =
                this
            findPreference<Preference>(getString(R.string.key_show_notification))!!.onPreferenceChangeListener =
                this
            findPreference<Preference>(getString(R.string.key_temperature_unit))!!.onPreferenceChangeListener =
                this
        }

        @RequiresApi(Build.VERSION_CODES.N)
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        }

        override fun onPreferenceChange(preference: Preference, newValue: Any?): Boolean {
            return when {
                preference.key == getString(R.string.key_dark_theme) && newValue is Boolean -> true.also {
                    if (newValue == true)
                        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                    else AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                }
                preference.key == getString(R.string.key_show_notification) && newValue is Boolean -> true.also {
                    if (newValue == false)
                        requireContext().cancelNotification()
                    else requireContext().showNotification()
                }
                else -> true

            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNotificationVisible(): Boolean {
        val notifications =
            (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .activeNotifications
        for (notification in notifications) {
            if (notification.id == 404) return true
        }
        return false
    }
}