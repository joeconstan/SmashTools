package com.arealbreakfast.smashtools;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;


public class Exclude extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclude);
        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setAdapter(new ButtonAdapter());

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //remove from view and list passed to other thing
            }
        });


    }
}

class ButtonAdapter extends BaseAdapter {

    private ArrayList<Integer> mThumbIds = new ArrayList<>(58);


    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Button btn = new Button(convertView.getContext());

        mThumbIds.add(R.drawable.bayo);
        mThumbIds.add(R.drawable.bowser);
        mThumbIds.add(R.drawable.bowserjr);
        mThumbIds.add(R.drawable.captainfalcon);
        mThumbIds.add(R.drawable.charizard);
        mThumbIds.add(R.drawable.cloud);
        mThumbIds.add(R.drawable.corrin);
        mThumbIds.add(R.drawable.darkpit);
        mThumbIds.add(R.drawable.drmario);
        mThumbIds.add(R.drawable.duckhunt);
        mThumbIds.add(R.drawable.falco);
        mThumbIds.add(R.drawable.fox);
        mThumbIds.add(R.drawable.ganon);
        mThumbIds.add(R.drawable.greninja);
        mThumbIds.add(R.drawable.ike);
        mThumbIds.add(R.drawable.kingddd);
        mThumbIds.add(R.drawable.kirby);
        mThumbIds.add(R.drawable.link);
        mThumbIds.add(R.drawable.littlemac);
        mThumbIds.add(R.drawable.lucario);
        mThumbIds.add(R.drawable.lucas);
        mThumbIds.add(R.drawable.lucina);
        mThumbIds.add(R.drawable.luigi);
        mThumbIds.add(R.drawable.mario);
        mThumbIds.add(R.drawable.marth);
        mThumbIds.add(R.drawable.megaman);
        mThumbIds.add(R.drawable.metaknight);
        mThumbIds.add(R.drawable.mewtwo);
        mThumbIds.add(R.drawable.miibrawler);
        mThumbIds.add(R.drawable.miigunner);
        mThumbIds.add(R.drawable.miiswordfighter);
        mThumbIds.add(R.drawable.mrgnw);
        mThumbIds.add(R.drawable.ness);
        mThumbIds.add(R.drawable.olimar);
        mThumbIds.add(R.drawable.pacman);
        mThumbIds.add(R.drawable.palutena);
        mThumbIds.add(R.drawable.peach);
        mThumbIds.add(R.drawable.pikachupic);
        mThumbIds.add(R.drawable.pit);
        mThumbIds.add(R.drawable.puff);
        mThumbIds.add(R.drawable.rob);
        mThumbIds.add(R.drawable.robin);
        mThumbIds.add(R.drawable.rosalina);
        mThumbIds.add(R.drawable.roy);
        mThumbIds.add(R.drawable.ryupic);
        mThumbIds.add(R.drawable.samus);
        mThumbIds.add(R.drawable.sheik);
        mThumbIds.add(R.drawable.shulk);
        mThumbIds.add(R.drawable.sonic);
        mThumbIds.add(R.drawable.toonlink);
        mThumbIds.add(R.drawable.villager);
        mThumbIds.add(R.drawable.wario);
        mThumbIds.add(R.drawable.wft);
        mThumbIds.add(R.drawable.yoshi);
        mThumbIds.add(R.drawable.zelda);
        mThumbIds.add(R.drawable.zss);
        btn.setBackgroundResource(mThumbIds.get(position));
        btn.setTextColor(Color.WHITE);
        btn.setId(position);
        btn.setFocusableInTouchMode(false);
        btn.setFocusable(false);
        btn.setClickable(false);
        return btn;
    }
}