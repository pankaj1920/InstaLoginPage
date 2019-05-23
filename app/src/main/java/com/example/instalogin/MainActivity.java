package com.example.instalogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webView = (WebView)findViewById(R.id.web_view);
        webView.loadUrl("file:///android_asset/facebook.html");
        webView.getSettings().setJavaScriptEnabled(true);
        setTitle("FAcebook");
    }

}
