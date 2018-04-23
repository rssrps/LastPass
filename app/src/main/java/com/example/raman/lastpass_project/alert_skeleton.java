package com.example.raman.lastpass_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alert_skeleton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_skeleton);

        Button igm=(Button)findViewById(R.id.igm);
        Button dental=(Button)findViewById(R.id.dental);
        Button siddhivinayak=(Button)findViewById(R.id.siddhivinayak);
        Button navjeevan=(Button)findViewById(R.id.navjeevan);


        igm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(alert_skeleton.this,eatskeleton.class);

                i1.putExtra("id","41");
                i1.putExtra("name"," Indra Gandhi Memorial ");
                i1.putExtra("address","H.No.335/1,S.No.95 A B A/P,Amoda, Shirpur Dhule");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);

            }
        });


        dental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(alert_skeleton.this,eatskeleton.class);

                i1.putExtra("id","42");
                i1.putExtra("name","Dental Clinic");
                i1.putExtra("address","H.No.335/1,S.No.95 A B A/P,Amoda, Shirpur Dhule");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);
            }
        });


        siddhivinayak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(alert_skeleton.this,eatskeleton.class);

                i1.putExtra("id","43");
                i1.putExtra("name","SiddhiVinayak");
                i1.putExtra("address"," Karwand Naka, Near Petrol Pump, Mandal, Shirpur");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);

            }
        });

        navjeevan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(alert_skeleton.this,eatskeleton.class);

                i1.putExtra("id","44");
                i1.putExtra("name","Navjeevan");
                i1.putExtra("address","3564 Main Road, Near Shirpur Bus Stand, Shirpur");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);

            }
        });


    }
}
