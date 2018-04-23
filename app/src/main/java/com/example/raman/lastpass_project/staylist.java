package com.example.raman.lastpass_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class staylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staylist);

        Button sairaj=(Button)findViewById(R.id.sairaj);
        Button malhar=(Button)findViewById(R.id.malhar);
        Button shalimar=(Button)findViewById(R.id.shalimar);

        sairaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(staylist.this,eatskeleton.class);

                i1.putExtra("id","31");
                i1.putExtra("name","SaiRaj Palace");
                i1.putExtra("address","3564 Main Road,Opposite to janak villa,shirpur");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);

            }
        });

        malhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(staylist.this,eatskeleton.class);

                i1.putExtra("id","32");
                i1.putExtra("name","Malhar Regency");
                i1.putExtra("address","Karwand Naka, Mandal, Shirpur, Maharashtra");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);

            }
        });


        shalimar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(staylist.this,eatskeleton.class);

                i1.putExtra("id","33");
                i1.putExtra("name","Shalimar Residency");
                i1.putExtra("address","H.No.335/1,S.No.95 A B A/P,Amoda, Shirpur");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);


            }
        });

    }
}
