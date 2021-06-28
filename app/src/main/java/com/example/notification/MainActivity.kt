package com.example.notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

const val CUSTIOM_ACTION_INTENT_FILTER = "CUSTIOM_ACTION_INTENT_FILTER"
const val CHANNEL_ID = "custom_id"
const val NOTIFIY_ID = 47
const val CHANNEL_NAME = "custom_name"
lateinit var managerNotify: NotificationManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        managerNotify = getSystemService(NOTIFICATION_SERVICE) as NotificationManager


        val addBtn = findViewById<Button>(R.id.addNotif)
        val updateBtn = findViewById<Button>(R.id.updadeBTn)
        val cancelBtn = findViewById<Button>(R.id.cancelBtn)


        addBtn.setOnClickListener {
            addNotif()
        }

        cancelBtn.setOnClickListener {

            managerNotify.cancel(NOTIFIY_ID)
        }

        updateBtn.setOnClickListener {

            updateNotif()
        }


    }

    fun updateNotif() {

        val notificationTwo = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Notif Update")
            .setContentText(android.R.string.cancel.toString())
            .setSmallIcon(android.R.drawable.ic_media_pause)
            .build()

        managerNotify.notify(NOTIFIY_ID,notificationTwo)
    }

    fun addNotif() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            val notificationChannel =
                NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
                )



            managerNotify.createNotificationChannel(notificationChannel)

            notificationChannel.lightColor = (Color.RED)
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
        }

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            NOTIFIY_ID,
            intent,
            0
        )


        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("HelloWorld")
            .setContentText(android.R.string.cancel.toString())
            .setSmallIcon(android.R.drawable.ic_media_pause)
            .setContentIntent(pendingIntent)
            .build()


        managerNotify.notify(NOTIFIY_ID, notification)


    }

}