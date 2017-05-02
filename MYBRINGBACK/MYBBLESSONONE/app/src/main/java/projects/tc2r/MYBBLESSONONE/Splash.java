package projects.tc2r.MYBBLESSONONE;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

    MediaPlayer logoMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // First we create a thread.
        logoMusic = MediaPlayer.create(this, R.raw.splashsound1);
        Thread logoTimer = new Thread(){

            //Press Ctrl O to add Overide Methods
            @Override
            public void run() {
                super.run();
                //The Try bracket is needed whenever an error may present itself.
                try {
                    //First we make the device pause
                    sleep(2000);

                } catch (InterruptedException e) {
                    // If unable to sleep, it prints an error to E in debug.
                    e.printStackTrace();
                }finally {

                    logoMusic.start();
                    // Here I break up my sleep so my sound has a delay
                    //*******
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //*******

                    // If the sleep command runs correctly, we create an Intent
                    // our intent is to go from splash to Main.
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    // Now we start our intent
                    startActivity(intent);
                    //and now we close the thread we made.
                    finish();
                }


            }

        };
        // This starts our thread.
        logoTimer.start();
    }


    // Here we add a command that will run whenever the activity pauses.
    @Override
    protected void onPause() {
        if (logoMusic.isPlaying()){
            logoMusic.stop();
            logoMusic.release();
        }
        super.onPause();
    }
}