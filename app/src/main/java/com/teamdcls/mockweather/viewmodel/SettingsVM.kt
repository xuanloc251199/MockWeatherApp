package com.teamdcls.mockweather.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import com.teamdcls.mockweather.R

class SettingsVM(val app: Application) : AndroidViewModel(app) {
    val darkTheme: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().also {
            PreferenceManager.getDefaultSharedPreferences(app.applicationContext)
                .getBoolean(app.getString(R.string.key_dark_theme), false)
        }
    }
    val showNotification: MutableLiveData<Boolean> by lazy {
        (MutableLiveData<Boolean>().also {
            PreferenceManager.getDefaultSharedPreferences(app.applicationContext)
                .getBoolean(app.getString(R.string.key_show_notification), false)
        })
    }
}