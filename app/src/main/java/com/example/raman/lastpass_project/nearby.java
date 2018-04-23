package com.example.raman.lastpass_project;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class nearby extends AppCompatActivity {

    int photocount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        final ImageView photo=(ImageView)findViewById(R.id.photo);
        final ImageView right=(ImageView)findViewById(R.id.righticon);
        ImageView left=(ImageView)findViewById(R.id.lefticon);
        final TextView name=(TextView)findViewById(R.id.placename);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    photocount=(photocount+1)%3;
                    if(photocount==1)
                    {
                        photo.setImageResource(R.drawable.shirpur_garden);
                        name.setText("Shirpur Water park");
                    }

                    if(photocount==2)
                    {
                        photo.setImageResource(R.drawable.shirpur_garden2);
                        name.setText("Shirpur garden");
                    }
                    if(photocount==0)
                    {
                        photo.setImageResource(R.drawable.toranmal_1);
                        name.setText("Toranmal");
                    }
            }
        });


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(photocount==0)
                    photocount=2;
                else
                     photocount=(photocount-1)%3;

                if(photocount==1)
                {
                    photo.setImageResource(R.drawable.shirpur_garden);
                    name.setText("Shirpur Water park");

                }

                if(photocount==2)
                {
                    photo.setImageResource(R.drawable.shirpur_garden2);
                    name.setText("Shirpur garden");
                }
                if(photocount==0)
                {
                    photo.setImageResource(R.drawable.toranmal_1);
                    name.setText("Toranmal");
                }

            }
        });

    }
}
