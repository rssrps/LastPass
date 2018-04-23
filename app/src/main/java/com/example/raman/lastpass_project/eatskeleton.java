package com.example.raman.lastpass_project;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;


public class eatskeleton extends AppCompatActivity implements TextToSpeech.OnInitListener {

    int countheart=0;
    int photocount=0;
    String number;
    int favouritecount;
    int totalrating=0;
    int ratingcount=0;
    int hintcounter=0;

    GoogleApiClient client;


    private TextToSpeech tts;

    private float xCoOrdinate, yCoOrdinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eatskeleton);

        final SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);

        final ImageView ratingfixed=(ImageView)findViewById(R.id.ratingfixed);
        final ImageView heart=(ImageView)findViewById(R.id.heart);

        TextView n=(TextView)findViewById(R.id.name);
        TextView a=(TextView)findViewById(R.id.address);
        TextView p=(TextView)findViewById(R.id.phone);
        TextView time=(TextView)findViewById(R.id.timings);
        final TextView ratingnumber=(TextView)findViewById(R.id.ratingnumber);
        Button addareview=(Button)findViewById(R.id.addreview);
        Button viewcomm=(Button)findViewById(R.id.viewcomm);
        final Button rate=(Button)findViewById(R.id.rate);


        ImageView right=(ImageView) findViewById(R.id.righticon);
        ImageView left=(ImageView)findViewById(R.id.lefticon);
        final ImageView photo=(ImageView)findViewById(R.id.photo);
        ImageView clock=(ImageView)findViewById(R.id.cloclicon);
        TextView opennow=(TextView)findViewById(R.id.opennow);




        tts = new TextToSpeech(this,this);
        tts.setPitch((float) 1.300);



        final ImageView girl_skeleton=(ImageView)findViewById(R.id.girlskeleton);
        girl_skeleton.setImageResource(R.drawable.callgirl);

        if(prefs.getString("disabled","0").equals("1"))
        {
            girl_skeleton.setVisibility(View.INVISIBLE);
        }




        girl_skeleton.setOnTouchListener(new View.OnTouchListener() {

            private static final int MAX_CLICK_DURATION = 10;
            private long startClickTime;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - motionEvent.getRawX();
                        yCoOrdinate = view.getY() - motionEvent.getRawY();
                        //startClickTime = Calendar.getInstance().getTimeInMillis();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(motionEvent.getRawX() + xCoOrdinate).y(motionEvent.getRawY() + yCoOrdinate).setDuration(0).start();
                        startClickTime = Calendar.getInstance().getTimeInMillis();
                        break;
                    case MotionEvent.ACTION_UP: {
                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                        if(clickDuration < MAX_CLICK_DURATION) {

                            hintcounter=(hintcounter+1)%5 ;

                            if(hintcounter==1)
                                speakOut("Long hold picture button to like.");
                            if(hintcounter==2)
                                speakOut("Use left icon right icon to browse photo gallery");
                            if(hintcounter==3)
                                speakOut("Rate this place using the rate button");
                            if(hintcounter==4)
                                speakOut("you can provide your experience Using add a review button.");
                            if(hintcounter==0)
                                speakOut("View all comments by clicking view comments icon.");


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



        final Bundle b2=getIntent().getExtras();

        if(b2.getString("id").equals("1"))
            photo.setImageResource(R.drawable.chocolicious1);
        if(b2.getString("id").equals("2"))
            photo.setImageResource(R.drawable.hangout1);
        if(b2.getString("id").equals("3"))
            photo.setImageResource(R.drawable.bharkadevi1);
        if(b2.getString("id").equals("4"))
            photo.setImageResource(R.drawable.noimagefound);
        if(b2.getString("id").equals("5"))
            photo.setImageResource(R.drawable.noimagefound);
        if(b2.getString("id").equals("6"))
            photo.setImageResource(R.drawable.saheba1);
        if(b2.getString("id").equals("7"))
            photo.setImageResource(R.drawable.royalcake1);
        if(b2.getString("id").equals("8"))
            photo.setImageResource(R.drawable.jainbakery1);


        if(b2.getString("id").equals("20"))
            photo.setImageResource(R.drawable.guruply1);
        if(b2.getString("id").equals("21"))
            photo.setImageResource(R.drawable.ramhardware1);
        if(b2.getString("id").equals("22"))
            photo.setImageResource(R.drawable.royaltouch1);
        if(b2.getString("id").equals("23"))
            photo.setImageResource(R.drawable.noimagefound);
        if(b2.getString("id").equals("24"))
            photo.setImageResource(R.drawable.ajinkyamedical1);
        if(b2.getString("id").equals("25"))
            photo.setImageResource(R.drawable.gajananmedical1);


        if(b2.getString("id").equals("31"))
            photo.setImageResource(R.drawable.hotelsairaj1);
        if(b2.getString("id").equals("32"))
            photo.setImageResource(R.drawable.malhar1);
        if(b2.getString("id").equals("33"))
            photo.setImageResource(R.drawable.shalimar1);



        if(b2.getString("id").equals("41"))
            photo.setImageResource(R.drawable.noimagefound);
        if(b2.getString("id").equals("42"))
            photo.setImageResource(R.drawable.noimagefound);
        if(b2.getString("id").equals("43"))
            photo.setImageResource(R.drawable.noimagefound);
        if(b2.getString("id").equals("44"))
            photo.setImageResource(R.drawable.noimagefound);



        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countheart++;
                if(countheart%2==1) {
                    heart.setImageResource(R.drawable.heartred);
                    Vibrator v = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                    // Vibrate for 500 milliseconds
                    v.vibrate(200);
                    speakOut("Added to favourites.");

                  //  editor.putString("favouritecount","200");
                    favouritecount=Integer.parseInt(prefs.getString("favouritecount","700"));
                    editor.putString(String.valueOf(favouritecount),b2.getString("name"));
                    favouritecount=favouritecount+1;

                    if(favouritecount>202)
                        favouritecount=200;

                    editor.putString("favouritecount",String.valueOf(favouritecount));
                    editor.putString("flush","0");

                    editor.commit();

                }
                else {
                    heart.setImageResource(R.drawable.heartwhite);
                }
                if(countheart%2==1)
                Toast.makeText(getApplicationContext(),"Added to favourites",Toast.LENGTH_SHORT).show();


            }
        });




        photo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                countheart++;
                if(countheart%2==1) {
                    heart.setImageResource(R.drawable.heartred);
                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        // Vibrate for 400 milliseconds
                    v.vibrate(200);
                    speakOut("Added to favourites.");
                    favouritecount=Integer.parseInt(prefs.getString("favouritecount","700"));
                    editor.putString(String.valueOf(favouritecount),b2.getString("name"));
                    favouritecount=(favouritecount+1)%3;
                    editor.putString("favouritecount",String.valueOf(favouritecount));

                    editor.commit();

                }
                else {

                    heart.setImageResource(R.drawable.heartwhite);
                }
                if(countheart%2==1)
                    Toast.makeText(getApplicationContext(),"Added to favourites",Toast.LENGTH_SHORT).show();
                return true;
            }
        });




        final Bundle bundle = getIntent().getExtras();


        n.setText(bundle.getString("name"));
        a.setText(bundle.getString("address"));
        p.setText(bundle.getString("phone"));
        number=bundle.getString("phone");
        time.setText(bundle.getString("timing"));

        if(bundle.getString("id").equals("31")||bundle.getString("id").equals("32")||bundle.getString("id").equals("33"))
        {
                time.setVisibility(View.INVISIBLE);
                opennow.setVisibility(View.INVISIBLE);
                clock.setVisibility(View.INVISIBLE);
        }


        if(bundle.getString("id").equals("41")||bundle.getString("id").equals("42")||bundle.getString("id").equals("43")||bundle.getString("id").equals("44"))
        {
            time.setVisibility(View.INVISIBLE);
            opennow.setVisibility(View.INVISIBLE);
            clock.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
            right.setVisibility(View.INVISIBLE);
            ratingnumber.setVisibility(View.INVISIBLE);
            heart.setVisibility(View.INVISIBLE);
            addareview.setVisibility(View.INVISIBLE);
            viewcomm.setVisibility(View.INVISIBLE);
            rate.setVisibility(View.INVISIBLE);
            ratingfixed.setVisibility(View.INVISIBLE);

        }

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b1=getIntent().getExtras();
                photocount= (photocount+1)%3;



                if(b1.getString("id").equals("1")&&photocount==0)
                    photo.setImageResource(R.drawable.chocolicious1);
                if(b1.getString("id").equals("1")&&photocount==1)
                    photo.setImageResource(R.drawable.chocolicious2);
                if(b1.getString("id").equals("1")&&photocount==2)
                    photo.setImageResource(R.drawable.chocolicious3);


                if(b1.getString("id").equals("2")&&photocount==0)
                    photo.setImageResource(R.drawable.hangout1);
                if(b1.getString("id").equals("2")&&photocount==1)
                    photo.setImageResource(R.drawable.hangout2);
                if(b1.getString("id").equals("2")&&photocount==2)
                    photo.setImageResource(R.drawable.hangout3);


                if(b1.getString("id").equals("3")&&photocount==0)
                    photo.setImageResource(R.drawable.bharkadevi1);
                if(b1.getString("id").equals("3")&&photocount==1)
                    photo.setImageResource(R.drawable.bharkadevi2);
                if(b1.getString("id").equals("3")&&photocount==2)
                    photo.setImageResource(R.drawable.bharkadevi3);


                if(b1.getString("id").equals("4")&&photocount==0)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("4")&&photocount==1)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("4")&&photocount==2)
                    photo.setImageResource(R.drawable.noimagefound);


                if(b1.getString("id").equals("5")&&photocount==0)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("5")&&photocount==1)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("5")&&photocount==2)
                    photo.setImageResource(R.drawable.noimagefound);


                if(b1.getString("id").equals("6")&&photocount==0)
                    photo.setImageResource(R.drawable.saheba1);
                if(b1.getString("id").equals("6")&&photocount==1)
                    photo.setImageResource(R.drawable.saheba2);
                if(b1.getString("id").equals("6")&&photocount==2)
                    photo.setImageResource(R.drawable.saheba3);


                if(b1.getString("id").equals("7")&&photocount==0)
                    photo.setImageResource(R.drawable.royalcake1);
                if(b1.getString("id").equals("7")&&photocount==1)
                    photo.setImageResource(R.drawable.royalcake2);
                if(b1.getString("id").equals("7")&&photocount==2)
                    photo.setImageResource(R.drawable.royalcake3);


                if(b1.getString("id").equals("8")&&photocount==0)
                    photo.setImageResource(R.drawable.jainbakery1);
                if(b1.getString("id").equals("8")&&photocount==1)
                    photo.setImageResource(R.drawable.jainbakery2);
                if(b1.getString("id").equals("8")&&photocount==2)
                    photo.setImageResource(R.drawable.jainbakery3);




                if(b1.getString("id").equals("20")&&photocount==0)
                    photo.setImageResource(R.drawable.guruply1);
                if(b1.getString("id").equals("20")&&photocount==1)
                    photo.setImageResource(R.drawable.guruply2);
                if(b1.getString("id").equals("20")&&photocount==2)
                    photo.setImageResource(R.drawable.guruply3);


                if(b1.getString("id").equals("21")&&photocount==0)
                    photo.setImageResource(R.drawable.ramhardware1);
                if(b1.getString("id").equals("21")&&photocount==1)
                    photo.setImageResource(R.drawable.ramhardware2);
                if(b1.getString("id").equals("21")&&photocount==2)
                    photo.setImageResource(R.drawable.ramhardware3);


                if(b1.getString("id").equals("22")&&photocount==0)
                    photo.setImageResource(R.drawable.royaltouch1);
                if(b1.getString("id").equals("22")&&photocount==1)
                    photo.setImageResource(R.drawable.royaltouch2);
                if(b1.getString("id").equals("22")&&photocount==2)
                    photo.setImageResource(R.drawable.royaltouch3);


                if(b1.getString("id").equals("23")&&photocount==0)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("23")&&photocount==1)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("23")&&photocount==2)
                    photo.setImageResource(R.drawable.noimagefound);


                if(b1.getString("id").equals("24")&&photocount==0)
                    photo.setImageResource(R.drawable.ajinkyamedical1);
                if(b1.getString("id").equals("24")&&photocount==1)
                    photo.setImageResource(R.drawable.ajinkyamedical2);
                if(b1.getString("id").equals("24")&&photocount==2)
                    photo.setImageResource(R.drawable.ajinkyamedical3);


                if(b1.getString("id").equals("25")&&photocount==0)
                    photo.setImageResource(R.drawable.gajananmedical1);
                if(b1.getString("id").equals("25")&&photocount==1)
                    photo.setImageResource(R.drawable.gajananmedical2);
                if(b1.getString("id").equals("25")&&photocount==2)
                    photo.setImageResource(R.drawable.gajananmedical3);









                if(b1.getString("id").equals("31")&&photocount==0)
                    photo.setImageResource(R.drawable.hotelsairaj1);
                if(b1.getString("id").equals("31")&&photocount==1)
                    photo.setImageResource(R.drawable.hotelsairaj2);
                if(b1.getString("id").equals("31")&&photocount==2)
                    photo.setImageResource(R.drawable.hotelsairaj3);


                if(b1.getString("id").equals("32")&&photocount==0)
                    photo.setImageResource(R.drawable.malhar1);
                if(b1.getString("id").equals("32")&&photocount==1)
                    photo.setImageResource(R.drawable.malhar2);
                if(b1.getString("id").equals("32")&&photocount==2)
                    photo.setImageResource(R.drawable.malhar3);


                if(b1.getString("id").equals("33")&&photocount==0)
                    photo.setImageResource(R.drawable.shalimar1);
                if(b1.getString("id").equals("33")&&photocount==1)
                    photo.setImageResource(R.drawable.shalimar2);
                if(b1.getString("id").equals("33")&&photocount==2)
                    photo.setImageResource(R.drawable.shalimar3);




            }
        });






        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b1=getIntent().getExtras();
                if(photocount!=0)
                photocount= (photocount-1)%3;
                else
                photocount=2;

                if(b1.getString("id").equals("1")&&photocount==0)
                    photo.setImageResource(R.drawable.chocolicious1);
                if(b1.getString("id").equals("1")&&photocount==1)
                    photo.setImageResource(R.drawable.chocolicious2);
                if(b1.getString("id").equals("1")&&photocount==2)
                    photo.setImageResource(R.drawable.chocolicious3);


                if(b1.getString("id").equals("2")&&photocount==0)
                    photo.setImageResource(R.drawable.hangout1);
                if(b1.getString("id").equals("2")&&photocount==1)
                    photo.setImageResource(R.drawable.hangout2);
                if(b1.getString("id").equals("2")&&photocount==2)
                    photo.setImageResource(R.drawable.hangout3);


                if(b1.getString("id").equals("3")&&photocount==0)
                    photo.setImageResource(R.drawable.bharkadevi1);
                if(b1.getString("id").equals("3")&&photocount==1)
                    photo.setImageResource(R.drawable.bharkadevi2);
                if(b1.getString("id").equals("3")&&photocount==2)
                    photo.setImageResource(R.drawable.bharkadevi3);


                if(b1.getString("id").equals("4")&&photocount==0)
                    photo.setImageResource(R.drawable.chocolicious1);
                if(b1.getString("id").equals("4")&&photocount==1)
                    photo.setImageResource(R.drawable.chocolicious2);
                if(b1.getString("id").equals("4")&&photocount==2)
                    photo.setImageResource(R.drawable.chocolicious3);


                if(b1.getString("id").equals("5")&&photocount==0)
                    photo.setImageResource(R.drawable.chocolicious1);
                if(b1.getString("id").equals("5")&&photocount==1)
                    photo.setImageResource(R.drawable.chocolicious2);
                if(b1.getString("id").equals("5")&&photocount==2)
                    photo.setImageResource(R.drawable.chocolicious3);


                if(b1.getString("id").equals("6")&&photocount==0)
                    photo.setImageResource(R.drawable.saheba1);
                if(b1.getString("id").equals("6")&&photocount==1)
                    photo.setImageResource(R.drawable.saheba2);
                if(b1.getString("id").equals("6")&&photocount==2)
                    photo.setImageResource(R.drawable.saheba3);


                if(b1.getString("id").equals("7")&&photocount==0)
                    photo.setImageResource(R.drawable.royalcake1);
                if(b1.getString("id").equals("7")&&photocount==1)
                    photo.setImageResource(R.drawable.royalcake2);
                if(b1.getString("id").equals("7")&&photocount==2)
                    photo.setImageResource(R.drawable.royalcake3);


                if(b1.getString("id").equals("8")&&photocount==0)
                    photo.setImageResource(R.drawable.jainbakery1);
                if(b1.getString("id").equals("8")&&photocount==1)
                    photo.setImageResource(R.drawable.jainbakery2);
                if(b1.getString("id").equals("8")&&photocount==2)
                    photo.setImageResource(R.drawable.jainbakery3);








                if(b1.getString("id").equals("20")&&photocount==0)
                    photo.setImageResource(R.drawable.guruply1);
                if(b1.getString("id").equals("20")&&photocount==1)
                    photo.setImageResource(R.drawable.guruply2);
                if(b1.getString("id").equals("20")&&photocount==2)
                    photo.setImageResource(R.drawable.guruply3);


                if(b1.getString("id").equals("21")&&photocount==0)
                    photo.setImageResource(R.drawable.ramhardware1);
                if(b1.getString("id").equals("21")&&photocount==1)
                    photo.setImageResource(R.drawable.ramhardware2);
                if(b1.getString("id").equals("21")&&photocount==2)
                    photo.setImageResource(R.drawable.ramhardware3);


                if(b1.getString("id").equals("22")&&photocount==0)
                    photo.setImageResource(R.drawable.royaltouch1);
                if(b1.getString("id").equals("22")&&photocount==1)
                    photo.setImageResource(R.drawable.royaltouch2);
                if(b1.getString("id").equals("22")&&photocount==2)
                    photo.setImageResource(R.drawable.royaltouch3);


                if(b1.getString("id").equals("23")&&photocount==0)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("23")&&photocount==1)
                    photo.setImageResource(R.drawable.noimagefound);
                if(b1.getString("id").equals("23")&&photocount==2)
                    photo.setImageResource(R.drawable.noimagefound);


                if(b1.getString("id").equals("24")&&photocount==0)
                    photo.setImageResource(R.drawable.ajinkyamedical1);
                if(b1.getString("id").equals("24")&&photocount==1)
                    photo.setImageResource(R.drawable.ajinkyamedical2);
                if(b1.getString("id").equals("24")&&photocount==2)
                    photo.setImageResource(R.drawable.ajinkyamedical3);


                if(b1.getString("id").equals("25")&&photocount==0)
                    photo.setImageResource(R.drawable.gajananmedical1);
                if(b1.getString("id").equals("25")&&photocount==1)
                    photo.setImageResource(R.drawable.gajananmedical2);
                if(b1.getString("id").equals("25")&&photocount==2)
                    photo.setImageResource(R.drawable.gajananmedical3);




                if(b1.getString("id").equals("31")&&photocount==0)
                    photo.setImageResource(R.drawable.hotelsairaj1);
                if(b1.getString("id").equals("31")&&photocount==1)
                    photo.setImageResource(R.drawable.hotelsairaj2);
                if(b1.getString("id").equals("31")&&photocount==2)
                    photo.setImageResource(R.drawable.hotelsairaj3);


                if(b1.getString("id").equals("32")&&photocount==0)
                    photo.setImageResource(R.drawable.malhar1);
                if(b1.getString("id").equals("32")&&photocount==1)
                    photo.setImageResource(R.drawable.malhar2);
                if(b1.getString("id").equals("32")&&photocount==2)
                    photo.setImageResource(R.drawable.malhar3);


                if(b1.getString("id").equals("33")&&photocount==0)
                    photo.setImageResource(R.drawable.shalimar1);
                if(b1.getString("id").equals("33")&&photocount==1)
                    photo.setImageResource(R.drawable.shalimar2);
                if(b1.getString("id").equals("33")&&photocount==2)
                    photo.setImageResource(R.drawable.shalimar3);




            }
        });





        addareview.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(eatskeleton.this);

                final EditText input = new EditText(eatskeleton.this);

                builder.setCancelable(false).setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Toast.makeText(getApplicationContext(),"Comment added!", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
                        editor.putString("actual_comment", input.getText().toString());
                        editor.putString("commentdeleted","0");
                        editor.commit();

                        // User clicked OK button
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                builder.setTitle("User Review");

                AlertDialog dialog = builder.create();
                dialog.setIcon(R.drawable.comment);
                dialog.setView(input);


                dialog.show();
                input.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                input.setHint("comment");





            }


        });





        viewcomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(eatskeleton.this,viewcomments.class);
                startActivity(i1);

            }
        });






        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(eatskeleton.this);
                final RatingBar rating = new RatingBar(eatskeleton.this);
                rating.setMax(5);
                rating.setNumStars(5);
                rating.setStepSize(1);
                builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Toast.makeText(getApplicationContext(),"Thank you for rating!", Toast.LENGTH_SHORT).show();
                        ratingcount=ratingcount+1;
                        totalrating=totalrating+ (rating.getNumStars())%5;
                       // ratingnumber.setText(String.valueOf(totalrating/ratingcount));

                        // User clicked OK button

                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                builder.setTitle("Rate");
                AlertDialog dialog = builder.create();


                dialog.setView(rating);




                dialog.show();
            }
        });





        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            try{
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+number));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }catch(ActivityNotFoundException activityException) {
                        Log.e("Calling a Phone Number", "Call failed", activityException);
                    }
                }

        });


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
