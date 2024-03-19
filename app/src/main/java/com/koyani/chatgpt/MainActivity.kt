package com.koyani.chatgpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import androidx.webkit.WebViewClientCompat
import android.webkit.CookieManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webview)

        supportActionBar?.hide()

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);



        webView.settings.userAgentString =
            "Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Mobile Safari/537.36"

        webView.webViewClient = object : WebViewClientCompat() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://chat.openai.com/chat")
    }
}
