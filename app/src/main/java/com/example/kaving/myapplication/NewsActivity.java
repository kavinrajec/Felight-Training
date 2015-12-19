package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by KavinG on 10/20/2015.
 */
public class NewsActivity extends AppCompatActivity {
    public static final String NEWS_TYPE = "news_type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);
    }

    public  void getNews(View v){
        Intent newsIntent = new Intent(getBaseContext(),NewsReadActivity.class);
        switch (v.getId()){
            case R.id.btnGoogle:
                newsIntent.putExtra(NEWS_TYPE,"https://news.google.co.in/");
                startActivity(newsIntent);
                break;

            case R.id.btnAppleNews:
                newsIntent.putExtra(NEWS_TYPE,"http://www.apple.com/news/");
                startActivity(newsIntent);
                break;

            case R.id.btnFelight:
                newsIntent.putExtra(NEWS_TYPE,"http://www.felight.com/");
                startActivity(newsIntent);
                break;
        }
    }
}
