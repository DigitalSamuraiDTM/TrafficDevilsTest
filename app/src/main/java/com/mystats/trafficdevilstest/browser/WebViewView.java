package com.mystats.trafficdevilstest.browser;

import android.os.Bundle;
import android.webkit.WebBackForwardList;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEnd;
import moxy.viewstate.strategy.alias.AddToEndSingle;
import moxy.viewstate.strategy.alias.SingleState;
import moxy.viewstate.strategy.alias.Skip;

public interface WebViewView extends MvpView {
    @SingleState
    void restoreWebView();
    @SingleState
    void initialWebView();
}
