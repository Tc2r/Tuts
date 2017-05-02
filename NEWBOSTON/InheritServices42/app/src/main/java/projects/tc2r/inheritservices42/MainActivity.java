package projects.tc2r.inheritservices42;
//THENEWBOSTON SERVICE TUTORIAL 42

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tcText;
    private Button tcButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    tcText = (TextView) findViewById(R.id.tcTextView);
    tcButton = (Button) findViewById(R.id.tcButton);
        Intent i = new Intent(this, MyService.class);
        startService(i);


}
    public void onClicky(View view){
        tcText.setText("I HAVE BEEN CLICKED");


    }
}
