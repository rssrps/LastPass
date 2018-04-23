package com.example.raman.lastpass_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    String UN,PS;
Boolean sup=Boolean.FALSE;
Boolean NMIMS=Boolean.FALSE;
    int successfullogin=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);
        final CheckBox remember=(CheckBox)findViewById(R.id.remember);

        if(prefs.getString("logout","0").equals("0"))
        {
            Intent i2=new Intent(Login.this,Home.class);
            startActivity(i2);
        }


        final Switch NM=(Switch)findViewById(R.id.NM);
        Button login= (Button) findViewById(R.id.login);
        Button q=(Button)findViewById(R.id.quick);
        q.setVisibility(View.INVISIBLE);

       final EditText user= (EditText) findViewById(R.id.user);
        final EditText pass= (EditText) findViewById(R.id.pass);



        login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                editor.putString("currentusers","5000");
                editor.commit();
                return true;
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                final String U="admin",P="password";

                editor.putString("favouritecount","200");
                user.requestFocus();

                Intent i = new Intent(getApplicationContext(),Home.class);

                final String username,password;
                username=user.getText().toString();
                password=pass.getText().toString();


              /*  for(int mynumber=100;mynumber<180;mynumber=mynumber+1)
                {
                    if(username.equals(prefs.getString(String.valueOf(mynumber),"0")))
                    {
                        if(password.equals(prefs.getString(String.valueOf(mynumber*10),"0")))
                        {
                            Toast.makeText(getApplicationContext(),"working",Toast.LENGTH_SHORT).show();

                            editor.putString("logout","0");
                            editor.putString("username",username);
                            editor.putString("password",password);
                            editor.putString("disabled","0");
                            editor.putString("cashspent","0");
                            startActivity(i);
                            successfullogin=1;

                        }
                    }
                }
                */

                for(int newnum=5000;newnum<7000;newnum++)
                {
                    String storedUN=prefs.getString(String.valueOf(newnum),"5000");
                    String storedPS=prefs.getString(storedUN,"password");

                    if(username.equals(storedUN)&&password.equals(storedPS)) {
                        successfullogin=1;
                        startActivity(i);
                        //Toast.makeText(getApplicationContext(),"This is awesome!",Toast.LENGTH_SHORT).show();

                    }
                }


                if(sup)
                {
                    i.putExtra("message", username);
                    i.putExtra("password",password);
                    if( (username.equals(UN)&&password.equals(PS)) || (username.equals(U)&&password.equals(P)))
                    {
                        editor.putString("username", username);
                        editor.putString("cashspent","0");
                        editor.putString("logout","0");
                        startActivity(i);
                        successfullogin=1;
                        editor.apply();

                    }
                }
                else
                {
                    i.putExtra("message", username);
                    if(username.equals(U)&&password.equals(P))
                    {

                        editor.putString("username", username);
                        editor.putString("cashspent","0");
                        editor.putString("logout","0");
                        editor.apply();

                        if(remember.isChecked())
                            editor.putString(username,password);

                        startActivity(i);
                        successfullogin=1;
                    }
                }

                if(successfullogin==0)
                {
                    if(user.getText().toString().isEmpty())
                    {

                    }
                    else{

                    }
                    //Toast.makeText(getApplicationContext(),"Username or password incorrect!",Toast.LENGTH_SHORT).show();
                }

                user.setText("");
               pass.setText("");

            }
        });

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e1=(EditText)findViewById(R.id.user);
                EditText e2=(EditText)findViewById(R.id.pass);

                e1.setText("admin");
                e2.setText("password");
            }
        });

        Button signup= (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usernamesup= (EditText) findViewById(R.id.usernamesup);
                EditText passwordsup= (EditText) findViewById(R.id.passwordsup);
                EditText fname=(EditText) findViewById(R.id.firstname);
                EditText lname=(EditText) findViewById(R.id.lastname);
                EditText confirmpass=(EditText) findViewById(R.id.confirmpass);



                SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
                if(NM.isChecked())
                    editor.putString("NMIMS", "1");
                else
                    editor.putString("NMIMS","0");
                editor.commit();


                UN=usernamesup.getText().toString();
                PS=passwordsup.getText().toString();

                sup= true;

               // if(NM.isChecked())
                if(confirmpass.getText().toString().equals(PS)) {

                    Toast.makeText(Login.this, "Signup Success", Toast.LENGTH_LONG).show();

                    editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
                    SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);
                    editor.putString(prefs.getString("accountnumber","0"),UN);
                    int accountnumber=Integer.parseInt(prefs.getString("accountnumber","0"));
                    accountnumber=accountnumber*10;
                    editor.putString(String.valueOf(accountnumber),PS);
                    accountnumber=accountnumber/10;
                    accountnumber=accountnumber+1;
                    editor.putString("accountnumber",String.valueOf(accountnumber));

                    int totalusers=Integer.parseInt(prefs.getString("currentusers","5000"));
                    editor.putString(String.valueOf(totalusers),UN);
                    editor.putString(UN,PS);
                    totalusers=totalusers+1;
                    editor.putString("currentusers",String.valueOf(totalusers));
                    editor.commit();

                }
                else
                    Toast.makeText(Login.this,"Failed to sign up! ", Toast.LENGTH_LONG).show();


                usernamesup.setText("");
                passwordsup.setText("");
                fname.setText("");
                lname.setText("");
                confirmpass.setText("");

            }
        });

    }

    @Override
    public void onBackPressed() {

// make sure you have this outcommented
// super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
