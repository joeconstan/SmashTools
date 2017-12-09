package com.arealbreakfast.smashtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class UserSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);


        final TextView numplayer = (TextView) findViewById(R.id.settingsnumberplay);
        final TextView numchar = (TextView) findViewById(R.id.settingsnumberchar);
        ImageButton incplay = (ImageButton) findViewById(R.id.increase_play);
        ImageButton decplay = (ImageButton) findViewById(R.id.decrease_play);
        ImageButton incchar = (ImageButton) findViewById(R.id.increase_char);
        ImageButton decchar = (ImageButton) findViewById(R.id.decrease_char);

        //check if they have set preferences, set them if so
        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int defaultValue = 100;
        int prefPlay = sharedPref.getInt("prefPlay", defaultValue);
        int prefChar = sharedPref.getInt("prefChar", defaultValue);
        if (prefPlay != defaultValue) {
            numplayer.setText(String.valueOf(prefPlay));
        }
        if (prefChar != defaultValue) {
            numchar.setText(String.valueOf(prefChar));
        }


        incplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numplayer.getText().toString());
                n++;
                numplayer.setText(String.valueOf(n));
            }
        });

        decplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numplayer.getText().toString());
                n--;
                numplayer.setText(String.valueOf(n));
            }
        });

        incchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numchar.getText().toString());
                n++;
                numchar.setText(String.valueOf(n));
            }
        });

        decchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(numchar.getText().toString());
                n--;
                numchar.setText(String.valueOf(n));
            }
        });


    }


    public void Save(View view) {
        TextView numplayer = (TextView) findViewById(R.id.settingsnumberplay);
        TextView numchar = (TextView) findViewById(R.id.settingsnumberchar);

        //commit their preferences to sharedprefs, to be pulled from later
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putInt("prefPlay", Integer.parseInt(numplayer.getText().toString()));
        editor.putInt("prefChar", Integer.parseInt(numchar.getText().toString()));
        editor.apply();

        super.onBackPressed();
    }


}
