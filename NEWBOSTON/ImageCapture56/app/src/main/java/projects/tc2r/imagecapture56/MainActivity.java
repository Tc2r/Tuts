package projects.tc2r.imagecapture56;
// THENEWBOSTON TUTORIAL - Taking Photos With Camera!
//https://www.youtube.com/watch?v=k1Wc0vmD284#t=528.426872

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView tcImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tcButton = (Button) findViewById(R.id.tcButton);
        tcImageView = (ImageView)findViewById(R.id.tcImageView);

        // First Check For Camera!
        // Disable Button if user has no camera.
        if(!hasCamera())
            tcButton.setEnabled(false);

    }

    // Check if the user has a camera
    public boolean hasCamera(){

        // Check for camera on device.
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);

    }

    public void LaunchCamera(View view){
        // Camera Launching Intent
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Take a picture and pass the results along to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    // If you want to return the image taken use onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Check for Image using requestCode and resultCode
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Get the Photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            tcImageView.setImageBitmap(photo);
        }
    }
}
