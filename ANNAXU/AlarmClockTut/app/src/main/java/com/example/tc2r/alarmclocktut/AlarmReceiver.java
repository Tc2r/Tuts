package com.example.tc2r.alarmclocktut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Tc2r on 1/15/2017.
 * <p>
 * Description:
 */

public class AlarmReceiver extends BroadcastReceiver {
	private static final String TAG = AlarmReceiver.class.getSimpleName();


	@Override
	public void onReceive(Context context, Intent intent) {

		Log.w(TAG, "WE ARE IN THE RECEIVER YAY");

		// fetch extra strings from the Intent
		String getStatusString = intent.getExtras().getString("extra");
		String quoteID = intent.getExtras().getString("quoteID");

		// Display that receiver has received the ID!
		Toast.makeText(context.getApplicationContext()," This is working: "+ String.valueOf(quoteID), Toast.LENGTH_LONG).show();


		// create an intent to the ringtone service
		Intent serviceIntent = new Intent(context, RingtonePlayingService.class);

		// pass the extra string from AlarmReceiver to the Ringtone Playing Service
		serviceIntent.putExtra("extra", getStatusString);
		serviceIntent.putExtra("quoteID", quoteID);

		// Start the ringtone service
		context.startService(serviceIntent);
	}
}
