package com.example.quarantine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    internal val TIME_OUT = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
                {
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                },TIME_OUT.toLong())
    }
}
