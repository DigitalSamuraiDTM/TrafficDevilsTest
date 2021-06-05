package com.mystats.trafficdevilstest.browser;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;

import com.mystats.trafficdevilstest.R;

import org.jetbrains.annotations.NotNull;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class FragmentWebView extends MvpAppCompatFragment implements WebViewView {
    public WebView webView;

    @InjectPresenter()
    PresenterWebView presenterWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(@NonNull @NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        webView = (WebView) view.findViewById(R.id.webView_view);
        presenterWebView.initialWebView();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }


    @Override
    public void restoreWebView() {
            webView.getSettings().setJavaScriptEnabled(true);

    }
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initialWebView() {
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        webView.loadUrl("http://html5test.com/");
    }
}