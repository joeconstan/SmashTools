package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Random;

public class BrawlIronMan extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brawl_iron_man);

        mAdView = (AdView) findViewById(R.id.adView_5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView numplayer = (TextView) findViewById(R.id.bimnumber_play);
        final TextView numchar = (TextView) findViewById(R.id.bimnumber_char);
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
        TextView players = (TextView) findViewById(R.id.bimnumber_play);
        //pick characters randomly and display in Results activity
        TextView num = (TextView) findViewById(R.id.bimnumber_char);
        int x = Integer.parseInt(num.getText().toString());
        int y = Integer.parseInt(players.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;

        while (chosen_chars.size() < x * y) {
            //pick a new character
            ranNum = randomGenerator.nextInt(40);
            if (!chosen_chars.contains(ranNum))
                chosen_chars.add(ranNum);
        }


        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(players.getText().toString()));
        intent.putExtra("type", 3);
        startActivity(intent);
    }
}
