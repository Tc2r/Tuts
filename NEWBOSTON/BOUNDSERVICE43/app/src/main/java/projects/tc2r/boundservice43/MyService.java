package projects.tc2r.boundservice43;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder tcBinder = new MyLocalBinder();

    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
       return tcBinder;
    }
    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }


    // Whenever you want to bind an Object to a client, you must Extend binder
    public class MyLocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }

    }
}
