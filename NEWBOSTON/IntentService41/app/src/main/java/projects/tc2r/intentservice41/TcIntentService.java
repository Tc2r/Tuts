package projects.tc2r.intentservice41;
//RULES OF INTENT SERVICE
//1 NEED TO HAVE A CONSTRUCTOR
//2 NEED TO HAVE A METHOD CALLED "onHandleIntent"
//3 INTENT SERVICE AUTOMATICALLY CREATES A THREAD FOR YOU.

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class TcIntentService extends IntentService{

    private static final String TAG = "Tc2r.intentservice41";
    public TcIntentService() {
        //THIS IS JUST HOUSEKEEPING STUFF
        super("TcIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // this is what the service does (the most important part)
        Context context = getApplicationContext();
        Log.i(TAG, "Service Has Now Begun");
        Toast i = Toast.makeText(context,"HI THIS IS A NEW SERVICE",Toast.LENGTH_LONG);
        i.show();

    }

}
