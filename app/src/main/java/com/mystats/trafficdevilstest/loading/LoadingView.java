package com.mystats.trafficdevilstest.loading;

import com.google.android.material.circularreveal.CircularRevealHelper;

import moxy.MvpView;
import moxy.locators.StrategyLocator;
import moxy.viewstate.strategy.StateStrategyType;
import moxy.viewstate.strategy.alias.AddToEnd;
import moxy.viewstate.strategy.alias.Skip;

public interface LoadingView extends MvpView {
    @Skip
    void goToBrowser();
    @Skip
    void goToGame();

    @Skip
    void saveState(Integer state);

}
