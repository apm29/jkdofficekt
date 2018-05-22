package com.shirly.apm29.jkdofficekt.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.shirly.apm29.jkdofficekt.R
import kotlinx.android.synthetic.main.new_page.*


class NewPage : AppCompatActivity() {

    private val name = "Interface"
    private var length = 2
    private val url = "https://open.shujumohe.com/box/yys?box_token=5627AD0B44524FA2968713C29CD71833"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_page)


        web_view.settings.javaScriptEnabled = true
        web_view.settings.domStorageEnabled = true
        web_view.addJavascriptInterface(object : Any() {
            @JavascriptInterface
            fun processContent(aContent: String) {
                //Toast.makeText(this@NewPage, aContent, Toast.LENGTH_SHORT).show()
            }

            @JavascriptInterface
            fun calculateLength(str: String?) {
                length = str?.toInt() ?: 2
            }
        }, name)
        web_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                println("pageFinished")
                println("NewPage.onPageFinished")

            }


            override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                super.doUpdateVisitedHistory(view, url, isReload)
                println("NewPage.doUpdateVisitedHistory")
                //hideBottomText()
            }


            override fun onLoadResource(view: WebView?, url: String?) {
                println("NewPage.onLoadResource")
                super.onLoadResource(view, url)
                hideBottomText()
            }


        }
        web_view.webChromeClient = object : WebChromeClient() {
            override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
                println("NewPage.onReceivedIcon")
                super.onReceivedIcon(view, icon)
                //hideBottomText()
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                println("NewPage.onProgressChanged")
            }

        }
        web_view.loadUrl(url)
    }

    private fun hideBottomText() {
        println("NewPage:" + web_view.url)
        web_view?.loadUrl(
                "javascript:window.$name.calculateLength(" +
                        "document.querySelectorAll('.bottom p').length" +
                        ");"
        )
        println(length)
        for (i in 0..length + 2) {
            web_view?.loadUrl(
                    "javascript:window.$name.processContent(" +
                            "document.querySelectorAll('.bottom p')[$i].innerText=''" +
                            ");"
            )
        }
        web_view?.loadUrl(
                "javascript:window.$name.processContent(" +
                        "document.querySelectorAll('.bottomHelp p')[0].innerText=''" +
                        ");"
        )
    }
}