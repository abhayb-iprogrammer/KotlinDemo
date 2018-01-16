package com.abhay.kotlintutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_webview.*


class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

    }

    fun btnclick(v: View)
    {
        val s = editTxt.getText().toString()
        webview.webViewClient = WebViewClient()
        webview.loadUrl(s)
    }
}
