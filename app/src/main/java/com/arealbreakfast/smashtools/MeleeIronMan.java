package com.arealbreakfast.smashtools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Random;


public class MeleeIronMan extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meleeironman);

        mAdView = (AdView) findViewById(R.id.adView_3);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("4A51EAF0C631CA74D07FC7762D27FCD0").build();
        mAdView.loadAd(adRequest);


        final TextView numplayer = (TextView) findViewById(R.id.mimnumber_play);
        final TextView numchar = (TextView) findViewById(R.id.mimnumber_char);
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
        TextView players = (TextView) findViewById(R.id.mimnumber_play);
        //pick characters randomly and display in Results activity
        TextView num = (TextView) findViewById(R.id.mimnumber_char);
        int x = Integer.parseInt(num.getText().toString());
        int y = Integer.parseInt(players.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;

        while (chosen_chars.size() < x * y) {
            //pick a new character
            ranNum = randomGenerator.nextInt(26);
            chosen_chars.add(ranNum);
        }


        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(players.getText().toString()));
        intent.putExtra("type", 1);
        startActivity(intent);
    }

    public void ManualEnter(View view) {
        Intent intent = new Intent(this, ManualEnter.class);
        intent.putExtra("type", 1); //legend in results.java
        ArrayList<Integer> allCharacters = new ArrayList<>(0);
        intent.putIntegerArrayListExtra("allCharacters", allCharacters);
        intent.putExtra("numPlayers", 0);
        startActivity(intent);
    }


}
