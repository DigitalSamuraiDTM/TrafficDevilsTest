package com.mystats.trafficdevilstest.loading;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mystats.trafficdevilstest.R;

import org.jetbrains.annotations.NotNull;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;


public class FragmentStartLoading extends MvpAppCompatFragment implements LoadingView {
    @InjectPresenter
    PresenterStartLoading presenterStartLoading;


    public FragmentStartLoading() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_loading, container, false);
    }

    @Override
    public void onResume() {
        SharedPreferences p = getActivity().getSharedPreferences("TrafficDevilsTest",Context.MODE_PRIVATE);
        presenterStartLoading.getAnswerFromFirebase(p.getInt("T_OR_F",-1));
        super.onResume();
    }

    @Override
    public void goToBrowser() {
        Navigation.findNavController(requireActivity(),R.id.nav_host_fragment).navigate(R.id.action_fragmentStartLoading_to_fragmentWebView);
    }

    @Override
    public void goToGame() {
        Navigation.findNavController(requireActivity(),R.id.nav_host_fragment).navigate(R.id.action_fragmentStartLoading_to_fragmentGame);

    }

    @Override
    public void saveState(Integer state) {
        SharedPreferences p = getActivity().getSharedPreferences("TrafficDevilsTest",Context.MODE_PRIVATE);
        p.edit().putInt("T_OR_F",state).apply();
    }
}