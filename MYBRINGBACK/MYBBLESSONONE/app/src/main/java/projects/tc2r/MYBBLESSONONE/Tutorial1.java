package projects.tc2r.MYBBLESSONONE;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class Tutorial1 extends Activity implements OnCheckedChangeListener {

    // Create and Declare our variables
    TextView textOut;
    EditText textIn;
    RadioGroup gravityG;
    RadioGroup styleG;
    RadioButton boldButton;
    RadioButton italicButton;
    RadioButton normalButton;
    Button genButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial1);
        // Initalize the Variables
        textOut = (TextView) findViewById(R.id.changeTextView);
        textIn = (EditText) findViewById(R.id.editText1);
        genButton = (Button) findViewById(R.id.genButton);

        // Setup Radiogroups,tell their listener to use the Activity's listener.
        gravityG = (RadioGroup) findViewById(R.id.gravityRadioGroup);
        gravityG.setOnCheckedChangeListener(this);

        styleG = (RadioGroup) findViewById(R.id.styleRadioGroup);
        styleG.setOnCheckedChangeListener(this);


        // Create a click listener for the button.
        genButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // When clicked this code is ran.
                // We tell textout to set its text to what textIn is.
                // Use .toString in case what is in textIn isn't a string.
                textOut.setText(textIn.getText().toString());

            }
        });
    }

    // This is the activity's listner.
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        // Switch is an easy Loop for multiple conditions
        switch(checkedId){
            case R.id.leftRadioButton:
                textOut.setGravity(Gravity.LEFT);
                break;
            case R.id.centerRadioButton:
                textOut.setGravity(Gravity.CENTER);
                break;
            case R.id.rightRadioButton:
                textOut.setGravity(Gravity.RIGHT);
                break;
            case R.id.normalRadioButton:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case R.id.boldRadioButton:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                break;
            case R.id.italicRadioButton:
                textOut.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                break;
        }

    }
}
