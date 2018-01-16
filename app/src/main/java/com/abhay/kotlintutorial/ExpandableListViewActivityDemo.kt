package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_expandable_list_view_demo.*
class ExpandableListViewActivityDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_list_view_demo)

        val listHeader  =listOf("Numbers","fruits")
        val numberlist= listOf("one","Two","Ten")
        val fruitslist= listOf("Apple","orange","Banana")

        val listchild= HashMap<String,List<String>>()
        listchild.put(listHeader[0],numberlist)
        listchild.put(listHeader[1],fruitslist)
        val expandableListAdapter= ExpandableListAdapter(this, listHeader, listchild)
        expandable_list_view.setAdapter(expandableListAdapter)

    }
}
