package com.example.kaving.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by KavinG on 10/30/2015.
 */
public class GoogleMapNewsRead extends AppCompatActivity {
    TextView tvNews;
    WebView wvResult;
    String ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.googlemap_news_read);
        wvResult = (WebView)findViewById(R.id.webView);
        tvNews = (TextView)findViewById(R.id.tvNews);
        Intent intent = getIntent();
        ss = intent.getStringExtra(MapsActivity.NEWS_TYPE);
        tvNews.setText(ss);
        wvResult.loadUrl(ss);
        wvResult.setWebViewClient(new WebViewClient());
    }
}
