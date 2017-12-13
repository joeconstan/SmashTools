package com.arealbreakfast.smashtools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class AdapterSixtyFour extends BaseAdapter {

    private Context mContext;

    public AdapterSixtyFour(Context c) {
        mContext = c;
        for (int i = 0; i < 58; i++) {
            bools64hasy.add(false);
        }
    }


    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds64[position];
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
        image.setBackgroundResource(mThumbIds64[position]);
        image.setId(position);
        image.setFocusableInTouchMode(false);
        image.setFocusable(false);
        image.setClickable(false);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bools64hasy.get(position)) {
                    image.setImageResource(mThumbIds64y[position]);
                    ((ManualEnter) mContext).onClickOutside(position, 0); //add it to selected characters //0 means add, 1 means delete
                } else {
                    image.setImageResource(mThumbIds64[position]);
                    ((ManualEnter) mContext).onClickOutside(position, 1);
                }
                bools64hasy.set(position, !bools64hasy.get(position));
            }
        });


        return image;
    }

    private Integer[] mThumbIds64 = { //#-12
            R.drawable.captainfalconsf, R.drawable.donkeykongsf,
            R.drawable.foxsf, R.drawable.kirbysf,
            R.drawable.linksf, R.drawable.luigisf,
            R.drawable.mariosf, R.drawable.nesssf,
            R.drawable.pikachusf, R.drawable.puffsf,
            R.drawable.samsussf, R.drawable.yoshisf
    };


    private Integer[] mThumbIds64y = {
            R.drawable.captainfalconsfy, R.drawable.donkeykongsfy,
            R.drawable.foxsfy, R.drawable.kirbysfy,
            R.drawable.linksfy, R.drawable.luigisfy,
            R.drawable.mariosfy, R.drawable.nesssfy,
            R.drawable.pikachusfy, R.drawable.puffsfy,
            R.drawable.samsussfy, R.drawable.yoshisfy
    };
    private ArrayList<Boolean> bools64hasy = new ArrayList<>(0);

}
