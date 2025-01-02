package com.example.svsport.ui.app.Notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.svsport.MainActivity
import com.example.svsport.R

const val NOTIFICATION_CHANNEL_ID = "ch_1"
const val NOTIFICATION_CHANNEL_NAME = "Test Not"
const val NOTIFICATION_ID = 100
const val REQUEST_CODE = 200
class NotificationService(

    private val context: Context

) {

    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private val myIntent = Intent(context, MainActivity::class.java)
    private val pendingIntent = PendingIntent.getActivity(

        context,
        REQUEST_CODE,
        myIntent,
        PendingIntent.FLAG_IMMUTABLE

    )

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                NOTIFICATION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for test notifications"
            }
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

    fun showNotification() {

        val notification =
            NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.progress_profile)
                .setContentTitle("Hello")
                .setContentText("Drink more water!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()

        notificationManager.notify(NOTIFICATION_ID, notification)
    }

}

