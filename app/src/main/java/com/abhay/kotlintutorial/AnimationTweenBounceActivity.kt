package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_animation_tween_bounce.*
import android.view.animation.AnimationUtils
import android.view.animation.Animation



class AnimationTweenBounceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_tween_bounce)
    }

    fun btnBounce(V:View)
    {
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.bounce)
        imageView.startAnimation(animation)
    }
}
