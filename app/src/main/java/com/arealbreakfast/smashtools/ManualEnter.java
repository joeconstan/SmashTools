package com.arealbreakfast.smashtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class ManualEnter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_enter);


        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        if (type == 0) { //smash 4

            //let them search for characters and it adds it to a list
            final GridView gridView = (GridView) findViewById(R.id.gridView);
            final AdapterSmash4 adapterSmash4 = new AdapterSmash4(this);
            gridView.setAdapter(adapterSmash4);
            setContentView(gridView);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                }
            });

        }


    }




}
