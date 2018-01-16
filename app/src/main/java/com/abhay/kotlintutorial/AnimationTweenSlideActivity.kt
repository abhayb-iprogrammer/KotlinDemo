package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_animation_tween_slide.*

class AnimationTweenSlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_tween_slide)
    }

    fun SlideDown(v: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.slide_bottom)
        imageView.startAnimation(animation)
    }

    fun SlideUp(v: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.slide_top)
        imageView.startAnimation(animation)
    }
    fun SlideRight(v: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.slide_right)
        imageView.startAnimation(animation)
    }
    fun SlideLeft(v: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.slide_left)
        imageView.startAnimation(animation)
    }
}
