package projects.tc2r.transitions34;
//https://www.youtube.com/watch?v=n4IyvL-ACbk
//THE NEW BOSTON ANIMATIONS AND TRANSITIONS TUT
// MOVING BUTTON WHEN TOUCH SCREEN

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup tcLayout;
    Button tc_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tcLayout = (ViewGroup) findViewById(R.id.tcLayout);
        tc_button = (Button) findViewById(R.id.tc_Button);
        tcLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        // Whenever user touches layout this code is activated
                        moveButton();
                        return true;
                    }
                }
        );
    }
    public void moveButton(){
        View tcButton = findViewById(R.id.tc_Button);
        TransitionManager.beginDelayedTransition(tcLayout);

        //CHANGE THE POSITION OF THE BUTTON
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        tcButton.setLayoutParams(positionRules);

        //CHANGE THE SIZE OF THE BUTTON
        ViewGroup.LayoutParams sizeRules = tcButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        tcButton.setLayoutParams(sizeRules);

        //Change Text On Button!
        tc_button.setText("ANIMATED");
        tc_button.setBackgroundColor(Color.CYAN);


    }

}
