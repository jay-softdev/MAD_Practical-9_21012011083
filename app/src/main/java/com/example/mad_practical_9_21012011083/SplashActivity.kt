package com.example.mad_practical_9_21012011083


import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {


        lateinit var logoanimation: AnimationDrawable

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash)

            val logo1: ImageView = findViewById(R.id.uvpce)

            logo1.setBackgroundResource(R.drawable.uvpce_animation_list)
            logoanimation = logo1.background as AnimationDrawable;

            val myAnimation = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
            logo1.startAnimation(myAnimation)

            // Add an animation listener to your animation
            myAnimation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    // Animation started
                }

                override fun onAnimationEnd(animation: Animation) {
                    // Animation ended, start a new activity here
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                }

                override fun onAnimationRepeat(animation: Animation) {
                    // Animation repeated
                }
            })
        }

        override fun onWindowFocusChanged(hasFocus: Boolean) {
            super.onWindowFocusChanged(hasFocus)
            if (hasFocus) {
                logoanimation.start()
            } else {
                logoanimation.stop()
            }
        }

    }
