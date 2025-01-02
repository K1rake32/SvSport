package com.example.svsport.ui.app.Application

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.svsport.ui.app.Notification.NOTIFICATION_CHANNEL_ID
import com.example.svsport.ui.app.Notification.NOTIFICATION_CHANNEL_NAME

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        // Проверка версии Android для создания канала уведомлений
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "my_channel_id"
        const val NOTIFICATION_CHANNEL_NAME = "My Notification Channel"
    }
}