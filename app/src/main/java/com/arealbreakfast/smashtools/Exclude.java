package com.arealbreakfast.smashtools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;


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
                
            }
        });


    }
}

class ButtonAdapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 0;
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

        ImageButton i = new ImageButton(convertView.getContext());

        i.setImageResource(mFams.get(position).imageId);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final int w = (int) (36 * getResources().getDisplayMetrics().density + 0.5f);
        i.setLayoutParams(new GridView.LayoutParams(w * 2, w * 2));
        return i;
    }
}