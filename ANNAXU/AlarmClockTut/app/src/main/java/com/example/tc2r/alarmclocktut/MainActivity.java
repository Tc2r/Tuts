package com.example.tc2r.alarmclocktut;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import static com.example.tc2r.alarmclocktut.R.id.AlarmTimePicker;

/* Instructor: Anna Xu
* Link: https://www.youtube.com/watch?v=xbBlzOblD10
*
* Alarm Clock app that uses Alarm Manager, the Calendar Object and
* pending Intents.
*
* Notes on Project:
* If we used broadcast receivers we would be able to preserve the alarm between phone boots.
*
*/

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

	AlarmManager alarmManager;
	TimePicker alarmTimePicker;
	TextView updateText;
	Context context;
	Button alarmOn, alarmOff;
	PendingIntent pendingIntent;
	Calendar calendar;

	int alarmQuote = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this.getApplicationContext();

		// Create the spinner
		Spinner spinner = (Spinner) findViewById(R.id.act_spinner);
		// Create an ArrayAdater using the string Array and a default spinner layout
		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context, R.array.ringtone_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears.
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(arrayAdapter);
		spinner.setOnItemSelectedListener(this);

		// Initialize our AlarmManager

		alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		// Initialize our TimePicker
		alarmTimePicker = (TimePicker) findViewById(AlarmTimePicker);
		updateText = (TextView) findViewById(R.id.alarm_update_text);
		alarmOn = (Button) findViewById(R.id.alarm_on);
		alarmOff = (Button) findViewById(R.id.alarm_off);


		// Create an instance of a calender
		calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 3);
		// Create an intent to the alarm Receiver class

		final Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);


		//Make Onclick Listeners to know when buttons are pressed
		alarmOn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int hour;
				int minute;
				// Set calendar instance with the hour and minute that we picked
				// on the time picker

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
					calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
					calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());
					hour = alarmTimePicker.getHour();
					minute = alarmTimePicker.getMinute();
				} else

				{
					calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
					calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
					hour = alarmTimePicker.getCurrentHour();
					minute = alarmTimePicker.getCurrentMinute();
				}
				// get the string values of the hour and minute

				// Decide if AM or PM
				String mornOrEven = "AM";
				if(hour > 11){
					mornOrEven = "PM";
				}

				// Convert the int values to strings
				//Toast.makeText(context.getApplicationContext(),"RAW TIME: "+ String.valueOf(hour) +":"+ String.valueOf(minute), Toast.LENGTH_LONG).show();
				String hourString = String.valueOf(hour);

				// If Time is Weird, change it's display so it shows properly.

				// It can't be 0'oclock, hour = 0 means 12am, so we add 12.
				if (hour == 0) {
					hourString = String.valueOf(hour + 12);
				} else if (hour > 12) {
					hourString = String.valueOf(hour - 12);
				}

				// It can't be 12:9, So we add a 0 to the string. aka 12:09
				String minuteString = String.valueOf(minute);
				if (minute < 10) {
					minuteString = "0" + minuteString;

				}

				// method that changes the update text TextView
				setAlarmText("Alarm set to: " + hourString + ":" + minuteString +" "+mornOrEven);


				// put in extra string into myintent
				// tells the clock that you pressed the "alarm on button"

				intent.putExtra("extra", "alarm on");


				// put extra long value into intent, tells clock u want a certain value from menu/spinner.
				intent.putExtra("quoteID", String.valueOf(alarmQuote));


				// Create a pending intent that delays
				// the intent until the specified calendar time.
				pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent,
								PendingIntent.FLAG_UPDATE_CURRENT);

				// set the alarm manager
				alarmManager.set(AlarmManager.RTC_WAKEUP,
								calendar.getTimeInMillis(), pendingIntent);
			}
		});


		alarmOff.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				// method that changes the update text TextView
				//setAlarmText("Alarm Cancelled");
				setAlarmText("ID is " + alarmQuote);
				// Cancel the pending Intent
				alarmManager.cancel(pendingIntent);

				// put extra string into myintent
				// tells clock you pressed AlarmOff Button
				intent.putExtra("extra", "alarm off");
				intent.putExtra("quoteID", String.valueOf(alarmQuote));

				// Stop The Ringtone
				sendBroadcast(intent);
			}
		});

	}

	private void setAlarmText(String output) {
		updateText.setText(output);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.e("AlarmclockTut", "on Destroy");
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// An item was selected. You can retrieve the selected Item using
		// parent.getItemAtPosition(position)

		// outputing ringtone selected.
		alarmQuote = (int) id;

		setAlarmText("ID is " + alarmQuote);

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// Another interface callback

	}
}
