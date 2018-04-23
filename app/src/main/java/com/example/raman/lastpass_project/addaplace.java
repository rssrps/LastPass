package com.example.raman.lastpass_project;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class addaplace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaplace);

        final int[] radiocounter = {0};

        final RadioButton eat=(RadioButton)findViewById(R.id.radioButton);
        final RadioButton stay=(RadioButton)findViewById(R.id.radioButton4);
        final RadioButton shop=(RadioButton)findViewById(R.id.radioButton2);
        final RadioButton banking=(RadioButton)findViewById(R.id.radioButton5);
        final RadioButton nearby=(RadioButton)findViewById(R.id.radioButton3);
        final RadioButton alert=(RadioButton)findViewById(R.id.radioButton6);

        final EditText name=(EditText)findViewById(R.id.placename);

        ImageView undo=(ImageView)findViewById(R.id.undoicon);
        final ImageView addarrow=(ImageView)findViewById(R.id.rightadd);

        name.requestFocus();

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eat.setChecked(false);
                stay.setChecked(false);
                shop.setChecked(false);
                banking.setChecked(false);
                nearby.setChecked(false);
                alert.setChecked(false);
            }
        });

        addarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(eat.isChecked())
                    radiocounter[0] = radiocounter[0] +1;

                if(stay.isChecked())
                    radiocounter[0] = radiocounter[0] +1;

                if(shop.isChecked())
                    radiocounter[0] = radiocounter[0] +1;

                if(alert.isChecked())
                    radiocounter[0] = radiocounter[0] +1;

                if(nearby.isChecked())
                    radiocounter[0] = radiocounter[0] +1;

                if(banking.isChecked())
                    radiocounter[0] = radiocounter[0] +1;


                if(name.getText().toString().equals("")||radiocounter[0]==0)
                {
                    Toast.makeText(getApplicationContext(),"Name or category invalid!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Details will be  posted to admin\n  Place will be added shortly!",Toast.LENGTH_LONG).show();
                    Intent i8=new Intent(addaplace.this,Home.class);
                    startActivity(i8);
                }
            }
        });





    }
}
