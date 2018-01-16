package com.abhay.kotlintutorial

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import trikita.anvil.DSL.activity




class Main2Activity : AppCompatActivity() {

    var newclass: Class<*>? = null










    //InternalStorageActivity
    //ExternalStoragePublicDirectoryActivity
    //ExternalStorageActivity
    //CacheStorageActivity
    //SQLiteInsertActivity
    //SQLiteReadActivity
    //SQLiteUpdateActivity
    //SQLiteDeleteActivity
    //NotificationActivity
    //NotificationInboxActivity
    //NotificationBigTextActivity
    //NotificationBigPictureActivity




    var charactersDC = arrayOf("ButtonActivity","RadioButtonActivity","CheckBoxActivity","RatingBarActivity",
            "ProgressBarActivity","SeekBarActivity","SwitchActivity","TogglebuttonActivity",
            "SpinnerActivity","AutoCompleteTextViewJavaActivity","MultiAutoCompleteTextViewJavaActivity",
            "ImageViewJavaActivity","ImageButtonActivity","VideoViewActivity","TextClockActivity",
            "DatePickerActivity","TimePickerActivity","ChronometerActivity","EmailActivity","MapsActivity",
            "PhoneCallActivity","PhoneDialActivity","CameraActivity","FacebookIntentActivity",
    "TwitterIntentActivity","WhatsAppActivity","GooglePlusIntentActivity",
    "SimpleToastActivity","ToastPositionActivity","CustomToastActivity",
    "ListViewActivity","CustomListviewActivity","GridViewActivity","ExpandableListViewActivityDemo",
    "WebviewActivity","SearchViewActivity","ContextMenuActivity",
    "OptionMenuActivity","PopupMenuActivity","ActivityLifeCycleActivity",
    "FragmentActivityLifeCycle1Activity","FragmentActivityLifeCycleCombinedActivity",

    "ServiceLifeCycleAActivity","ServiceExampleAActivity","TelephonyManagerActivity",
    "ReadContactsActivity","ReadSMSActivity","SendSMSActivity","WifiActivity","ChangeWifiActivity",

    "AnimationTweenBounceActivity","AnimationTweenFadeActivity","AnimationTweenMoveActivity",
    "AnimationTweenRotateActivity","AnimationTweenSequentialActivity","AnimationTweenSlideActivity",
    "AnimTweenTogetherActivity","InternalStorageActivity","ExternalStoragePublicDirectoryActivity",
    "ExternalStorageActivity","CacheStorageActivity","SQLiteInsertActivity","SQLiteReadActivity",
    "SQLiteUpdateActivity","SQLiteDeleteActivity","NotificationActivity","NotificationInboxActivity",
    "NotificationBigTextActivity","NotificationBigPictureActivity"

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, charactersDC)
        listView.setAdapter(adapter)
        //Setting onClickListener on ListView
        listView?.setOnItemClickListener { parent, view, position, id ->




            try {
                var className=this.packageName.toString()+"."+charactersDC[position]
                newclass = Class.forName(className)
            } catch (c: ClassNotFoundException) {
                c.printStackTrace()
            }

            val previousIntent: Intent
            val nextIntent: Intent
            if (newclass != null) {
                nextIntent = Intent(this, newclass)
                startActivity(nextIntent)
            } else {
                Toast.makeText(applicationContext, "new class null", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
