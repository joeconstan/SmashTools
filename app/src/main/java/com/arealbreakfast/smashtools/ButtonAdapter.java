package com.arealbreakfast.smashtools;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ButtonAdapter extends BaseAdapter {

    private Context mContext;

    public ButtonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView char_button;


        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            char_button = new ImageView(mContext);
            Picasso.with(mContext).load(mThumbIds[position]).into(char_button);
            char_button.setLayoutParams(new GridView.LayoutParams(85, 85));
            char_button.setPadding(8, 8, 8, 8);
            //char_button.setBackgroundResource(mThumbIds[position]);
            //char_button.setTextColor(Color.WHITE);
            char_button.setId(position);
        } else {
            char_button = (ImageView) convertView;
        }

        //char_button.setBackgroundResource(mThumbIds.get(position));
        //Button btn = new Button(convertView.getContext());
        //char_button.setFocusableInTouchMode(false);
        //char_button.setFocusable(false);
        //char_button.setClickable(false);
        return char_button;
    }


    private Integer[] mThumbIds = {
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
}