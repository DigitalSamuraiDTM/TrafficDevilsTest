package com.mystats.trafficdevilstest.game;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mystats.trafficdevilstest.R;

import org.jetbrains.annotations.NotNull;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class FragmentGame extends MvpAppCompatFragment implements View.OnClickListener, GameView {

    @InjectPresenter()
    PresenterGame presenterGame;

    Button buttonRed;
    Button buttonGreen;
    TextView scoreView;
    Boolean green = true;
    Boolean greenButton = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
         buttonRed = view.findViewById(R.id.button_red);
         buttonRed.setOnClickListener(this);
         buttonGreen = view.findViewById(R.id.button_green);
         buttonGreen.setOnClickListener(this);
        scoreView = view.findViewById(R.id.score_textView);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_green:
                    presenterGame.greenClick();
                break;
            case R.id.button_red:
                    presenterGame.redClick();
                break;
        }
    }

    @Override
    public void setScores(int scores) {
        scoreView.setText(String.valueOf(scores));
    }

    @Override
    public void switchButtons() {
        if (greenButton){
            buttonGreen.setText("red");
            buttonRed.setText("green");
            greenButton = false;
        } else{
            buttonGreen.setText("green");
            buttonRed.setText("red");
            greenButton = true;
        }
    }

    @Override
    public void LoseGame() {
        buttonRed.setEnabled(false);
        buttonGreen.setEnabled(false);
        scoreView.setText("YOU LOSE");
    }

    @Override
    public void WinGame() {
        buttonRed.setEnabled(false);
        buttonGreen.setEnabled(false);
        scoreView.setText("YOU WIN");
    }

    @Override
    public void changeColor() {
        if (green){
            green = false;
            scoreView.setTextColor(Color.argb(255,255,0,0));
        } else{
            green = true;
            scoreView.setTextColor(Color.argb(255,0,255,0));

        }
    }
}