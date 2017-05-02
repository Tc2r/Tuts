package projects.tc2r.notifications61;
/*
*THENEWBOSTON Notifications Tutorial 61
*https://www.youtube.com/watch?v=SWsuijO5NGE&spfreload=5
 */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;

    //Each notification must have its own ID
    private static final int uniqueID = 84961;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }
    public void tcButtonClicked(View view){
        // Build the Notification

        // set icon
        notification.setSmallIcon(R.mipmap.ic_launcher);

        // set ticker
        notification.setTicker("This is the ticker");

        // set time
        notification.setWhen(System.currentTimeMillis());

        // set the title
        notification.setContentTitle("Here title");

        // set the message of notification
        notification.setContentText("I am the body text of your notification");

        // set action once clicked
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        // set Notification Sound
        notification.setSound(RingtoneManager.getActualDefaultRingtoneUri(this, RingtoneManager.TYPE_NOTIFICATION));

        notification.setNumber(3);
        notification.setLights(Color.CYAN,2000,1000);
        // led here is on for 2 seconds, off for 1 second.
        // Builds adn Issues (sends it out) notification using Notification manager.
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }
}
