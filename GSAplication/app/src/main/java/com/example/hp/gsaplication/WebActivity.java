package com.example.hp.gsaplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class WebActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView wvsite = (WebView) findViewById(R.id.webViewSite);

        WebSettings wssite = wvsite.getSettings();
        wvsite.setWebViewClient(new WebViewClient());
        wssite.getJavaScriptEnabled();
        wssite.setSupportZoom(false);

        wvsite.loadUrl("http://gstroca.gamesesistemas.com.br");
    }

}
