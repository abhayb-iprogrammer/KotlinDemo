package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SearchViewCompat.setOnQueryTextListener
import android.R.attr.data
import android.widget.ArrayAdapter
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_search_view.*


class SearchViewActivity : AppCompatActivity(),SearchView.OnQueryTextListener {
    var adapter: ArrayAdapter<String>? = null

    val data = arrayOf("Abhay", "Akshay", "Ankit", "Anuradha", "Amreen", "Abhishek", "Arvind", "Amit", "Bharat", "Bhaskar", "Chaitanya", "Chitra", "Darshan", "Darsheel", "Deven", "Faizal", "Fayyaz", "Ganesh", "Girish", "Heena", "Hemant", "Irfan", "Jack", "Jeel", "John", "Kaushik", "Kapil", "Keshav", "Manish", "Mayuri", "Manali", "Nikita", "Pramod", "Pratik", "Puja", "Ravi", "Raj", "Reshma")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        listview.setAdapter(adapter)
        searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        val text = newText
        adapter!!.getFilter().filter(newText)
        //Toast.makeText(this,"Query is "+ text,Toast.LENGTH_SHORT).show();
        return false
    }
}


