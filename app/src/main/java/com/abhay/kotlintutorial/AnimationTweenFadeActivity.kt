package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_animation_tween_fade.*

class AnimationTweenFadeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_tween_fade)
    }

    fun fadeIn(V:View)
    {
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.fadein)
        imageView.startAnimation(animation)
    }

    fun fedeOut(V:View)
    {
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.fadeout)
        imageView.startAnimation(animation)
    }
}
