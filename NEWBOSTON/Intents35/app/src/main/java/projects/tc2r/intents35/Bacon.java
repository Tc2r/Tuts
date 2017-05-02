package projects.tc2r.intents35;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Bacon extends AppCompatActivity {

    private TextView baconText;
    private String combine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);
        baconText = (TextView) findViewById(R.id.baconText);
        Bundle applesData = getIntent().getExtras();
        if(applesData == null) {
            return;
        }
        String appleMessage = applesData.getString("appleMessage");
        combine = appleMessage + " " + baconText.getText().toString();
        baconText.setText(combine);
    }
    public void onClicks(View view){
        Intent i = new Intent(this, Apples.class);
        String userMessage = baconText.getText().toString();
        i.putExtra("baconMessage", userMessage);
        startActivity(i);
        finish();
    }
}
