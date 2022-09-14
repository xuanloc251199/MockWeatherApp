package com.teamdcls.mockweather.worker


import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.text.HtmlCompat
import com.teamdcls.mockweather.MainActivity
import com.teamdcls.mockweather.R

class Notification {
    companion object {
        val text = HtmlCompat.fromHtml(
            """32°C<br>Da Nang<br><i>Update time: 15p</i>
      """.trimMargin(),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        fun Context.createNotification() = NotificationCompat.Builder(this, "current_weather")
            .setSmallIcon(R.drawable.ic_detail_pcpn)
            .setContentTitle("Weather")
            .setContentText("Current Weather")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setStyle(NotificationCompat.BigTextStyle().bigText(text))
            .setContentIntent(
                PendingIntent.getActivity(
                    this,
                    0,
                    Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    },
                    0
                )
            ).setAutoCancel(true)
        fun Context.showNotification() = NotificationManagerCompat
            .from(this).notify(404, createNotification().build())

        fun Context.cancelNotification() =
            (getSystemService(Application.NOTIFICATION_SERVICE) as NotificationManager)
                .cancel(404)
    }
}