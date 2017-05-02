package projects.tc2r.MYBBLESSONONE;
//MYBRINGBACK Tutorials 12-17
//https://www.youtube.com/watch?v=pZaRNVwKAy4
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/* Instructor: MyBringBack
* ALL 66 Tutorial Videos
* Link: https://www.youtube.com/watch?v=CxPh1tgiK2g&list=PLB03EA9545DD188C3
*
* This Project is a combination of ALL of mybringback's tutorials

*
* Notes on Project:
*
* - Practiced and advanced in my skill of layout confirming,
* using radio buttons and programmatically changing an objects params.
*
*  Created a Listview.
*  splash screen.
*  wallpaper app.
*  manipulated a listview.
*  manipulated and animated views.
*  manipulated graphics using surface view and animated a sprite.
*  Created and played videos and gifs inside of app layouts.
*
*/

public class MainActivity extends AppCompatActivity {
    // Declare variables here for global usage of the activity
    Button tut1Button;
    Button tut2Button;
    Button tut3Button;
    Button tut4Button;
    Button tut5Button;
    Button tut6Button;
    Button tut7Button;
    Button tut9Button;
    // Declare MediaPlayer Variable
    MediaPlayer buttonSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign Variables to their buttons in the .xml
        tut1Button = (Button) findViewById(R.id.tut1Button);
        tut2Button = (Button) findViewById(R.id.tut2Button);
        tut3Button = (Button) findViewById(R.id.tut3Button);
        tut4Button = (Button) findViewById(R.id.tut4Button);
        tut5Button = (Button) findViewById(R.id.tut5Button);
        tut6Button = (Button) findViewById(R.id.tut6Button);
//        tut7Button = (Button) findViewById(R.id.tut7Button);
//        tut8Button = (Button) findViewById(R.id.tut8Button);
        buttonSound = MediaPlayer.create(MainActivity.this, R.raw.splashsound1);

        // Create a listener for when button is clicked
        tut1Button.setOnClickListener(new View.OnClickListener() {
            // Everything in the onClick method is run when user touches button
            @Override
            public void onClick(View v) {

                // startActivity needs an Intent,
                // We create the intent at the same time of calling startActivity.
                buttonSound.start();
                startActivity(new Intent(MainActivity.this, Tutorial1.class));

            }
        });
        // Create a listener for when button is clicked
        tut2Button.setOnClickListener(new View.OnClickListener() {
            // Everything in the onClick method is run when user touches button
            @Override
            public void onClick(View v) {

                // startActivity needs an Intent,
                // We create the intent at the same time of calling startActivity.
                buttonSound.start();
                startActivity(new Intent(MainActivity.this, Tutorial2.class));

            }
        });
        // Create a listener for when button is clicked
        tut3Button.setOnClickListener(new View.OnClickListener() {
            // Everything in the onClick method is run when user touches button
            @Override
            public void onClick(View v) {

                // startActivity needs an Intent,
                // We create the intent at the same time of calling startActivity.
                buttonSound.start();
                startActivity(new Intent(MainActivity.this, Tutorial3.class));

            }
        });
        // Create a listener for when button is clicked
        tut4Button.setOnClickListener(new View.OnClickListener() {
            // Everything in the onClick method is run when user touches button
            @Override
            public void onClick(View v) {

                // startActivity needs an Intent,
                // We create the intent at the same time of calling startActivity.
                buttonSound.start();
                startActivity(new Intent(MainActivity.this, Tutorial4.class));

            }
        });
        // Create a listener for when button is clicked
        tut5Button.setOnClickListener(new View.OnClickListener() {
            // Everything in the onClick method is run when user touches button
            @Override
            public void onClick(View v) {

                // startActivity needs an Intent,
                // We create the intent at the same time of calling startActivity.
                buttonSound.start();
                startActivity(new Intent(MainActivity.this, Tutorial5.class));

            }
        });
        // Create a listener for when button is clicked
        tut6Button.setOnClickListener(new View.OnClickListener() {
            // Everything in the onClick method is run when user touches button
            @Override
            public void onClick(View v) {

                // startActivity needs an Intent,
                // We create the intent at the same time of calling startActivity.
                buttonSound.start();
                startActivity(new Intent(MainActivity.this, Tutorial6.class));

            }
        });

    }

    // WE CREATE A NEW METHOD TO HANDLE THE MENU
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        // CREATE AND ATTACH VARIABLE TO THE MENU'S INFLATER
        MenuInflater awesome = getMenuInflater();
        // USE VARIABLE TO INFLATE MENU
        awesome.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.sweetMenu:
                startActivity(new Intent(MainActivity.this, Sweet.class));

                return true;
            case R.id.toastMenu:
                Toast andEggs = Toast.makeText(this, "THIS IS A TOAST",Toast.LENGTH_LONG);
                andEggs.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
