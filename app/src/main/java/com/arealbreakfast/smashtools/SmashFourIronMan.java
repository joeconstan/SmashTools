package com.arealbreakfast.smashtools;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SmashFourIronMan extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smashfourironman);

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
        TextView numplayer = (TextView) findViewById(R.id.s4imnumber_play);
        //pick characters randomly and display in Results activity
        TextView numchar = (TextView) findViewById(R.id.s4imnumber_char);
        int x = Integer.parseInt(numchar.getText().toString());
        int y = Integer.parseInt(numplayer.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;

        while (chosen_chars.size() < x * y) {
            //pick a new character
            ranNum = randomGenerator.nextInt(56);
            if (!chosen_chars.contains(ranNum))
                chosen_chars.add(ranNum);
        }
        //need to remove duplicates as well by adding to hash set and then if its smaller than before, add another ad infitum until its correct size.


        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(numplayer.getText().toString()));
        intent.putExtra("type", 0);

        startActivity(intent);
    }

}
