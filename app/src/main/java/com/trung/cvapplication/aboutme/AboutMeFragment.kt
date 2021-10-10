package com.trung.cvapplication.aboutme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.trung.cvapplication.R
import kotlinx.android.synthetic.main.fragment_about_me.*

class AboutMeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_me, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpWebView()
    }

    private fun setUpWebView() {
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.linkedin.com/in/moushumi-seal/")
        webView.settings.javaScriptEnabled = true
    }

    companion object {
        @JvmStatic
        fun newInstance() = AboutMeFragment()
    }
}