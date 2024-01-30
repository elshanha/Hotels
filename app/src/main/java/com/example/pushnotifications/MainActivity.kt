package com.example.pushnotifications

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestNotifications()
    }

    val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                getToken()
            } else {

            }
        }

    private fun requestNotifications() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun getToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                println(task.result)
            }
        }
    }
 //   dpy80cmQSfGie_WJ4HbEVB:APA91bE-zLg8Yb579HRMRevTnpwARv_riDGwcgFJ6gDVuWRbFga2WZomOKS7fiaB_Eepj1zGTmK-J0XtuBFFdG1NiMZSH8FDeT1Txa8vPTwJYzmEiJ_39TnWNj2jwUNRJQOsTRQcn-gp

//    ePZGmUsNTHm13yNRBdVFSW:APA91bEa41Prg2BwoBfXj4PO-QCWEogJ8pkz1iXXlR9wHV6HIrH_m3GdUMe5uBeijy8_WW3q8tRHWMQ1OT9fZ6N1-Jl23oYT5A9TMOjcdE_Nj9h459JSu9kcuDRgxsBP4hI3FmN-GnV8
}