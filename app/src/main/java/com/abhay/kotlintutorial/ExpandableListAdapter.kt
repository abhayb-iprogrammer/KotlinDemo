package com.abhay.kotlintutorial

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.abhay.kotlintutorial.R

/**
 * Created by abhay on 15/1/18.
 */
class ExpandableListAdapter(val context:Context,val listofHeaderData:List<String>,val listofChildData: HashMap<String,List<String  >>) :BaseExpandableListAdapter(){
    override fun getGroup(postion: Int): Any {
        return listofHeaderData[postion]
    }

    override fun isChildSelectable(headerPostion: Int, childPostion: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
       return false
        }

    override fun getGroupView(groupPostion: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {




        var view = convertView
        val headerTitle=getGroup(groupPostion) as String

            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = layoutInflater.inflate(R.layout.list_header,parent, false)

        val listHeaderText=view.findViewById<TextView>(R.id.list_header_text) as TextView
        listHeaderText.setTypeface(null,Typeface.BOLD)
        listHeaderText.text=headerTitle
        return view
    }

    override fun getChildrenCount(groupPostion: Int): Int {
        return listofChildData[listofHeaderData[groupPostion]]!!.size
    }

    override fun getChild(groupPostion: Int, childPostion: Int): Any {
   return listofChildData[listofHeaderData[groupPostion]]!![childPostion]
    }

    override fun getGroupId(groupPostion: Int): Long {

        return groupPostion.toLong()
    }

    override fun getChildView(groupPostion: Int, childPostion: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        val childTitle=getChild(groupPostion,childPostion ) as String

        val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = layoutInflater.inflate(R.layout.list_item,parent, false)

        val listHeaderText=view.findViewById<TextView>(R.id.list_item_text) as TextView
        listHeaderText.setTypeface(null,Typeface.BOLD)
        listHeaderText.text=childTitle
        return view
    }

    override fun getChildId(groupPostion: Int, childPostion: Int): Long {
   return childPostion.toLong()
    }

    override fun getGroupCount(): Int {
        return listofHeaderData.size
    }

}

