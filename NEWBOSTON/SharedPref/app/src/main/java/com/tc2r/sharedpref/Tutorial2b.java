package com.tc2r.sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tutorial2b extends AppCompatActivity {
    TextView userName, pass;
    Button load, previous;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2b);
        userName = (TextView)findViewById(R.id.TV_UserName);
        pass = (TextView)findViewById(R.id.TV_Password);

        load = (Button) findViewById(R.id.B_Load);
        previous = (Button) findViewById(R.id.B_Previous);
    }
    public void Load(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", DEFAULT);
        String password = sharedPreferences.getString("password", DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Data Found", Toast.LENGTH_LONG).show();
            userName.setText(name);
            pass.setText(password);

        }

    }
    public void Previous(View view) {
        Intent intent = new Intent(this, Tutorial2.class);
        startActivity(intent);
    }
}
