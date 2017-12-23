package com.arealbreakfast.smashtools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SixtyFourIronMan extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixtyfourironman);


        //MobileAds.initialize(this, "ca-app-pub-4831792107942934~4522194056");

        //mAdView = (AdView) findViewById(R.id.adView_2);
        // AdRequest adRequest = new AdRequest.Builder().addTestDevice("4A51EAF0C631CA74D07FC7762D27FCD0").build();
        //mAdView.loadAd(adRequest);


        final TextView numplayer = (TextView) findViewById(R.id.s4imnumber_play);
        final TextView numchar = (TextView) findViewById(R.id.s4imnumber_char);
        ImageButton incplay = (ImageButton) findViewById(R.id.increase_play);
        ImageButton decplay = (ImageButton) findViewById(R.id.decrease_play);
        ImageButton incchar = (ImageButton) findViewById(R.id.increase_char);
        ImageButton decchar = (ImageButton) findViewById(R.id.decrease_char);

        //check if they have set preferences, set them if so
        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int defaultValue = 100;
        int prefPlay = sharedPref.getInt("prefPlay", defaultValue);
        int prefChar = sharedPref.getInt("prefChar", defaultValue);
        if (prefPlay != defaultValue) {
            numplayer.setText(String.valueOf(prefPlay));
        }
        if (prefChar != defaultValue) {
            numchar.setText(String.valueOf(prefChar));
        }


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
        TextView numplayer = (TextView) findViewById(R.id.s4imnumber_play);
        //pick characters randomly and display in Results activity
        TextView numchar = (TextView) findViewById(R.id.s4imnumber_char);
        int x = Integer.parseInt(numchar.getText().toString());
        int y = Integer.parseInt(numplayer.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;
        while (chosen_chars.size() < x * y) { //todo: allow repeats if over max characters selected
            //pick a new characters
            ranNum = randomGenerator.nextInt(12); //generates rand #'s 0-12
            chosen_chars.add(ranNum);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = x, p = 1; i <= (x * y); i += x, p++) { //make sure no one person got the same character twice. turn each section into hash set. if not same size, add another element and check again.
            for (int j = i - x; j < x * p; j++) {
                set.add(chosen_chars.get(j));
            }
            while (set.size() < x) { //if the hashset is a different size, we had a duplicate, so add another
                ranNum = randomGenerator.nextInt(58);
                if (set.add(ranNum)) {//not clearing chosen chars
                    int counter = i - x; //replace the chosen_chars with our hash set, as the hash set is the same but with the duplicate randomly replaced
                    for (int h : set) {
                        chosen_chars.remove(counter);
                        chosen_chars.add(counter, h);
                        counter++;
                    }
                }
            }
            set.clear();
        }

        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(numplayer.getText().toString()));
        intent.putExtra("type", 4);

        startActivity(intent);
    }

    public void ManualEnter(View view) {
        Intent intent = new Intent(this, ManualEnter.class);
        intent.putExtra("type", 0); //legend in results.java
        ArrayList<Integer> allCharacters = new ArrayList<>(0);
        intent.putIntegerArrayListExtra("allCharacters", allCharacters);
        intent.putExtra("numPlayers", 0);
        startActivity(intent);
    }


}