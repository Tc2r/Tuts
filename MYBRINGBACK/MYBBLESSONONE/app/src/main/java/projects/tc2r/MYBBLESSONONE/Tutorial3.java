package projects.tc2r.MYBBLESSONONE;
// MYBRINGBACK SETTING WALLPAPERS TUTORIAL
//https://www.youtube.com/watch?v=gu4qa2zaZ3M
import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class Tutorial3 extends Activity implements View.OnClickListener {
    ImageView displayIV;
    Button setWall;

    // variable to hold the Resource id number we want for wallpaper
    int toPhone;

    // initate wallpaperManager to control the wallpapers
    WallpaperManager wallpaperManager;

    // A variable to get H and W pixel size of screen
    DisplayMetrics screenSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tutorial3);

        // Initiate Variables
        toPhone = R.drawable.ct1;
        screenSize = getApplicationContext().getResources().getDisplayMetrics();


        displayIV = (ImageView) findViewById(R.id.displayImageView);
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        ImageView image2 = (ImageView) findViewById(R.id.image2);
        ImageView image3 = (ImageView) findViewById(R.id.image3);
        ImageView image4 = (ImageView) findViewById(R.id.image4);
        ImageView image5 = (ImageView) findViewById(R.id.image5);
        ImageView image6 = (ImageView) findViewById(R.id.image6);
        ImageView image7 = (ImageView) findViewById(R.id.image7);
        ImageView image8 = (ImageView) findViewById(R.id.image8);
        ImageView image9 = (ImageView) findViewById(R.id.image9);
        setWall = (Button) findViewById(R.id.setWalButton);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image8.setOnClickListener(this);
        image9.setOnClickListener(this);
        setWall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.image1:
                displayIV.setImageResource(R.drawable.ct1);
                toPhone = R.drawable.ct1;
                break;
            case R.id.image2:
                displayIV.setImageResource(R.drawable.ct2);
                toPhone = R.drawable.ct2;
                break;
            case R.id.image3:
                displayIV.setImageResource(R.drawable.ct3);
                toPhone = R.drawable.ct3;
                break;
            case R.id.image4:
                displayIV.setImageResource(R.drawable.ct4);
                toPhone = R.drawable.ct4;
                break;
            case R.id.image5:
                displayIV.setImageResource(R.drawable.ct5);
                toPhone = R.drawable.ct5;
                break;
            case R.id.image6:
                displayIV.setImageResource(R.drawable.ct6);
                toPhone = R.drawable.ct6;
                break;
            case R.id.image7:
                displayIV.setImageResource(R.drawable.ct7);
                toPhone = R.drawable.ct7;
                break;
            case R.id.image8:
                displayIV.setImageResource(R.drawable.ct8);
                toPhone = R.drawable.ct8;
                break;
            case R.id.image9:
                displayIV.setImageResource(R.drawable.ct9);
                toPhone = R.drawable.ct9;
                break;
            case R.id.setWalButton:
                //setWallpaper is DEPRECIATED, we are suppose to use the new and sexy wallpaperManager.

                // First we get the InputStream for the Image so we can change to a Bitmap
                InputStream inputStream = getResources().openRawResource(toPhone);
                //We have to change our image into a bitmap in order to set it as a wallpaper
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                // WE TAKE OUR SMALL SQUARISH PICTURES AND SCALE EM UP TO THE SIZE OF THE DEVICE.
                Bitmap useThisBitmap = bitmap.createScaledBitmap(bitmap, screenSize.heightPixels, screenSize.heightPixels, true);

                try {
                    //Set wallpaper to new Image USING WallpaperMANAGER

                    //Tell the Manager to manage the wallpaper of THIS device.
                    wallpaperManager = WallpaperManager.getInstance(this);
                    // Now tell it to set the Bitmap to the resized Bitmap we created BOOM BABY!
                    wallpaperManager.setBitmap(useThisBitmap);
                    //Send a Message on completion! OMEGA GOOD JOB!
                    Toast.makeText(this, "Wallpaper Set!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // RECYCLE THE OLD BITMAP TO SAVE MEMORY.
                bitmap.recycle();
                break;
        }
    }
}
