package com.tc2r.quickmail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendMessage(View view) {

		// Get Checked RadioButton Ids

		int toId = ((RadioGroup) findViewById(R.id.radioGroup1)).getCheckedRadioButtonId();
		int msgId = ((RadioGroup) findViewById(R.id.radioGroup2)).getCheckedRadioButtonId();

		EditText readEt = (EditText) findViewById(R.id.the_decider);
		String mReader = readEt.getText().toString();

		String[] myTime = {"myprojects", "self-taught", "android applications"};


		for (int i = 0; i < myTime.length; i++) {
			if (myTime[i].equals("myprojects")) {
				myTime[i] =
								"I am a Developer  with a passion for coding and creating the best possible applications I can. I learn quickly and am willing to put in the hard work and time to see profits on my investments of dedication and effort. I have worked on many projects with amazing people from all around the world. Most recently I lead a team in the creation of an pseudo game/wikiapia app called Greed Island, this team consisted of 4 startup individuals from around the world. We took in input from the community and worked hard to make a fully functioning application that allowed them to relive and enhance their experience with a manga/game/anime/show called Hunter x Hunter.  I have worked on a few local business apps as well and for every project I have done, I have pushed my upmost to deliver a product that not only is what the customer desires, but will give the best possible chance of results the client desired. While most of my projects by far go unpublished, into my Github, I believe I definitely have what you're looking for. ";
			}
			if (myTime[i].equals("self-taught")) {
				myTime[i] =
								" ~School only teaches you so much.~ I believe this to be a fact of life, because if you have the desire to learn, you must continue your scholarship outside of school. I have been programming for at least 7 years now and with 5+ years towards the android market I believe I can definitely say I've learned more about android in these experiences than I ever did in school. When it comes to any issue, subject or language I have taken it upon myself to not only learn about the subject, but to do so from at LEAST 5 different sources. I catalogue my sources in order to keep myself disciplined as well. So when it came to learning Material Design's Card View. I read about it in ~Android Studio 2 Development Essentials~, Created several project apps through you tube tutorials, stalked stack overflow for every bit of knowledge I could find, taught  those under me about the subject,  and finally recreated the McDonald's App in order to assure my mastery over that subject. I love programming and so I love to learn more and use that knowledge to make more. I have been working hard all year developing Android applications which utilize Java, Javascript and Html. The rewards of my efforts have become evident in the creation of Applications that have been well received within the community, maintaining a 5 star rating even amidst hundreds of ratings.";
			} if (myTime[i].equals("passion")) {
				myTime[i] =
								"My goal is to become a top rate programmer and answer the promise I made to myself as a child (Don't laugh). As a child playing through Golden Eye, watching the news animations, taking Nintendo Cartilages out of the freezer and wondering  ~Why does this work, How does this work, I bet I can make it work better~,  I promised myself I'd make final fantasy 36. Since then  I've worked on mods, A.I. Projects and recently fallen in love with Android Studio. Managing to work on projects and learn more almost every single day of the last three years despite working two jobs. I've had to put aside many other things in my life to pursue my goal and I don't regret it at all. I have a passion for coding and creating the best possible programs and applications I can. I believe nothing comes easy and as such I have put in hard work to get where I am today.  When it comes to coding I am am willing to put my essence into whatever the task is at hand to reach the team's goals. My mind is always on succeed and I don't believe there is any problem that can't be solved, I have the strive, dedication, determination, skill and knowledge to be a huge asset to your company.  And even if you find my skills lacking in an area, give me a week and I'll show you just how powerful this passion can be. My goal is to blow away expectations. Repeatedly.";
			}
		}


	// Get Text by id

	String toName = ((RadioButton) findViewById(toId)).getText().toString();
	String message = ((RadioButton) findViewById(msgId)).getText().toString();

	// Check name and message
	Log.v("To: ",toName);
	Log.v("Message: ",message);

	// Set email address

	String email = "";
	switch(toName)

	{
		case "Mom":
			email = "mom@sample.com";
			break;
		case "Boss":
			email = "boss@sample.com";
			break;
		case "Friend":
			email = "friend@sample.com";
			break;
	}
	// Check email
	Log.v("Email: ",email);


	// Send Email
	Uri uri = Uri.parse("mailto:" + email);

	Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
	intent.putExtra(Intent.EXTRA_SUBJECT,"Sent from QuickMail App.");
	intent.putExtra(Intent.EXTRA_TEXT,message);

	startActivity(intent);


}
}
