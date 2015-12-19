package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by KavinG on 10/20/2015.
 */
public class NewsReadActivity extends Activity {
    TextView tvNews;
    WebView wvResult;
    String ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_ead_layout);
        wvResult = (WebView)findViewById(R.id.webView);
        tvNews = (TextView)findViewById(R.id.tvNews);
        Intent intent = getIntent();
        ss = intent.getStringExtra(NewsActivity.NEWS_TYPE);
        tvNews.setText(ss);
        wvResult.loadUrl(ss);
        wvResult.setWebViewClient(new WebViewClient());
    }

}
