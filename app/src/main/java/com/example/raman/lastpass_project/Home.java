package com.example.raman.lastpass_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.raman.lastpass_project.R.id.nextlevel;

public class Home extends AppCompatActivity {

     int sortcount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //final Bundle bundle = getIntent().getExtras();
        //final String message = bundle.getString("message");
        //final String pass123=bundle.getString("password");

        final SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);

        ImageView eat=(ImageView)findViewById(R.id.eat);
        ImageView account=(ImageView)findViewById(R.id.account);
        ImageView emergency=(ImageView)findViewById(R.id.Emergency);
        ImageView addplace=(ImageView)findViewById(R.id.add);
        ImageView helpicon=(ImageView)findViewById(R.id.helpicon);
        ImageView shopping=(ImageView)findViewById(R.id.shopping);
        ImageView banking=(ImageView)findViewById(R.id.banking);
        ImageView nextlevel=(ImageView)findViewById(R.id.nextlevel);
        ImageView stay=(ImageView) findViewById(R.id.stay);
        ImageView nearby=(ImageView)findViewById(R.id.nearby);


        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Home.this,nearby.class);
                startActivity(i);

            }
        });




        addplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5=new Intent(Home.this,addaplace.class);
                startActivity(i5);

            }
        });




        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home.this,staylist.class);
                startActivity(i);
            }
        });

        nextlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            sortcount=sortcount+1;
                if(sortcount%2==0)
                    Toast.makeText(getApplicationContext(),"Current filter:  Average rating",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Current filter:  Price",Toast.LENGTH_SHORT).show();
            }
        });


        banking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i4=new Intent(Home.this,hotelslist.class);
                startActivity(i4);
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2=new Intent(Home.this,shopslist.class);
                startActivity(i2);
            }
        });


        final EditText searchbox=(EditText)findViewById(R.id.searchbox);

        helpicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Home.this);
                    final TextView input = new TextView (Home.this);
                    input.setTextSize(14);

                    input.setGravity(Gravity.LEFT);
                    input.setText("\n\t         Hello! I am your personal Assistant\n\n      1.Swipe me quickly to get next tip.\n      2.I will help you throughout the app.\n      3.You can also slide me out of window.\n\n     To go on without me, tap the disable button");
                    builder.setView(input);

                    builder.setPositiveButton("Disable", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            editor.putString("disabled","1");
                            editor.commit();
                            // User clicked OK button
                        }
                    });


                    builder.setTitle("Personal Assistant");

                    android.app.AlertDialog dialog = builder.create();
                    dialog.setIcon(R.drawable.callgirl);
                    dialog.show();
                }


        });



        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent( Home.this, Account.class);
               // i.putExtra("message", message);
               // i.putExtra("password",pass123);
                startActivity(i);
            }


        });


        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Home.this,eat.class);
                startActivity(i2);
            }
        });



        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Home.this,alert_skeleton.class);
                startActivity(i1);
            }
        });

        searchbox.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press

                    //Toast.makeText(getApplicationContext(),searchbox.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent i1=new Intent(Home.this,eatskeleton.class);

                    int flagfound=0;

                    if(searchbox.getText().toString().equalsIgnoreCase("chocolicious"))
                    {
                        i1.putExtra("id","1");
                        i1.putExtra("name","CHOCOLICIOUS");
                        i1.putExtra("address","Gajanan Colony,Shirpur");
                        i1.putExtra("phone","080870 84456");
                        flagfound=1;
                        i1.putExtra("timing","10:30am – 10:30 pm");
                        startActivity(i1);

                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("Bharkadevi"))
                    {

                        i1.putExtra("id","3");
                        i1.putExtra("name","BHARKA DEVI");
                        i1.putExtra("address","Gajanan Colony, Shirpur, Maharashtra 425405");
                        i1.putExtra("phone","8485076767");
                        i1.putExtra("timing","09am - 11pm");
                        flagfound=1;
                        startActivity(i1);

                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("hangout"))
                    {

                        i1.putExtra("id","2");
                        i1.putExtra("name","HANGOUT");
                        i1.putExtra("address","shop no 9,Avdhut chambers,State Highway 4,Shirpur");
                        i1.putExtra("phone","088570 94185");
                        i1.putExtra("timing","10am - 10pm");
                        flagfound=1;
                        startActivity(i1);

                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("mansi"))
                    {
                        i1.putExtra("id","4");
                        i1.putExtra("name","MANSI");
                        i1.putExtra("address","Kranti Nagar Colony,Shirpur");
                        i1.putExtra("phone","");
                        i1.putExtra("timing","08am - 11pm");
                        flagfound=1;
                        startActivity(i1);

                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("payal"))
                    {
                        i1.putExtra("id","5");
                        i1.putExtra("name","PAYAL");
                        i1.putExtra("address","Infront of Gujrati complex,Shirpur");
                        i1.putExtra("phone","");
                        i1.putExtra("timing","08am - 11pm");
                        flagfound=1;
                        startActivity(i1);

                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("saheba"))
                    {
                        i1.putExtra("id","6");
                        i1.putExtra("name","SAHEBA");
                        i1.putExtra("address","Near Mukesh Patel Garden, State Highway, Shirpur, Maharashtra 425405");
                        i1.putExtra("phone","");
                        i1.putExtra("timing","08am - 11pm");
                        flagfound=1;
                        startActivity(i1);
                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("royal"))
                    {
                        i1.putExtra("id","7");
                        i1.putExtra("name","Royal Bakery");
                        i1.putExtra("address","New Ganesh Colony,Shirpur, Maharashtra 425405");
                        i1.putExtra("phone","07057777856");
                        i1.putExtra("timing","11am - 07pm");
                        flagfound=1;
                        startActivity(i1);

                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("jain"))
                    {
                        i1.putExtra("id","8");
                        i1.putExtra("name","JAIN BAKERS");
                        i1.putExtra("address","Gautam Nagar,Ahead of busstand,Shirpur, Maharashtra 425405");
                        i1.putExtra("phone","07057777856");
                        i1.putExtra("timing","11am - 07pm");
                        flagfound=1;
                        startActivity(i1);

                    }








                    if(searchbox.getText().toString().equalsIgnoreCase("eat"))
                    {
                        flagfound=1;
                        Intent gotoeat=new Intent(Home.this,eat.class);
                        startActivity(gotoeat);
                    }

                    if(searchbox.getText().toString().equalsIgnoreCase("alert"))
                    {
                        flagfound=1;
                        Intent gotoeat=new Intent(Home.this,alert_skeleton.class);
                        startActivity(gotoeat);
                    }










                    if(flagfound==0)
                     Toast.makeText(getApplicationContext(),"No results found!",Toast.LENGTH_SHORT).show();



                    searchbox.setText("");
                    return true;
                }
                return false;
            }
        });


    }


}
