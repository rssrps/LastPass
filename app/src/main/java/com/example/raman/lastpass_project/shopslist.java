package com.example.raman.lastpass_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shopslist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopslist);

        Button guru=(Button)findViewById(R.id.guru);
        Button ram=(Button)findViewById(R.id.ramhd);
        Button royalgift=(Button)findViewById(R.id.royaltouch);
        Button vismai=(Button)findViewById(R.id.vismai);
        Button ajinkya=(Button)findViewById(R.id.ajinkya);
        Button gajanan=(Button)findViewById(R.id.gajanan);

        guru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(shopslist.this,eatskeleton.class);
                i1.putExtra("id","20");
                i1.putExtra("name","Guru Ply");
                i1.putExtra("address","Plot no 5 vakil colony, Mandal road, Shirpur, Dhule - 425405, Near kashiram ");
                i1.putExtra("phone","9850486545");
                i1.putExtra("timing","10:30am – 10:30 pm");
                startActivity(i1);
            }
        });

        ram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(shopslist.this,eatskeleton.class);
                i1.putExtra("id","21");
                i1.putExtra("name","Ram Hardware");
                i1.putExtra("address"," Mandal Road, Shirpur, Dhule - 425405, Near Karwand Naka (Map)\n");
                i1.putExtra("phone","9028116260 ");
                i1.putExtra("timing","10:00am – 9:30 pm");
                startActivity(i1);
            }
        });

        royalgift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(shopslist.this,eatskeleton.class);
                i1.putExtra("id","22");
                i1.putExtra("name","Royal Touch gift");
                i1.putExtra("address","11, Vidya Vardini Colony, Mandal Road, Shirpur, Dhule");
                i1.putExtra("phone","9028116260  ");
                i1.putExtra("timing","10:00am – 9:30 pm");
                startActivity(i1);

            }
        });

        vismai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(shopslist.this,eatskeleton.class);
                i1.putExtra("id","23");
                i1.putExtra("name","Vismai gifts");
                i1.putExtra("address","Yogesh complex shop no 4, Shahada chopada road, Shirpur, Dhule - 425405, Near Nimzari naka ");
                i1.putExtra("phone","9028116260  ");
                i1.putExtra("timing","10:00am – 9:30 pm");
                startActivity(i1);
            }
        });


        ajinkya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(shopslist.this,eatskeleton.class);
                i1.putExtra("id","24");
                i1.putExtra("name","Ajinkya Medical");
                i1.putExtra("address","16, Babuji Complex, Shirpur, Dhule - 425405, Mahatma Fule Chowk,Varwade");
                i1.putExtra("phone","9028116260  ");
                i1.putExtra("timing","10:00am – 9:30 pm");
                startActivity(i1);
            }
        });



        gajanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(shopslist.this,eatskeleton.class);
                i1.putExtra("id","25");
                i1.putExtra("name","Gajanan Medical");
                i1.putExtra("address","  Fule market shop no 24, Main road, Shirpur, Dhule - 425405");
                i1.putExtra("phone","9028116260  ");
                i1.putExtra("timing","10:00am – 9:30 pm");
                startActivity(i1);


            }
        });




    }
}
