package com.mystats.trafficdevilstest.game;

import java.util.Random;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
class PresenterGame extends MvpPresenter<GameView> {
    Boolean switched = false;
    Integer scores = 0;
    Boolean changeColor = false;

    public void greenClick() {
        if (switched != changeColor) {
            getViewState().LoseGame();
        } else {
            if (scores < 10) {
                scores++;
                getViewState().setScores(scores);
                Random random = new Random();
                int r = random.nextInt();
                if (r <= 15) {
                    getViewState().switchButtons();
                    if (!switched) {
                        switched = true;
                    } else {
                        switched = false;
                    }
                }
                r = random.nextInt();
                if (r >= 70) {
                    getViewState().changeColor();
                    if (changeColor) {
                        changeColor = false;
                    } else {
                        changeColor = true;
                    }
                }
            } else {
                getViewState().WinGame();
            }
        }
    }

    public void redClick() {
        if (switched == changeColor) {
            getViewState().LoseGame();
        } else {
            if (scores < 10) {
                scores++;
                getViewState().setScores(scores);
                Random random = new Random();
                int r = random.nextInt();
                if (r <= 15) {
                    getViewState().switchButtons();
                    if (!switched) {
                        switched = true;
                    } else {
                        switched = false;
                    }
                }
                r = random.nextInt();
                if (r >= 70) {
                    getViewState().changeColor();
                    if (changeColor) {
                        changeColor = false;
                    } else {
                        changeColor = true;
                    }
                }
            } else{
                getViewState().WinGame();
            }
        }
    }
}
