package com.example.fragmentexample2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RatingFragment extends Fragment {

    private View view;
    private RatingBar ratingBar;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rating, container, false);
        ratingBar = view.findViewById(R.id.ratingBar);
        textView = view.findViewById(R.id.textView);

        if (getArguments().getString("name")!= null){
            textView.setText("Rate " + getArguments().getString("name"));
        } else if (getArguments().getString("type")!= null) {
            textView.setText("Rate " + getArguments().getString("type"));
        }

        IRatingFragmentActivity activity = (IRatingFragmentActivity) getActivity();

        // set rating bar onchecked
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // call the set rating method with the parameter
                activity.setRating(String.valueOf(ratingBar.getRating()));
                /*
                String myRating = ("Your rating for " + getArguments().getString("name") + " is " +
                        String.valueOf(ratingBar.getRating()));
                Toast.makeText(getContext(), myRating,
                        Toast.LENGTH_SHORT).show();
                activity.textView_rating.setText("Rating: " + String.valueOf(ratingBar.getRating()) + "/5");*/
            }
        });

        return view;
    }
}