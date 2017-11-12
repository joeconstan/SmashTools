package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //display characters that the/each person got
        Intent intent = getIntent();
        ArrayList<Integer> chars = intent.getIntegerArrayListExtra("chars");
        int x = intent.getIntExtra("type", 0); //0 - smash4, 1- melee //todo: pass this extra

        int num = chars.size();
        //first.setImageResource(mThumbIds[chars.get(0)]);
        LinearLayout linlay = (LinearLayout) findViewById(R.id.linlay);
        for (int i = 0; i < num; i++) {
            ImageView image = new ImageView(Results.this);
            if (x==0)
                image.setImageResource(mThumbIdss4[chars.get(i)]);
            else
                image.setImageResource(mThumbIdsm[chars.get(i)]);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, 300);
            image.setLayoutParams(layoutParams);
            linlay.addView(image);
        }


    }


    private Integer[] mThumbIdss4 = {//missing the dks
            R.drawable.bayo, R.drawable.bowser,
            R.drawable.bowserjr, R.drawable.captainfalcon,
            R.drawable.charizard, R.drawable.cloud,
            R.drawable.corrin, R.drawable.darkpit,
            R.drawable.drmario, R.drawable.duckhunt,
            R.drawable.falco, R.drawable.fox,
            R.drawable.ganon, R.drawable.greninja,
            R.drawable.ike, R.drawable.kingddd,
            R.drawable.kirby, R.drawable.link,
            R.drawable.littlemac, R.drawable.lucario,
            R.drawable.lucas, R.drawable.lucina,
            R.drawable.luigi, R.drawable.mario,
            R.drawable.marth, R.drawable.megaman,
            R.drawable.metaknight, R.drawable.mewtwo,
            R.drawable.miibrawler, R.drawable.miigunner,
            R.drawable.miiswordfighter, R.drawable.mrgnw,
            R.drawable.ness, R.drawable.olimar,
            R.drawable.pacman, R.drawable.palutena,
            R.drawable.peach, R.drawable.pikachupic,
            R.drawable.pit, R.drawable.puff,
            R.drawable.rob, R.drawable.robin,
            R.drawable.rosalina, R.drawable.roy,
            R.drawable.ryupic, R.drawable.samus,
            R.drawable.sheik, R.drawable.shulk,
            R.drawable.sonic, R.drawable.toonlink,
            R.drawable.villager, R.drawable.wario,
            R.drawable.wft, R.drawable.yoshi,
            R.drawable.zelda, R.drawable.zss
    };

    private Integer[] mThumbIdsm = {
            R.drawable.mariom, R.drawable.luigim,
            R.drawable.yoshim, R.drawable.donkeykongm,
            R.drawable.linkm, R.drawable.samusm,
            R.drawable.kirbym, R.drawable.foxm,
            R.drawable.pikachum, R.drawable.jigglypuffm,
            R.drawable.nessm, R.drawable.peachm,
            R.drawable.younglinkm, R.drawable.bowserm,
            R.drawable.ganonm, R.drawable.drmariom,
            R.drawable.sheikm, R.drawable.zeldam,
            R.drawable.falcom, R.drawable.mewtwom,
            R.drawable.pichum, R.drawable.iceclimbersm,
            R.drawable.roym, R.drawable.marthm,
            R.drawable.mrgnwm
    };
}
