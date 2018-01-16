package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_anim_tween_together.*

class AnimTweenTogetherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_tween_together)

    }

    fun togrther(v:View)
    {
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.together)
        imageView.startAnimation(animation)
    }
}
