package com.mystats.trafficdevilstest.browser;

import android.os.Bundle;
import android.webkit.WebBackForwardList;

import moxy.InjectViewState;
import moxy.MvpPresenter;
@InjectViewState
class PresenterWebView extends MvpPresenter<WebViewView> {
    Boolean wasInitial = false;
    public void initialWebView(){
        if (wasInitial==false){
            getViewState().initialWebView();
        } else{
            getViewState().restoreWebView();
        }

    }


}
