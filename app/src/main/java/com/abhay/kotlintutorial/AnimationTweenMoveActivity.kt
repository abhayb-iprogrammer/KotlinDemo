package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_animation_tween_move.*

class AnimationTweenMoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_tween_move)
    }

    fun moveUp(V: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.move_top)
        imageView.startAnimation(animation)
    }

    fun moveDown(V: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.move_bottom)
        imageView.startAnimation(animation)
    }
    fun moveRight(V: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.move_right)
        imageView.startAnimation(animation)
    }

    fun moveLeft(V: View){
        val animation = AnimationUtils.loadAnimation(applicationContext,
                R.anim.move_left)
        imageView.startAnimation(animation)
    }
}
