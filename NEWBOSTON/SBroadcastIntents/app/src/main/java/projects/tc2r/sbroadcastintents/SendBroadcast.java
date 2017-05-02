package projects.tc2r.sbroadcastintents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SendBroadcast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_broadcast);
    }


    // Sends out a broadcast into the device to be recived by other apps
    public void sendOutBroadcast(View view){
        Intent i = new Intent();
        // Sets the keyword for the broadcast
        i.setAction("projects.tc2r.sbroadcastintents");
        //Always have Flag_Include etc
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);

    }
}
