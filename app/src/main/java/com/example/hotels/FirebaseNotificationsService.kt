package com.example.hotels

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.Date

class FirebaseNotificationsService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val resultIntent = Intent(this, MainActivity::class.java)
//        val nextIntent = Intent(this, SecondActivity::class.java)

        resultIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        val taskStackBuilder : TaskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addParentStack(MainActivity::class.java)
        taskStackBuilder.addNextIntent(resultIntent)
//        taskStackBuilder.addNextIntent(nextIntent)

        var requestCode = 1905
        val pendingIntent : PendingIntent = taskStackBuilder.getPendingIntent(requestCode, PendingIntent.FLAG_IMMUTABLE)

        val channelId = "messages"
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notification)
            .setContentText("Notification Title")
            .setContentTitle("Notification Content")
            .setAutoCancel(false)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                "Messages",
                NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val id = Date().time.toInt()
        notificationManager.notify(id, notificationBuilder.build())
    }




}