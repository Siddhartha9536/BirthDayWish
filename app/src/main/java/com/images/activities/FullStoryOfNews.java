package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.restaurant.birthdaywish.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FullStoryOfNews extends AppCompatActivity {


    @BindView(R.id.webview)
    WebView webView;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story_of_news);
        context = FullStoryOfNews.this;
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra("url");
        if(url!=null){
            webView.setWebViewClient(new MyWebViewClient());
            openURL(url.replace("http" , "https"));
        }



    }

    @Override
    protected void onResume() {
        super.onResume();
        Animatoo.animateZoom(context);
    }

    private void openURL(String url) {
        webView.loadUrl(url);
        webView.requestFocus();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @OnClick(R.id.back_icon)
    public void back(){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(context);
    }
}
