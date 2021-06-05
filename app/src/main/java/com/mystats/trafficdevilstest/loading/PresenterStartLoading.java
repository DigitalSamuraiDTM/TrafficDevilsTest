package com.mystats.trafficdevilstest.loading;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
class PresenterStartLoading extends MvpPresenter<LoadingView> {
    SharedPreferences preferences;

    public void getAnswerFromFirebase(Integer stateShared){
        if (stateShared==0){ //browser
            getViewState().goToBrowser();
        } else if (stateShared==1){ //game
            getViewState().goToGame();
        } else {
            FirebaseFirestore.getInstance().collection("Data").document("TrueOrFalse").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    Boolean bool = documentSnapshot.getBoolean("TRUE_OR_FALSE");
                    if (bool) {
                        getViewState().saveState(0);
                        getViewState().goToBrowser();
                    } else {
                        getViewState().saveState(1);
                        getViewState().goToGame();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {

                }
            });
        }
    }
}
