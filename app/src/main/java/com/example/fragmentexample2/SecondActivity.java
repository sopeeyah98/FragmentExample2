package com.example.fragmentexample2;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity implements IRatingFragmentActivity{

    private Button button_rate_smug;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = new Bundle();
        bundle.putString("type", "Smug");
        RatingFragment ratingFragment = new RatingFragment();
        ratingFragment.setArguments(bundle);

        button_rate_smug = findViewById(R.id.button_smug);
        button_rate_smug.setOnClickListener(v -> loadFragment(ratingFragment));
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView_Second, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setRating(String rating) {
        Toast.makeText(this, "Ratings for Smug type is " + rating, Toast.LENGTH_SHORT).show();
    }
}