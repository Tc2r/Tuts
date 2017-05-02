package com.tc2r.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tutorial1 extends AppCompatActivity{
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String DEFAULT = "N/A";
    SharedPreferences sharedPreferences;
    EditText ed1, ed2, ed3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial1);

        ed1 = (EditText) findViewById(R.id.userName);
        ed2 = (EditText) findViewById(R.id.phone);
        ed3 = (EditText) findViewById(R.id.Email);

        b1 = (Button) findViewById(R.id.button_Save);
        if (sharedPreferences == null) {
            sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            Log.wtf("RAN", "RUNNING");
        }
        String savedName = sharedPreferences.getString(Name, DEFAULT);
        String savedPhone = sharedPreferences.getString(Phone, DEFAULT);
        String savedEmail = sharedPreferences.getString(Email, DEFAULT);
        Log.wtf("DEFAULT", savedName);
        Log.wtf("DEFAULT", DEFAULT);
        if(!savedName.equals(DEFAULT)){
            Toast.makeText(this, "SAVED", Toast.LENGTH_LONG).show();
            ed1.setText(savedName);
            ed2.setText(savedPhone);
            ed3.setText(savedEmail);
        }

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String n = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                Log.wtf("Name", n);

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.commit();
                Toast.makeText(Tutorial1.this, "Thanks", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        // no inspection SimplifiableStatement
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
