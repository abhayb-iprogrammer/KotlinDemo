package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_animation_tween_rotate.*

class AnimationTweenRotateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_tween_rotate)
    }

    fun rotateClock(v:View)
    {
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.rotate_clockwise)
        imageView.startAnimation(animation)
    }

    fun rotateAntiClock(v:View)
    {
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.rotate_anticlockwise)
        imageView.startAnimation(animation)
    }
}
