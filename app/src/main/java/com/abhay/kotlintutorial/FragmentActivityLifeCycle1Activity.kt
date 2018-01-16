package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class FragmentActivityLifeCycle1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_life_cycle1)
    }
}
