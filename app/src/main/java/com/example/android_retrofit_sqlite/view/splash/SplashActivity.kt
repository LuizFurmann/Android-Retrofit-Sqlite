package com.example.android_retrofit_sqlite.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.android_retrofit_sqlite.R
import com.example.android_retrofit_sqlite.databinding.ActivitySplashBinding
import com.example.android_retrofit_sqlite.view.home.MainActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this@SplashActivity, MainActivity::class.java).also{
                startActivity(it)
            }
            finish()
        }, 3000)
    }
}