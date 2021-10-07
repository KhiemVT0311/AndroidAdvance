package com.eup.androidadvancedemo.ui;

import static com.eup.androidadvancedemo.ui.MainActivity.REQUEST_URL;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.eup.androidadvancedemo.R;

public class WatchNewsActivity extends AppCompatActivity {
    private String url;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        webView = findViewById(R.id.web_view);
        Intent intent = getIntent();
        url = intent.getStringExtra(REQUEST_URL);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }

}
