package com.example.aalborgforsyning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class test2 extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        CustomWebViewClient client = new CustomWebViewClient(this);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://aalborg.renoweb.dk/Legacy/selvbetjening/sorteringsguide.aspx");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

class CustomWebViewClient extends WebViewClient {
    private Activity activity;
    public CustomWebViewClient(Activity activity) {
        this.activity = activity;
    }

    //API < 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        // Links will not be loaded in external browser
        // return true will load external browsers only
        return false;
    }

    //API >= 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {
        return false;
    }
}