package com.example.broadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class CustomBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {


        val randomvalue = intent?.getIntExtra("random", 0)

        Toast.makeText(context, "EVENT TRIGERED $randomvalue", Toast.LENGTH_SHORT).show()



    }
}