package com.example.tc2r.alarmclocktut;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Tc2r on 1/15/2017.
 * <p>
 * Description:
 */

public class RingtonePlayingService extends Service {

	private static final String TAG = RingtonePlayingService.class.getSimpleName();
	MediaPlayer mediaPlayer;
	private boolean isRunning;
	private Context context;
	int startSound;


	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.w(TAG, "startID: " + startId);
		final NotificationManager mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Intent intent1 = new Intent(this.getApplicationContext(), MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);

		Notification mNotify = new Notification.Builder(this)
						.setContentTitle("Alarm Clock Is Going Off" + "!")
						.setContentText("Click me!")
						.setContentIntent(pendingIntent)
						.setSmallIcon(R.drawable.ic_action_call)
						.setAutoCancel(true)
						.build();

		// fetch the extra string values

		String state = intent.getExtras().getString("extra");
		Log.w(TAG, "Ringtone extra state is: " + state);
		String quoteID = intent.getExtras().getString("quoteID");
		int quoteChoice = Integer.parseInt(quoteID);

		// This converts the extra strings from the Intent to startSound
		// value 0 or 1

		assert state != null;
		switch (state) {
			case "alarm on":
				startSound = 1;
				Log.e(TAG, "ALARM ON!");
				break;
			case "alarm off":
				startSound = 0;
				Log.e(TAG, "ALARM OFF!");
				break;
			default:
				startSound = 0;
				break;
		}


		// if else statements

		// if there is no music playing, and user pressed "alarm on"
		// music should start

		if (!this.isRunning && startSound == 1) {
			mNM.notify(0, mNotify);
			this.isRunning = true;
			startSound = 0;

			Log.w(TAG, "No Sound, Start");

			quoteChoice = quoteChoice + 1;

			if (quoteChoice == 1) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 1", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 2) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 2", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 3) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 3", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 4) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 4", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 5) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 5", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 6) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 6", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 7) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 7", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 8) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 8", Toast.LENGTH_LONG).show();
			} else if (quoteChoice == 9) {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE 9", Toast.LENGTH_LONG).show();
			} else {
				mediaPlayer = MediaPlayer.create(this, R.raw.ringtone);
				Toast.makeText(getApplicationContext(), "RING TONE DEFAULT", Toast.LENGTH_LONG).show();
			}
			mediaPlayer.start();


		}
		// if there is music playing, and the user pressed alarm off
		// music should stop playing.
		else if (this.isRunning && startSound == 0) {
			Log.e("MUSIC PLAYING ", " STOP IT");
			mediaPlayer.stop();
			mediaPlayer.reset();
			this.isRunning = false;
			startSound = 0;

		}
		// these are if the user presses random buttons
		// if there is no music playing, and user pressed alarm off
		// do nothing
		else if (!this.isRunning && startSound == 0) {
			Log.e("There was no sound ", " and you want end");

			this.isRunning = false;
			startSound = 0;


		}

		// there is music playing and alarm on pressed, do nothing.
		else if (this.isRunning && startSound == 1) {
			Log.e("if there is sound ", " and you want start");

			this.isRunning = true;
			startSound = 0;


		}
		// catch odd event
		else {
			Log.e("if there is sound ", " and you want end");

			mediaPlayer.stop();
			mediaPlayer.reset();

			this.isRunning = false;
			startSound = 0;
		}

		Log.e("alarmclocktut", "In The Service");

		// if service stops, it wont automatically restart
		return START_NOT_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Toast.makeText(this, "on Destroy Called", Toast.LENGTH_SHORT).show();
		this.isRunning = false;
	}


}

