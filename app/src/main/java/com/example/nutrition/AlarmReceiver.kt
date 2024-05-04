package com.example.nutrition

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //you can perform
        // Show a toast indicating the alarm trigger
        Toast.makeText(context, "Alarm Triggered!", Toast.LENGTH_SHORT).show()

        // You can perform any other action here, such as starting a service or displaying a notification
    }
}
