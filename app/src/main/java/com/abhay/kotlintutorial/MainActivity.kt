package com.abhay.kotlintutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(v: View) {


        val intent = Intent(this, Main2Activity::class.java)
        //intent.putExtra(INTENT_USER_ID, user.id)
        startActivity(intent)


        //ButtonActivity
        //RadioButtonActivity
        //CheckBoxActivity
        //RatingBarActivity
        //ProgressBarActivity
        //SeekBarActivity
        //SwitchActivity
        //TogglebuttonActivity
        //SpinnerActivity
        //AutoCompleteTextViewJavaActivity
        //MultiAutoCompleteTextViewJavaActivity
        //ImageViewJavaActivity
        //ImageButtonActivity
        //VideoViewActivity
        //TextClockActivity
        //DatePickerActivity
        //TimePickerActivity
        //ChronometerActivity
        //EmailActivity
        //MapsActivity
        //PhoneCallActivity
        //PhoneDialActivity
        //CameraActivity
        //FacebookIntentActivity
        //TwitterIntentActivity
        //WhatsAppActivity
        //GooglePlusIntentActivity
        //SimpleToastActivity
        //ToastPositionActivity
        //CustomToastActivity
        //ListViewActivity
        //CustomListviewActivity
        //GridViewActivity
        //ExpandableListViewActivityDemo
        //WebviewActivity
        //SearchViewActivity
        //ContextMenuActivity
        //OptionMenuActivity
        //PopupMenuActivity
        //ActivityLifeCycleActivity
        //FragmentActivityLifeCycle1Activity
        //FragmentActivityLifeCycleCombinedActivity


        //ServiceLifeCycleAActivity
        //ServiceExampleAActivity
        //TelephonyManagerActivity
        //ReadContactsActivity
        //ReadSMSActivity
        //SendSMSActivity
        //WifiActivity
        //ChangeWifiActivity
        //AnimationTweenBounceActivity
        //AnimationTweenFadeActivity
        //AnimationTweenMoveActivity
        //AnimationTweenRotateActivity
        //AnimationTweenSequentialActivity
        //AnimationTweenSlideActivity
        //AnimationTweenZoomActivity
        //AnimTweenTogetherActivity
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
      //  Toast.makeText(this, "Button was Clicked", Toast.LENGTH_SHORT).show()
    }
}
