package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ProjectMIronMan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_miron_man);
    }


    public void Start(View view) {
        TextView players = (TextView) findViewById(R.id.pmimnumber_play);
        //pick characters randomly and display in Results activity
        TextView num = (TextView) findViewById(R.id.mimnumber_char);
        int x = Integer.parseInt(num.getText().toString());
        int y = Integer.parseInt(players.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        int ranNum;

        while (chosen_chars.size() < x * y) {
            //pick a new character
            ranNum = randomGenerator.nextInt(25);
            if (!chosen_chars.contains(ranNum))
                chosen_chars.add(ranNum);
        }


        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("players", Integer.parseInt(players.getText().toString()));
        intent.putExtra("type", 1); //todo: change this. need more types
        startActivity(intent);

    }
}
