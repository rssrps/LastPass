package com.example.raman.lastpass_project;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Locale;

import static com.example.raman.lastpass_project.R.id.girl;

public class viewcomments extends AppCompatActivity implements TextToSpeech.OnInitListener {

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
        setContentView(R.layout.activity_viewcomments);


        tts = new TextToSpeech(this,this);
        tts.setPitch((float) 1.300);

        SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);
        final TextView un1 = (TextView) findViewById(R.id.un1);
        final TextView comm1 = (TextView) findViewById(R.id.comm1);
        final TextView nocomm = (TextView) findViewById(R.id.nocomm);
        final ImageView girl=(ImageView)findViewById(R.id.girl);

        girl.setImageResource(R.drawable.callgirl);
        girl.setVisibility(View.INVISIBLE);
        girl.setOnTouchListener(new View.OnTouchListener() {

            private static final int MAX_CLICK_DURATION = 10;
            private long startClickTime;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();
                        girl.setVisibility(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        startClickTime = Calendar.getInstance().getTimeInMillis();
                        girl.setVisibility(View.INVISIBLE);
                        break;

                    case MotionEvent.ACTION_UP: {
                        long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                        if (clickDuration < MAX_CLICK_DURATION) {
                            girl.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();  //click event has occurred
                        }
                    }
                        break;
                    default:girl.setVisibility(View.INVISIBLE);
                        return false;
                }
                return true;
            }
        });


        nocomm.setVisibility(View.INVISIBLE);
        final ImageView delete1 = (ImageView) findViewById(R.id.delete1);

        if (prefs.getString("commentdeleted", "0").equals("0")) {
            un1.setVisibility(View.VISIBLE);
            comm1.setVisibility(View.VISIBLE);
            delete1.setVisibility(View.VISIBLE);
            nocomm.setVisibility(View.INVISIBLE);
        }

        if (prefs.getString("commentdeleted", "0").equals("1")) {
            un1.setVisibility(View.INVISIBLE);
            comm1.setVisibility(View.INVISIBLE);
            delete1.setVisibility(View.INVISIBLE);
            nocomm.setVisibility(View.VISIBLE);
        }


        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                un1.setVisibility(View.INVISIBLE);
                comm1.setVisibility(View.INVISIBLE);
                delete1.setVisibility(View.INVISIBLE);
                nocomm.setVisibility(View.VISIBLE);


                speakOut("Comment deleted");

                SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
                editor.putString("commentdeleted", "1");
                editor.commit();
            }
        });


        un1.setText(prefs.getString("username", "Username"));
        comm1.setText(prefs.getString("actual_comment", "Test comment"));

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
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
