package projects.tc2r.intentservice41;
//THENEWBOSTON INTENT SERVICE 41
//https://www.youtube.com/watch?v=-sBxmjrSn34
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
         intent = new Intent(this,TcIntentService.class);
        startService(intent);

    }
    public void onClicky(View view){
        tcText.setText("I HAVE BEEN CLICKED");
        stopService(intent);

    }
}
