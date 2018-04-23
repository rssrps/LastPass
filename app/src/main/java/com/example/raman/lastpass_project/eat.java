package com.example.raman.lastpass_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class eat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        Button chocolicious=(Button)findViewById(R.id.chocolicious);
        Button hangout=(Button)findViewById(R.id.hangout);
        Button bharkadevi=(Button)findViewById(R.id.bharkadevi);
        Button mansi=(Button)findViewById(R.id.mansi);
        Button saheba=(Button)findViewById(R.id.saheba);
        Button payal=(Button)findViewById(R.id.payal);
        Button royalcake=(Button)findViewById(R.id.royalcake);
        Button jainbaker=(Button)findViewById(R.id.jainbaker);





        chocolicious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(eat.this,eatskeleton.class);

                i1.putExtra("id","1");
                i1.putExtra("name","CHOCOLICIOUS");
                i1.putExtra("address","Gajanan Colony,Shirpur MH 425405");
                i1.putExtra("phone","080870 84456");
                i1.putExtra("timing","10:30am – 10:30 pm");

                startActivity(i1);
            }
        });



        hangout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","2");
                i1.putExtra("name","HANGOUT");
                i1.putExtra("address","shop no 9,Avdhut chambers,State Highway 4,Shirpur");
                i1.putExtra("phone","088570 94185");
                i1.putExtra("timing","10am - 10pm");

                startActivity(i1);
            }
        });


        bharkadevi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","3");
                i1.putExtra("name","BHARKA DEVI");
                i1.putExtra("address","Gajanan Colony, Shirpur, Maharashtra 425405");
                i1.putExtra("phone","8485076767");
                i1.putExtra("timing","09am - 11pm");

                startActivity(i1);
            }
        });



        mansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","4");
                i1.putExtra("name","MANSI");
                i1.putExtra("address","Kranti Nagar Colony,Shirpur");
                i1.putExtra("phone","8485076767");
                i1.putExtra("timing","08am - 11pm");

                startActivity(i1);
            }
        });


        payal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","5");
                i1.putExtra("name","PAYAL");
                i1.putExtra("address","Infront of Gujrati complex,Shirpur");
                i1.putExtra("phone","8485076767");
                i1.putExtra("timing","08am - 11pm");

                startActivity(i1);
            }
        });

        saheba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","6");
                i1.putExtra("name","SAHEBA");
                i1.putExtra("address","Near Mukesh Patel Garden, State Highway, Shirpur, Maharashtra 425405");
                i1.putExtra("phone","8485076767");
                i1.putExtra("timing","08am - 11pm");

                startActivity(i1);

            }
        });




        royalcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","7");
                i1.putExtra("name","Royal Bakery");
                i1.putExtra("address","New Ganesh Colony,Shirpur, Maharashtra 425405");
                i1.putExtra("phone","07057777856");
                i1.putExtra("timing","11am - 07pm");

                startActivity(i1);

            }
        });

        jainbaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eat.this,eatskeleton.class);
                i1.putExtra("id","8");
                i1.putExtra("name","JAIN BAKERS");
                i1.putExtra("address","Gautam Nagar,Ahead of busstand,Shirpur, Maharashtra 425405");
                i1.putExtra("phone","07057777856");
                i1.putExtra("timing","11am - 07pm");

                startActivity(i1);

            }
        });

    }
}
