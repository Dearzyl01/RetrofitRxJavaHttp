package com.tqkj.retrofitrxjavahttp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tqkj.retrofitrxjavahttp.R;

/**
 * 一个基于原生webview的浏览器。原生的要是 用在大项目会有些问题，一般接第三方，比如腾讯的那个lbs。但是现在安卓的sdk都到31了。不知道改善了没有
 */
public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = this.findViewById(R.id.webView);
        initWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        String url = getIntent().getStringExtra("webUrl");
        //调用了setJavaScriptEnabled()方法让WebView支持JavaScript脚本。
        webView.getSettings().setJavaScriptEnabled(true);
        // 这段代码保证了在网页跳转中仍然让内容出现在我们的WebView控件中，而不是打开系统的浏览器
        webView.setWebViewClient(new WebViewClient());
        //使用chrome浏览器客户端
        webView.setWebChromeClient(new WebChromeClient());
        //加载url展示页面
        webView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.stopLoading();
            webView.removeAllViews();
            webView.setWebViewClient(null);
            webView.setWebChromeClient(null);
            webView.destroy();
        }
        super.onDestroy();
    }
}