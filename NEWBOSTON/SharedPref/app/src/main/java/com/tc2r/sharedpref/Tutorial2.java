package com.tc2r.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tutorial2 extends AppCompatActivity {

    EditText userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.phone);

    }

    public void Save(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", userName.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data was saved successfully ", Toast.LENGTH_LONG).show();
    }

    public void Next(View view) {
        Toast.makeText(this, "Next", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Tutorial2b.class);
        startActivity(intent);
    }
}
