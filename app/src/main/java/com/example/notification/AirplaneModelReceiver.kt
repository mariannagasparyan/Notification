package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplaneModelReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnable=intent?.getBooleanExtra("state",false)

}}