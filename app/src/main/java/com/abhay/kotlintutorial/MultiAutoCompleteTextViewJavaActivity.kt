package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MultiAutoCompleteTextView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_multi_auto_complete_text_view_java.*



class MultiAutoCompleteTextViewJavaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_auto_complete_text_view_java)

        val texts = arrayOf("Abhay", "Akshay", "Arjun", "Ankit", "Anuradha", "Amreen", "Abhishek",
                "Arvind", "Amit", "Bharat", "Bhaskar", "Chaitanya",
                "Chitra", "Darshan", "Darsheel", "Deven", "Faizal", "Fayyaz",
                "Ganesh", "Girish", "Heena", "Hemant", "Irfan", "Jack", "Jeel",
                "John", "Kaushik", "Kapil", "Keshav", "Manish", "Mayuri", "Manali",
                "Nikita", "Pramod", "Pratik", "Puja", "Ravi", "Raj", "Reshma")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, texts)
        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}
