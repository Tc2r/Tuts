package projects.tc2r.intents35;
//THENEWBOSTON - sending data with Intents!
//https://www.youtube.com/watch?v=mPGCLKRCG-8
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Apples extends AppCompatActivity {

    private Button applesButton;
    private TextView applesText;
    private String combine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);
        applesButton = (Button) findViewById(R.id.applesButton);
        applesText = (TextView) findViewById(R.id.applesText);
        Bundle baconData = getIntent().getExtras();
        if(baconData == null){
            return;
        }
        String baconMessage = baconData.getString("baconMessage");
        combine = baconMessage + " " + applesText.getText().toString();
        applesText.setText(combine);
    }
    public void onClicks(View view){
        Intent i = new Intent(this, Bacon.class);
        String userMessage = applesText.getText().toString();
        i.putExtra("appleMessage", userMessage);
        startActivity(i);
        finish();
    }
}
