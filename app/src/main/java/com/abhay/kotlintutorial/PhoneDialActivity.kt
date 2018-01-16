package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_phone_call.*

class PhoneDialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_dial)
    }

    fun btnCall(v:View){

    val i=Intent(Intent.ACTION_DIAL)
    var sNum=Numtxt.text
    if(sNum.trim().isEmpty())
    {
       Toast.makeText(this,"Please Enter Phone Number",Toast.LENGTH_SHORT).show()
    }else{
        i.data=Uri.parse("tel:"+sNum);
        startActivity(i)
    }
}

}
