package com.example.raman.lastpass_project;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class myfavourites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfavourites);

        TextView fav1=(TextView)findViewById(R.id.fav1);
        TextView fav2=(TextView)findViewById(R.id.fav2);
        TextView fav3=(TextView)findViewById(R.id.fav3);

        final SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);



            fav1.setText(prefs.getString("200", ""));
            fav2.setText(prefs.getString("201", ""));
            fav3.setText(prefs.getString("202", ""));



    }
}
