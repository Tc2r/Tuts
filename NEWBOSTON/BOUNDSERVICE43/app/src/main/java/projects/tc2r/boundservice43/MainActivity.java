package projects.tc2r.boundservice43;
//THENEWBOSTON - BOUND SERVICES TUTORIAL 43
//https://www.youtube.com/watch?v=0c4jRCm353c
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import projects.tc2r.boundservice43.MyService.MyLocalBinder;
import android.content.ServiceConnection;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyService tcService;
    boolean isBound = false;

    public void showTime(View view){
        String currentTime = tcService.getCurrentTime();
        TextView timeText = (TextView) findViewById(R.id.timeText);
        timeText.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);
        bindService(i,tcConnection, Context.BIND_AUTO_CREATE);

    }

    private ServiceConnection tcConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;
            tcService = binder.getService();

            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
}
