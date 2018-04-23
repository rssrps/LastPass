package com.example.raman.lastpass_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.sax.StartElementListener;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;

import static com.example.raman.lastpass_project.R.id.activity_login;
import static com.example.raman.lastpass_project.R.id.login;
import static com.example.raman.lastpass_project.R.id.username1;

public class Account extends AppCompatActivity implements TextToSpeech.OnInitListener {

int counter=0;
    int remaining=4,visited=0,cash=1000;
    int hintcounter=0;

    private TextToSpeech tts;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private float xCoOrdinate, yCoOrdinate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        final TextView username=(TextView)findViewById(R.id.username1);

        final SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);

        Bundle bundle = getIntent().getExtras();
       // String message = bundle.getString("message");
        //final String password123=bundle.getString("password");
       // username.setText(message);

        tts = new TextToSpeech(this,this);
        tts.setPitch((float) 1.300);
        ImageView myfav=(ImageView)findViewById(R.id.myfav);

        myfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(Account.this,myfavourites.class);
                startActivity(i3);
            }
        });

        myfav.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                editor.putString("200","");
                editor.putString("201","");
                editor.putString("202","");
                editor.putString("favouritecount","200");
                editor.commit();

                return true;
            }
        });

        final ImageView girl_account=(ImageView)findViewById(R.id.girl_account);
        girl_account.setImageResource(R.drawable.callgirl);

        if(prefs.getString("disabled","0").equals("1"))
        {
            girl_account.setVisibility(View.INVISIBLE);
        }



        girl_account.setOnTouchListener(new View.OnTouchListener() {

            private static final int MAX_CLICK_DURATION = 10;
            private long startClickTime;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();
                        //startClickTime = Calendar.getInstance().getTimeInMillis();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        startClickTime = Calendar.getInstance().getTimeInMillis();
                        break;
                    case MotionEvent.ACTION_UP: {
                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                        if(clickDuration < MAX_CLICK_DURATION) {

                            hintcounter=(hintcounter+1)%5 ;

                            if(hintcounter==1)
                                speakOut("Click the favourite button to view places you liked. ");
                            if(hintcounter==2)
                                speakOut("You can update your spent cash under cash icon.");
                            if(hintcounter==3)
                                speakOut("Manage your password and cash limit under settings");
                            if(hintcounter==4)
                                speakOut("To log out of this account, use log out button at the bottom.");
                            if(hintcounter==0)
                                speakOut("Change your profile picture by clicking on your current profile picture.");


                            // Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();  //click event has occurred
                        }
                    }
                    break;

                    default:
                        return false;
                }
                return true;
            }
        });

        TextView t1=(TextView)findViewById(R.id.textView4);
        TextView t2=(TextView)findViewById(R.id.textView3);
        TextView t3=(TextView)findViewById(R.id.textView7);
        final TextView rem=(TextView) findViewById(R.id.remaining);
        final TextView vis=(TextView) findViewById(R.id.visit);
        TextView t4=(TextView)findViewById(R.id.textView);
        TextView t5=(TextView)findViewById(R.id.textView6);
        TextView t6=(TextView)findViewById(R.id.textView5);


        final ImageView profile=(ImageView)findViewById(R.id.profilepic);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             counter++;

                if(counter%4==0)
                    profile.setImageResource(R.drawable.profile2);
                if(counter%4==1)
                    profile.setImageResource(R.drawable.profile1);
                if(counter%4==2)
                    profile.setImageResource(R.drawable.profile3);
                if(counter%4==3)
                    profile.setImageResource(R.drawable.profile4);
            }
        });

        final ImageView circle1=(ImageView)findViewById(R.id.cir1);
        final ImageView circle2=(ImageView)findViewById(R.id.cir2);
        final ImageView circle3=(ImageView)findViewById(R.id.cir3);
        final ImageView circle4=(ImageView)findViewById(R.id.cir4);


        ImageView plane=(ImageView)findViewById(R.id.goshirpur);


        plane.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                remaining=4;
                visited=0;
                rem.setText(String.valueOf(remaining));
                vis.setText(String.valueOf(visited));
                return true;
            }
        });




        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("cashspent","0");

                if(remaining>0)
                {

                    if(remaining==4)
                        circle4.setVisibility(View.INVISIBLE);
                    if(remaining==3)
                    {
                        circle4.setVisibility(view.INVISIBLE);
                        circle3.setVisibility(view.INVISIBLE);
                    }
                    if(remaining==2)
                    {
                        circle4.setVisibility(view.INVISIBLE);
                        circle3.setVisibility(view.INVISIBLE);
                        circle1.setVisibility(view.INVISIBLE);
                    }
                    if(remaining==1)
                    {
                        circle4.setVisibility(view.INVISIBLE);
                        circle3.setVisibility(view.INVISIBLE);
                        circle1.setVisibility(view.INVISIBLE);
                        circle2.setVisibility(view.INVISIBLE);

                    }

                    remaining--;
                    visited++;
                   // Toast t=Toast.makeText(getApplicationContext(),"Enjoy your trip!",Toast.LENGTH_SHORT);
                    //t.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                   // t.show();
                    rem.setText(String.valueOf(remaining));
                    vis.setText(String.valueOf(visited));

                }
                else
                {
                    circle4.setVisibility(view.INVISIBLE);
                    circle3.setVisibility(view.INVISIBLE);
                    circle1.setVisibility(view.INVISIBLE);
                    circle2.setVisibility(view.INVISIBLE);
                    Toast t2=Toast.makeText(getApplicationContext(),"No Passes left! Try next month.",Toast.LENGTH_SHORT);
                    t2.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                    t2.show();
                }


            }
        });


        ImageView log=(ImageView)findViewById(R.id.logoutbutton);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Account.this,Login.class);


                editor.putString("logout","1");
                editor.putString("cashspent","0");
                editor.putString("disabled","0");
                editor.commit();
                startActivity(i);

            }
        });

        ImageView c=(ImageView)findViewById(R.id.managecash);

        c.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                editor.putString("cashspent","0");
                editor.commit();
                Toast.makeText(getApplicationContext(),"Cash spent reset to Rs 0/-",Toast.LENGTH_SHORT).show();

                return true;
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Account.this);

                final EditText input = new EditText(Account.this);
                input.setInputType(InputType.TYPE_CLASS_PHONE);

                builder.setCancelable(false).setPositiveButton("Spend", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
                        int abc;
                        abc=Integer.parseInt(prefs.getString("cashspent",input.getText().toString()));
                        abc=abc+Integer.parseInt(input.getText().toString());
                        editor.putString("cashspent", String.valueOf(abc));
                        editor.commit();
                        Toast.makeText(getApplicationContext(),"Rs "+prefs.getString("cashspent","203")+"/-",Toast.LENGTH_SHORT).show();


                        if(abc>Integer.parseInt(prefs.getString("cashlimit","100")))
                        {
                            speakOut("You have exceeded your limits. Please control");
                        }



                        // User clicked OK button
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                builder.setTitle("Spend Cash");

                AlertDialog dialog = builder.create();
                dialog.setIcon(R.drawable.cash);
                dialog.setView(input);


                dialog.show();
                input.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                input.setHint("Spent cash");





                // Toast.makeText(getApplicationContext(),"Cash left:  "+cash+ "/-",Toast.LENGTH_SHORT).show();
            }
        });

        ImageView c2=(ImageView)findViewById(R.id.settings123);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2=new Intent(Account.this,settings.class);
               // i2.putExtra("password",password123);
                startActivity(i2);
            }
        });







        username.setText(prefs.getString("username","admin"));

        if(prefs.getString("NMIMS","0").equals("1"))
        {
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
            t4.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE);
            t6.setVisibility(View.VISIBLE);
            rem.setVisibility(View.VISIBLE);
            vis.setVisibility(View.VISIBLE);
            plane.setVisibility(View.VISIBLE);

        }
        if(prefs.getString("NMIMS","0").equals("0"))
        {
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
            t6.setVisibility(View.INVISIBLE);
            t5.setVisibility(View.INVISIBLE);
            rem.setVisibility(View.INVISIBLE);
            vis.setVisibility(View.INVISIBLE);
            plane.setVisibility(View.INVISIBLE);

        }

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                //speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }



    private void speakOut(String s) {

        tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("viewcomments Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}
