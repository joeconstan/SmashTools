package com.arealbreakfast.smashtools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class AdapterPM extends BaseAdapter {


    private Context mContext;

    public AdapterPM(Context c) {
        mContext = c;
        for (int i = 0; i < 41; i++) {
            boolspmhasy.add(false);
        }
    }


    @Override
    public int getCount() {
        return 41;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIdspm[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView image;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            image = new ImageView(mContext);
            image.setLayoutParams(new GridView.LayoutParams(200, 200));
            image.setPadding(8, 8, 8, 8);
        } else {
            image = (ImageView) convertView;
        }
        image.setBackgroundResource(mThumbIdspm[position]);
        image.setId(position);
        image.setFocusableInTouchMode(false);
        image.setFocusable(false);
        image.setClickable(false);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolspmhasy.get(position)) {
                    image.setImageResource(mThumbIdspmy[position]);
                    ((ManualEnter) mContext).onClickOutside(position, 0); //add it to selected characters //0 means add, 1 means delete
                } else {
                    image.setImageResource(mThumbIdspm[position]);
                    ((ManualEnter) mContext).onClickOutside(position, 1);
                }
                boolspmhasy.set(position, !boolspmhasy.get(position));
            }
        });


        return image;
    }

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


    private Integer[] mThumbIdspmy = {
            R.drawable.bowserpmy, R.drawable.captainfalconpmy,
            R.drawable.charizardpmy, R.drawable.diddypmy,
            R.drawable.donkeykongpmy, R.drawable.falcopmy,
            R.drawable.foxpmy,
            R.drawable.ganonpmy, R.drawable.iceclimberspmy,
            R.drawable.ikepmy, R.drawable.ivysaurpmy,
            R.drawable.kingdddpmy, R.drawable.kirbypmy,
            R.drawable.linkpmy, R.drawable.lucariopmy,
            R.drawable.lucaspmy, R.drawable.luigipmy,
            R.drawable.mariopmy, R.drawable.marthpmy,
            R.drawable.metaknightpmy, R.drawable.mewtwopmy,
            R.drawable.mrgnwpmy, R.drawable.nesspmy,
            R.drawable.olimarpmy, R.drawable.peachpmy,
            R.drawable.pikachupmy, R.drawable.pitpmy,
            R.drawable.puffpmy, R.drawable.robpmy,
            R.drawable.roypmy, R.drawable.samuspmy,
            R.drawable.sheikpmy, R.drawable.snakepmy,
            R.drawable.sonicpmy, R.drawable.squirtlepmy,
            R.drawable.toonlinkpmy, R.drawable.wariopmy,
            R.drawable.wolfpmy, R.drawable.yoshipmy,
            R.drawable.zeldapmy, R.drawable.zsspmy
    };


    private ArrayList<Boolean> boolspmhasy = new ArrayList<>(0);

}
