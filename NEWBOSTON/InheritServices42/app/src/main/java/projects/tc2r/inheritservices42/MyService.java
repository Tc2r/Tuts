package projects.tc2r.inheritservices42;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public static final String TAG = "projects.tc2r.inheritservices42";

    public MyService() {
    }

    //whatever you want service to do goes here
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand method Called");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 5; i++) {
                    long futuretime = System.currentTimeMillis() + 2000;
                    while (System.currentTimeMillis() < futuretime) {
                        synchronized (this) {
                            try {
                                wait(futuretime - System.currentTimeMillis());
                                Log.i(TAG, "SERVICE IS DOING STUFF");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
//
//                     Context context = getApplicationContext();
//                     Toast t = Toast.makeText(context,"HI I AM HERE",Toast.LENGTH_SHORT);
//                     t.show();
                }


            }
        };

        Thread tcThread = new Thread(r);
        tcThread.start();
        //Start Sticky = if your service is destroyed, it will restart automatically
        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy method Called");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
