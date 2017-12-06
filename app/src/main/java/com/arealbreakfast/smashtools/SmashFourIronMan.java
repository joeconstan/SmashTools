package com.arealbreakfast.smashtools;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SmashFourIronMan extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smashfourironman);


    }

    public void Exclude(View view) {
        Intent intent = new Intent(view.getContext(), Exclude.class);
        startActivity(intent);
    }

    public void Start(View view) {
        EditText players = (EditText) findViewById(R.id.s4imnumber_play);
        //pick characters randomly and display in Results activity
        EditText num = (EditText) findViewById(R.id.s4imnumber_char);
        int x = Integer.parseInt(num.getText().toString());
        int y = Integer.parseInt(players.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;

        while (chosen_chars.size() < x * y) {
            //pick a new character
            ranNum = randomGenerator.nextInt(56);
            if (!chosen_chars.contains(ranNum))
                chosen_chars.add(randomGenerator.nextInt(56));
        }
        //need to remove duplicates as well by adding to hash set and then if its smaller than before, add another ad infitum until its correct size.


        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(players.getText().toString()));
        intent.putExtra("type", 0);

        startActivity(intent);
    }

}
