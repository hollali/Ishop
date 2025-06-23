package com.example.ishop

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.animation.AnimationUtils
import android.os.Handler

class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //*---making layout fullscreen--
        //*---hiding the title bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        //*--hiding the status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )
        //*--- Setting content view
        setContentView(R.layout.splash_activity)

        //*---Creating layout instance with animation---
        val backgroundImage : ImageView = findViewById(R.id.write)
        val backgroundLabel : TextView = findViewById(R.id.ipaper)

        //*-- Setting animation ---
        val sliderAnimation = AnimationUtils.loadAnimation(this, R.anim.slider)
        val sliderAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slider2)
        backgroundImage.startAnimation(sliderAnimation)
        backgroundLabel.startAnimation(sliderAnimation2)

        //!---Layout Navigation to Dashboard
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },3000)
    }
}