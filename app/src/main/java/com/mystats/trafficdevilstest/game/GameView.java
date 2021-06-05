package com.mystats.trafficdevilstest.game;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;
import moxy.viewstate.strategy.alias.SingleState;
import moxy.viewstate.strategy.alias.Skip;

interface GameView  extends MvpView {
    @AddToEndSingle
    void setScores(int scores);
    @AddToEndSingle
    void switchButtons();
    @SingleState
    void LoseGame();
    @SingleState
    void WinGame();
    @SingleState
    void changeColor();
}
