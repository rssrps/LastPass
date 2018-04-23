package com.example.raman.lastpass_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class settings extends AppCompatActivity {
String cur,newpass,limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final EditText e1=(EditText)findViewById(R.id.current);
        final EditText e3=(EditText)findViewById(R.id.cashlimit);
        final EditText e2=(EditText)findViewById(R.id.newpassword);

        final SharedPreferences.Editor editor = getSharedPreferences("pref1", MODE_PRIVATE).edit();
        final SharedPreferences prefs = getSharedPreferences("pref1", MODE_PRIVATE);

        Bundle b3 = getIntent().getExtras();
       // final String password123=b3.getString("password");


        Button change=(Button)findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override



            public void onClick(View view) {
                cur=e1.getText().toString();
                newpass=e2.getText().toString();

                if(cur.equals(prefs.getString("password",""))) {

                    if (cur.equals(newpass))
                    {
                        Toast.makeText(getApplicationContext(), "Current and new password can't be same!", Toast.LENGTH_LONG).show();
                        e2.setText("");
                        e1.setText("");
                    } else
                    {

                        Toast.makeText(getApplicationContext(), "Password change successful!", Toast.LENGTH_LONG).show();
                        e2.setText("");
                        e1.setText("");
                        editor.putString("password",e1.getText().toString());

                    }

                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Incorrect password!",Toast.LENGTH_SHORT).show();

                }
            }

        });


        Button b5=(Button)findViewById(R.id.set);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Cash Limit set to "+e3.getText().toString()+"/-", Toast.LENGTH_LONG).show();
                editor.putString("cashlimit",e3.getText().toString());
                e3.setText("");
                editor.commit();
                Intent i=new Intent(settings.this,Account.class);
                startActivity(i);

            }
        });



    }
}
