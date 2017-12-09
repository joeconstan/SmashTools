package com.arealbreakfast.smashtools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class AdapterSmash4 extends BaseAdapter {

    private Context mContext;

    public AdapterSmash4(Context c) {
        mContext = c;
        for (int i = 0; i < 58; i++) {
            boolss4hasy.add(false);
        }
    }


    @Override
    public int getCount() {
        return 58;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIdss4[position];
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
        image.setBackgroundResource(mThumbIdss4[position]);
        image.setId(position);
        image.setFocusableInTouchMode(false);
        image.setFocusable(false);
        image.setClickable(false);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!boolss4hasy.get(position)) {
                    image.setImageResource(mThumbIdss4y[position]);
                    ((ManualEnter)mContext).onClickOutside(position, 0); //add it to selected characters //0 means add, 1 means delete
                }
                else {
                    image.setImageResource(mThumbIdss4[position]); //todo: need to remove from selected chars if this happens
                    ((ManualEnter)mContext).onClickOutside(position, 1);
                }
                boolss4hasy.set(position, !boolss4hasy.get(position));
            }
        });


        return image;
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

    private Integer[] mThumbIdss4y = { //#-58
            R.drawable.bayoy, R.drawable.bowsery,
            R.drawable.bowserjry, R.drawable.captainfalcony,
            R.drawable.charizardy, R.drawable.cloudy,
            R.drawable.corriny, R.drawable.darkpity,
            R.drawable.diddyy, R.drawable.donkeykongy,
            R.drawable.drmarioy, R.drawable.duckhunty,
            R.drawable.falcoy, R.drawable.foxy,
            R.drawable.ganony, R.drawable.greninjay,
            R.drawable.ikey, R.drawable.kingdddy,
            R.drawable.kirbyy, R.drawable.linky,
            R.drawable.littlemacy, R.drawable.lucarioy,
            R.drawable.lucasy, R.drawable.lucinay,
            R.drawable.luigiy, R.drawable.marioy,
            R.drawable.marthy, R.drawable.megamany,
            R.drawable.metaknighty, R.drawable.mewtwoy,
            R.drawable.miibrawlery, R.drawable.miigunnery,
            R.drawable.miiswordfightery, R.drawable.mrgnwy,
            R.drawable.nessy, R.drawable.olimary,
            R.drawable.pacmany, R.drawable.palutenay,
            R.drawable.peachy, R.drawable.pikachuy,
            R.drawable.pity, R.drawable.puffy,
            R.drawable.roby, R.drawable.robiny,
            R.drawable.rosalinay, R.drawable.royy,
            R.drawable.ryupicy, R.drawable.samusy,
            R.drawable.sheiky, R.drawable.shulky,
            R.drawable.sonicy, R.drawable.toonlinky,
            R.drawable.villagery, R.drawable.warioy,
            R.drawable.wfty, R.drawable.yoshiy,
            R.drawable.zelday, R.drawable.zssy
    };
    private ArrayList<Boolean> boolss4hasy = new ArrayList<>(0);

}
