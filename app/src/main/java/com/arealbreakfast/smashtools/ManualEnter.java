package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ManualEnter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_enter);


        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        if (type == 0) { //smash 4
            //display all the characters and let them pick any number, then hit done
            LinearLayout rl = (LinearLayout) findViewById(R.id.manenterrel);
            for (int i = 0; i < 58; i++) {
                ImageView image = new ImageView(ManualEnter.this);
                image.setImageResource(mThumbIdss4[i]); //todo: order the array non-alphabetically so that this makes more intuitive sense

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(100, 100);

                lp.setMargins(10, 0, 0, 140);
                rl.setLayoutParams(lp);

                rl.addView(image);
            }
        }

    }


    private Integer[] mThumbIdss4 = { //#-58
            R.drawable.bayo, R.drawable.bowser,
            R.drawable.bowserjr, R.drawable.captainfalcon,
            R.drawable.charizard, R.drawable.cloud,
            R.drawable.corrin, R.drawable.darkpit,
            R.drawable.diddy, R.drawable.donkeykong,
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


}
