package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashSet;


public class Results extends AppCompatActivity {

    private static final String TAG = "here";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        //display characters that the/each person got
        Intent intent = getIntent();
        final ArrayList<Integer> chars = intent.getIntegerArrayListExtra("chars");

        int x = intent.getIntExtra("type", 0); //0 - smash4, 1 - melee, 2 - pm, 3 - brawl, 4 - 64
        int p_num = intent.getIntExtra("players", 2);
        int c_num = chars.size() / p_num; //num of chars per person


        for (int i = 0; i < c_num * p_num; i++) {
            boolss4hasx.add(false);
            boolss4lmiihasx.add(false);
            boolsmhasx.add(false);
            boolspmhasx.add(false);
            boolsbhasx.add(false);
            bools64hasx.add(false);
        }



        //dynamically create linear layouts and images for them depending on player num and character num
        LinearLayout parentlinlay = (LinearLayout) findViewById(R.id.parentlinlay);
        for (int j = 0; j < p_num; j++) {
            Log.v(TAG, "p_num: " + p_num + " c_num: " + c_num + "\n");
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setId(j + 100);
            int l = j * c_num;
            for (int i = 0; i < c_num; i++) {
                final ImageView image = new ImageView(Results.this);
                if (x == 0) {
                    if (intent.getIntExtra("mii", 1) == 0) {
                        image.setImageResource(mThumbIdss4lmii[chars.get(l)]); //0, 1, 2, 3
                        //Picasso.with(Results.this).load(mThumbIdss4lmii[chars.get(l)]).into(image);
                        final int finalL = l;
                        image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!boolss4lmiihasx.get(finalL))
                                    //Picasso.with(Results.this).load(mThumbIdss4xlmii[chars.get(finalL)]).into(image);
                                    image.setImageResource(mThumbIdss4xlmii[chars.get(finalL)]);
                                else
                                    //Picasso.with(Results.this).load(mThumbIdss4lmii[chars.get(finalL)]).into(image);
                                    image.setImageResource(mThumbIdss4lmii[chars.get(finalL)]);
                                boolss4lmiihasx.set(finalL, !boolss4lmiihasx.get(finalL));
                            }
                        });
                    } else {
                        image.setImageResource(mThumbIdss4[chars.get(l)]); //0, 1, 2, 3
                        final int finalL = l;
                        image.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!boolss4hasx.get(finalL))
                                    image.setImageResource(mThumbIdss4x[chars.get(finalL)]);
                                else
                                    image.setImageResource(mThumbIdss4[chars.get(finalL)]);
                                boolss4hasx.set(finalL, !boolss4hasx.get(finalL));
                            }
                        });
                    }
                } else if (x == 1) {
                    image.setImageResource(mThumbIdsm[chars.get(l)]);
                    final int finalL = l;
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!boolsmhasx.get(finalL))
                                image.setImageResource(mThumbIdsmx[chars.get(finalL)]);
                            else
                                image.setImageResource(mThumbIdsm[chars.get(finalL)]);
                            boolsmhasx.set(finalL, !boolsmhasx.get(finalL));
                        }
                    });
                } else if (x == 2) {
                    image.setImageResource(mThumbIdspm[chars.get(l)]);
                    final int finalL = l;
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!boolspmhasx.get(finalL))
                                image.setImageResource(mThumbIdspmx[chars.get(finalL)]);
                            else
                                image.setImageResource(mThumbIdspm[chars.get(finalL)]);
                            boolspmhasx.set(finalL, !boolspmhasx.get(finalL));
                        }
                    });
                } else if (x == 3) {
                    image.setImageResource(mThumbIdsb[chars.get(l)]);
                    final int finalL = l;
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!boolsbhasx.get(finalL))
                                image.setImageResource(mThumbIdsbx[chars.get(finalL)]);
                            else
                                image.setImageResource(mThumbIdsb[chars.get(finalL)]);
                            boolsbhasx.set(finalL, !boolsbhasx.get(finalL));
                        }
                    });
                } else if (x == 4) {
                    image.setImageResource(mThumbIds64[chars.get(l)]);
                    final int finalL = l;
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!bools64hasx.get(finalL))
                                image.setImageResource(mThumbIds64x[chars.get(finalL)]);
                            else
                                image.setImageResource(mThumbIds64[chars.get(finalL)]);
                            bools64hasx.set(finalL, !bools64hasx.get(finalL));
                        }
                    });
                }


                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, 300);
                image.setLayoutParams(layoutParams);
                linearLayout.addView(image);
                l++;
            }

            //now set on click listeenrs for all of the dynamically created images, so we can change the pictures to and from X's


            HorizontalScrollView scroll = new HorizontalScrollView(this);


            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(10, 0, 0, 140);
            linearLayout.setLayoutParams(lp);
            scroll.addView(linearLayout);
            parentlinlay.addView(scroll);
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


    private Integer[] mThumbIdss4x = {
            R.drawable.bayox, R.drawable.bowserx,
            R.drawable.bowserjrx, R.drawable.captainfalconx,
            R.drawable.charizardx, R.drawable.cloudx,
            R.drawable.corrinx, R.drawable.darkpitx,
            R.drawable.diddyx, R.drawable.donkeykongx,
            R.drawable.drmariox, R.drawable.duckhuntx,
            R.drawable.falcox, R.drawable.foxx,
            R.drawable.ganonx, R.drawable.greninjax,
            R.drawable.ikex, R.drawable.kingdddx,
            R.drawable.kirbyx, R.drawable.linkx,
            R.drawable.littlemacx, R.drawable.lucariox,
            R.drawable.lucasx, R.drawable.lucinax,
            R.drawable.luigix, R.drawable.mariox,
            R.drawable.marthx, R.drawable.megamanx,
            R.drawable.metaknightx, R.drawable.mewtwox,
            R.drawable.miibrawlerx, R.drawable.miigunnerx,
            R.drawable.miiswordfighterx, R.drawable.mrgnwx,
            R.drawable.nessx, R.drawable.olimarx,
            R.drawable.pacmanx, R.drawable.palutenax,
            R.drawable.peachx, R.drawable.pikachupicx,
            R.drawable.pitx, R.drawable.puffx,
            R.drawable.robx, R.drawable.robinx,
            R.drawable.rosalinax, R.drawable.royx,
            R.drawable.ryupicx, R.drawable.samusx,
            R.drawable.sheikx, R.drawable.shulkx,
            R.drawable.sonicx, R.drawable.toonlinkx,
            R.drawable.villagerx, R.drawable.wariox,
            R.drawable.wftx, R.drawable.yoshix,
            R.drawable.zeldax, R.drawable.zssx
    };


    private Integer[] mThumbIdss4lmii = { //#-55
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
            R.drawable.mrgnw,
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


    private Integer[] mThumbIdss4xlmii = {
            R.drawable.bayox, R.drawable.bowserx,
            R.drawable.bowserjrx, R.drawable.captainfalconx,
            R.drawable.charizardx, R.drawable.cloudx,
            R.drawable.corrinx, R.drawable.darkpitx,
            R.drawable.diddyx, R.drawable.donkeykongx,
            R.drawable.drmariox, R.drawable.duckhuntx,
            R.drawable.falcox, R.drawable.foxx,
            R.drawable.ganonx, R.drawable.greninjax,
            R.drawable.ikex, R.drawable.kingdddx,
            R.drawable.kirbyx, R.drawable.linkx,
            R.drawable.littlemacx, R.drawable.lucariox,
            R.drawable.lucasx, R.drawable.lucinax,
            R.drawable.luigix, R.drawable.mariox,
            R.drawable.marthx, R.drawable.megamanx,
            R.drawable.metaknightx, R.drawable.mewtwox,
            R.drawable.mrgnwx,
            R.drawable.nessx, R.drawable.olimarx,
            R.drawable.pacmanx, R.drawable.palutenax,
            R.drawable.peachx, R.drawable.pikachupicx,
            R.drawable.pitx, R.drawable.puffx,
            R.drawable.robx, R.drawable.robinx,
            R.drawable.rosalinax, R.drawable.royx,
            R.drawable.ryupicx, R.drawable.samusx,
            R.drawable.sheikx, R.drawable.shulkx,
            R.drawable.sonicx, R.drawable.toonlinkx,
            R.drawable.villagerx, R.drawable.wariox,
            R.drawable.wftx, R.drawable.yoshix,
            R.drawable.zeldax, R.drawable.zssx
    };


    private Integer[] mThumbIdsm = { //#-26
            R.drawable.bowserm, R.drawable.captainfalconm,
            R.drawable.donkeykongm, R.drawable.drmariom,
            R.drawable.falcom, R.drawable.foxm,
            R.drawable.ganonm, R.drawable.iceclimbersm,
            R.drawable.jigglypuffm, R.drawable.kirbym,
            R.drawable.linkm, R.drawable.luigim,
            R.drawable.mariom, R.drawable.marthm,
            R.drawable.mewtwom, R.drawable.mrgnwm,
            R.drawable.nessm, R.drawable.peachm,
            R.drawable.pichum, R.drawable.pikachum,
            R.drawable.roym, R.drawable.samusm,
            R.drawable.sheikm, R.drawable.yoshim,
            R.drawable.younglinkm, R.drawable.zeldam
    };

    private Integer[] mThumbIdsmx = {
            R.drawable.bowsermx, R.drawable.captainfalconmx,
            R.drawable.donkeykongmx, R.drawable.drmariomx,
            R.drawable.falcomx, R.drawable.foxmx,
            R.drawable.ganonmx, R.drawable.iceclimbersmx,
            R.drawable.jigglypuffmx, R.drawable.kirbymx,
            R.drawable.linkmx, R.drawable.luigimx,
            R.drawable.mariomx, R.drawable.marthmx,
            R.drawable.mewtwomx, R.drawable.mrgnwmx,
            R.drawable.nessmx, R.drawable.peachmx,
            R.drawable.pichumx, R.drawable.pikachumx,
            R.drawable.roymx, R.drawable.samusmx,
            R.drawable.sheikmx, R.drawable.yoshimx,
            R.drawable.younglinkmx, R.drawable.zeldamx
    };


    private Integer[] mThumbIdspm = { //#-41
            R.drawable.bowserpm, R.drawable.captainfalconpm,
            R.drawable.charizardpm, R.drawable.diddypm,
            R.drawable.donkeykongpm, R.drawable.falcopm,
            R.drawable.foxpm,
            R.drawable.ganonpm, R.drawable.iceclimberspm,
            R.drawable.ikepm, R.drawable.ivysaurpm,
            R.drawable.kingdddpm, R.drawable.kirbypm,
            R.drawable.linkpm, R.drawable.lucariopm,
            R.drawable.lucaspm, R.drawable.luigipm,
            R.drawable.mariopm, R.drawable.marthpm,
            R.drawable.metaknightpm, R.drawable.mewtwopm,
            R.drawable.mrgnwpm, R.drawable.nesspm,
            R.drawable.olimarpm, R.drawable.peachpm,
            R.drawable.pikachupm, R.drawable.pitpm,
            R.drawable.puffpm, R.drawable.robpm,
            R.drawable.roypm, R.drawable.samuspm,
            R.drawable.sheikpm, R.drawable.snakepm,
            R.drawable.sonicpm, R.drawable.squirtlepm,
            R.drawable.toonlinkpm, R.drawable.wariopm,
            R.drawable.wolfpm, R.drawable.yoshipm,
            R.drawable.zeldapm, R.drawable.zsspm
    };


    private Integer[] mThumbIdspmx = {
            R.drawable.bowserpmx, R.drawable.captainfalconpmx,
            R.drawable.charizardpmx, R.drawable.diddypmx,
            R.drawable.donkeykongpmx, R.drawable.falcopmx,
            R.drawable.foxpmx,
            R.drawable.ganonpmx, R.drawable.iceclimberspmx,
            R.drawable.ikepmx, R.drawable.ivysaurpmx,
            R.drawable.kingdddpmx, R.drawable.kirbypmx,
            R.drawable.linkpmx, R.drawable.lucariopmx,
            R.drawable.lucaspmx, R.drawable.luigipmx,
            R.drawable.mariopmx, R.drawable.marthpmx,
            R.drawable.metaknightpmx, R.drawable.mewtwopmx,
            R.drawable.mrgnwpmx, R.drawable.nesspmx,
            R.drawable.olimarpmx, R.drawable.peachpmx,
            R.drawable.pikachupmx, R.drawable.pitpmx,
            R.drawable.puffpmx, R.drawable.robpmx,
            R.drawable.roypmx, R.drawable.samuspmx,
            R.drawable.sheikpmx, R.drawable.snakepmx,
            R.drawable.sonicpmx, R.drawable.squirtlepmx,
            R.drawable.toonlinkpmx, R.drawable.wariopmx,
            R.drawable.wolfpmx, R.drawable.yoshipmx,
            R.drawable.zeldapmx, R.drawable.zsspmx
    };


    private Integer[] mThumbIdsb = { //#-39
            R.drawable.bowserpm, R.drawable.captainfalconpm,
            R.drawable.charizardpm, R.drawable.diddypm,
            R.drawable.donkeykongpm, R.drawable.falcopm,
            R.drawable.foxpm,
            R.drawable.ganonpm, R.drawable.iceclimberspm,
            R.drawable.ikepm, R.drawable.ivysaurpm,
            R.drawable.kingdddpm, R.drawable.kirbypm,
            R.drawable.linkpm, R.drawable.lucariopm,
            R.drawable.lucaspm, R.drawable.luigipm,
            R.drawable.mariopm, R.drawable.marthpm,
            R.drawable.metaknightpm, R.drawable.mrgnwpm,
            R.drawable.nesspm, R.drawable.olimarpm,
            R.drawable.peachpm, R.drawable.pikachupm,
            R.drawable.pitpm, R.drawable.puffpm,
            R.drawable.robpm, R.drawable.samuspm,
            R.drawable.sheikpm, R.drawable.snakepm,
            R.drawable.sonicpm, R.drawable.squirtlepm,
            R.drawable.toonlinkpm, R.drawable.wariopm,
            R.drawable.wolfpm, R.drawable.yoshipm,
            R.drawable.zeldapm, R.drawable.zsspm
    };


    private Integer[] mThumbIdsbx = {
            R.drawable.bowserpmx, R.drawable.captainfalconpmx,
            R.drawable.charizardpmx, R.drawable.diddypmx,
            R.drawable.donkeykongpmx, R.drawable.falcopmx,
            R.drawable.foxpmx,
            R.drawable.ganonpmx, R.drawable.iceclimberspmx,
            R.drawable.ikepmx, R.drawable.ivysaurpmx,
            R.drawable.kingdddpmx, R.drawable.kirbypmx,
            R.drawable.linkpmx, R.drawable.lucariopmx,
            R.drawable.lucaspmx, R.drawable.luigipmx,
            R.drawable.mariopmx, R.drawable.marthpmx,
            R.drawable.metaknightpmx, R.drawable.mrgnwpmx,
            R.drawable.nesspmx, R.drawable.olimarpmx,
            R.drawable.peachpmx, R.drawable.pikachupmx,
            R.drawable.pitpmx, R.drawable.puffpmx,
            R.drawable.robpmx, R.drawable.samuspmx,
            R.drawable.sheikpmx, R.drawable.snakepmx,
            R.drawable.sonicpmx, R.drawable.squirtlepmx,
            R.drawable.toonlinkpmx, R.drawable.wariopmx,
            R.drawable.wolfpmx, R.drawable.yoshipmx,
            R.drawable.zeldapmx, R.drawable.zsspmx
    };






    private Integer[] mThumbIds64 = { //#-12
            R.drawable.captainfalconsf, R.drawable.donkeykongsf,
            R.drawable.foxsf, R.drawable.kirbysf,
            R.drawable.linksf, R.drawable.luigisf,
            R.drawable.mariosf, R.drawable.nesssf,
            R.drawable.pikachusf, R.drawable.puffsf,
            R.drawable.samsussf, R.drawable.yoshisf
    };


    private Integer[] mThumbIds64x = {
            R.drawable.captainfalconsfx, R.drawable.donkeykongsfx,
            R.drawable.foxsfx, R.drawable.kirbysfx,
            R.drawable.linksfx, R.drawable.luigisfx,
            R.drawable.mariosfx, R.drawable.nesssfx,
            R.drawable.pikachusfx, R.drawable.puffsfx,
            R.drawable.samsussfx, R.drawable.yoshisfx
    };



    private ArrayList<Boolean> boolss4hasx = new ArrayList<>(0);
    private ArrayList<Boolean> boolsmhasx = new ArrayList<>(0);
    private ArrayList<Boolean> boolss4lmiihasx = new ArrayList<>(0);
    private ArrayList<Boolean> boolspmhasx = new ArrayList<>(0);
    private ArrayList<Boolean> boolsbhasx = new ArrayList<>(0);
    private ArrayList<Boolean> bools64hasx = new ArrayList<>(0);


}
