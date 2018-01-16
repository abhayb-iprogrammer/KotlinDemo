package com.abhay.kotlintutorial

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.synthetic.main.activity_custom_listview.*
import android.widget.ArrayAdapter
import android.widget.TextView
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.annotation.NonNull
import android.view.View

import kotlinx.android.synthetic.main.activity_custom_listview.view.*
import kotlinx.android.synthetic.main.activity_custom_listview_java.view.*


class CustomListviewActivity : AppCompatActivity() {
    var titles = arrayOf("Title1", "Title2", "Title3", "Title4", "Title5")
    var descriptions = arrayOf("Description1", "Description2", "Description3", "Description4", "Description5")
    var images = intArrayOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_listview)
        val adapter = MyAdapter(applicationContext, titles, descriptions, images)
        listView.setAdapter(adapter)
    }


}

 class MyAdapter(context: Context, var titleArray: Array<String>, var descArray: Array<String>, var imageArray: IntArray)//Overriding Default Constructor off ArratAdapter
    : ArrayAdapter<String>(context, R.layout.activity_custom_listview_java,R.id.myTitle, titleArray) {



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Inflating the layout
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = inflater.inflate(R.layout.activity_custom_listview_java, parent, false)

        //Providing the element of an array by specifying its position
        row.myImage.setImageResource(imageArray[position])

        row.myTitle.text = titleArray[position]
        row.myDescription.text = descArray[position]
        return row
    }
}
