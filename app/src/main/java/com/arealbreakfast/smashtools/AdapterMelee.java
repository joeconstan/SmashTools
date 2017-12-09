package com.arealbreakfast.smashtools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class AdapterMelee extends BaseAdapter {

    private Context mContext;

    public AdapterMelee(Context c) {
        mContext = c;
        for (int i = 0; i < 26; i++) {
            boolsmhasy.add(false);
        }
    }


    @Override
    public int getCount() {
        return 26;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIdsm[position];
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
        image.setBackgroundResource(mThumbIdsm[position]);
        image.setId(position);
        image.setFocusableInTouchMode(false);
        image.setFocusable(false);
        image.setClickable(false);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolsmhasy.get(position)) {
                    image.setImageResource(mThumbIdsmy[position]);
                    ((ManualEnter) mContext).onClickOutside(position, 0); //add it to selected characters //0 means add, 1 means delete
                } else {
                    image.setImageResource(mThumbIdsm[position]);
                    ((ManualEnter) mContext).onClickOutside(position, 1);
                }
                boolsmhasy.set(position, !boolsmhasy.get(position));
            }
        });


        return image;
    }

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

    private Integer[] mThumbIdsmy = {
            R.drawable.bowsermy, R.drawable.captainfalconmy,
            R.drawable.donkeykongmy, R.drawable.drmariomy,
            R.drawable.falcomy, R.drawable.foxmy,
            R.drawable.ganonmy, R.drawable.iceclimbersmy,
            R.drawable.jigglypuffmy, R.drawable.kirbymy,
            R.drawable.linkmy, R.drawable.luigimy,
            R.drawable.mariomy, R.drawable.marthmy,
            R.drawable.mewtwomy, R.drawable.mrgnwmy,
            R.drawable.nessmy, R.drawable.peachmy,
            R.drawable.pichumy, R.drawable.pikachumy,
            R.drawable.roymy, R.drawable.samusmy,
            R.drawable.sheikmy, R.drawable.yoshimy,
            R.drawable.younglinkmy, R.drawable.zeldamy
    };

    private ArrayList<Boolean> boolsmhasy = new ArrayList<>(0);

}
