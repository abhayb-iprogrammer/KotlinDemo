package com.abhay.kotlintutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class FacebookIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_intent)
    }

   fun btnClick(v:View){
       try {
           val intent = Intent(Intent.ACTION_SEND)
           intent.setType("text/plain")
           val uriString = "https://play.google.com/store/apps/details?id=com.abhay.androidtutorial&hl=en";
           intent.putExtra(Intent.EXTRA_TEXT, uriString)
           intent.setPackage("com.facebook.katana")
           startActivity(intent)
       }catch (e:Exception)
       {
           Toast.makeText(getApplicationContext(),"Please Install the Facebook App",Toast.LENGTH_SHORT).show();
       }
   }
}
