package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class ManualEnter extends AppCompatActivity {

    private int type;
    private ArrayList<Integer> allCharacters;
    private int numPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_enter);


        Intent intent = getIntent();
        numPlayers = intent.getIntExtra("numPlayers", 0);
        numPlayers++;
        allCharacters = intent.getIntegerArrayListExtra("allCharacters");
        type = intent.getIntExtra("type", 0);
        if (type == 0) { //smash 4
            //let them search for characters and it adds it to a list
            final GridView gridView = (GridView) findViewById(R.id.gridView);
            final AdapterSmash4 adapterSmash4 = new AdapterSmash4(this);
            gridView.setAdapter(adapterSmash4);

        } else if (type == 1) { //melee
            //let them search for characters and it adds it to a list
            final GridView gridView = (GridView) findViewById(R.id.gridView);
            final AdapterMelee adapterMelee = new AdapterMelee(this);
            gridView.setAdapter(adapterMelee);
        } else if (type == 2) { //PM
            //let them search for characters and it adds it to a list
            final GridView gridView = (GridView) findViewById(R.id.gridView);
            final AdapterPM adapterPM = new AdapterPM(this);
            gridView.setAdapter(adapterPM);
        } else if (type == 3) { //Brawl
            //let them search for characters and it adds it to a list
            final GridView gridView = (GridView) findViewById(R.id.gridView);
            final AdapterBrawl adapterBrawl= new AdapterBrawl(this);
            gridView.setAdapter(adapterBrawl);
        }


    }

    public void onClickOutside(int position, int type) { //necessary because our onitemclick in this class wont be called because we have the same thing in the adapter. so this is called from the adapter.
        if (type == 0)
            allCharacters.add(position);
        else if (type == 1) {
            for (int i = allCharacters.size() - 1; i >= 0; i--) {
                if (allCharacters.get(i) == position) {
                    allCharacters.remove(i);
                    break;
                }
            }

        }
    }

    public void Next(View view) {
        Intent intent = new Intent(this, ManualEnter.class);
        intent.putIntegerArrayListExtra("allCharacters", allCharacters);
        intent.putExtra("numPlayers", numPlayers);
        intent.putExtra("type", type);
        startActivity(intent);

    }

    public void Start(View view) {
        Intent intent = new Intent(this, Results.class);
        intent.putIntegerArrayListExtra("chars", allCharacters);
        intent.putExtra("players", numPlayers);
        intent.putExtra("type", type);
        startActivity(intent);

    }


}
