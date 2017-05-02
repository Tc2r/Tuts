package projects.tc2r.playingvideo55;
// THENEWBOSTON PLAYING VIDEOS 55
// https://www.youtube.com/watch?v=oF9yZenJtjI
// How to create a app that can play videos

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView tcVideoView = (VideoView) findViewById(R.id.tcVideoView);

        // Calls video to load
        tcVideoView.setVideoPath("http://tcandroidtest.comxa.com/REM.mp4");

        // Player controls(play, pause, stop, etc...)
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(tcVideoView);
        tcVideoView.setMediaController(mediaController);

        // starts video
        tcVideoView.start();



    }
}
