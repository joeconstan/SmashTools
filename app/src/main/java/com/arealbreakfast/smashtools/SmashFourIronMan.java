package com.arealbreakfast.smashtools;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Random;

public class SmashFourIronMan extends AppCompatActivity {


    private AdView mAdView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smashfourironman);

        MobileAds.initialize(this, "ca-app-pub-4831792107942934~4522194056");

        mAdView = (AdView) findViewById(R.id.adView_2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        final TextView numplayer = (TextView) findViewById(R.id.s4imnumber_play);
        final TextView numchar = (TextView) findViewById(R.id.s4imnumber_char);
        ImageButton incplay = (ImageButton) findViewById(R.id.increase_play);
        ImageButton decplay = (ImageButton) findViewById(R.id.decrease_play);
        ImageButton incchar = (ImageButton) findViewById(R.id.increase_char);
        ImageButton decchar = (ImageButton) findViewById(R.id.decrease_char);

        incplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numplayer.getText().toString());
                n++;
                numplayer.setText(String.valueOf(n));
            }
        });

        decplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numplayer.getText().toString());
                n--;
                numplayer.setText(String.valueOf(n));
            }
        });

        incchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numchar.getText().toString());
                n++;
                numchar.setText(String.valueOf(n));
            }
        });

        decchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numchar.getText().toString());
                n--;
                numchar.setText(String.valueOf(n));
            }
        });

    }


    public void Start(View view) {
        CheckBox mii = (CheckBox) findViewById(R.id.miicheck);
        TextView numplayer = (TextView) findViewById(R.id.s4imnumber_play);
        //pick characters randomly and display in Results activity
        TextView numchar = (TextView) findViewById(R.id.s4imnumber_char);
        int x = Integer.parseInt(numchar.getText().toString());
        int y = Integer.parseInt(numplayer.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;
        if (mii.isChecked()) {
            while (chosen_chars.size() < x * y) {
                //pick a new character
                ranNum = randomGenerator.nextInt(58); //generates rand #'s 0-57
                chosen_chars.add(ranNum);
            }
        } else {
            while (chosen_chars.size() < x * y) {
                //pick a new character
                ranNum = randomGenerator.nextInt(55);
                chosen_chars.add(ranNum);
            }
        }


        Intent intent = new Intent(view.getContext(), Results.class);
        if (!mii.isChecked()) {
            intent.putExtra("mii", 0);
        }
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(numplayer.getText().toString()));
        intent.putExtra("type", 0);

        startActivity(intent);
    }

    public void ManualEnter(View view){
        Intent intent = new Intent(this, ManualEnter.class);
        intent.putExtra("type", 0); //legend in results.java
        startActivity(intent);
    }

}
