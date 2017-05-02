package projects.tc2r.MYBBLESSONONE;
// MYBRINGBACK TUT 39 - VIDEO
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Tutorial6 extends Activity {

    VideoView vid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial6);
        vid = (VideoView) findViewById(R.id.videoView);

        // IF FROM WEB ADD PERMISSION INTERNET
        String urlPath = "http://tcandroidtest.comxa.com/REM.mp4";

        // IF FROM DEVICE
        // String urlpath = "android.resources://" + getPackagename()+"/" +R.raw.VIDEO;

        //pass along the url to the video
        vid.setVideoURI(Uri.parse(urlPath));
        // start the video
        vid.start();

        // Add Controls to the video using MediaController class.
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(vid);
        vid.setMediaController(mediaController);


    }
}
