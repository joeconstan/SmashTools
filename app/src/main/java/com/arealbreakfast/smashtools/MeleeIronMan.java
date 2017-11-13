package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;


public class MeleeIronMan extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meleeironman);

    }


    public void Exclude(View view) {
        Intent intent = new Intent(view.getContext(), Exclude.class);
        startActivity(intent);
    }

    public void Start(View view) {
        //pick characters randomly and display in Results activity
        EditText num = (EditText) findViewById(R.id.mimnumber_char);
        int x = Integer.parseInt(num.getText().toString());
        ArrayList<Integer> chosen_chars = new ArrayList<>(1);
        Random randomGenerator = new Random();
        for (int i = 0; i < x; i++) {
            //pick a new character
            chosen_chars.add(randomGenerator.nextInt(25));
            //need to remove duplicates as well by adding to hash set and then if its smaller than before, add another ad infitum until its correct size.
        }

        Intent intent = new Intent(view.getContext(), Results.class);
        intent.putExtra("chars", chosen_chars);
        intent.putExtra("type", 1);
        startActivity(intent);
    }

}
