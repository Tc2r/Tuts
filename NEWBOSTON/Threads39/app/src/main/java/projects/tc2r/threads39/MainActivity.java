package projects.tc2r.threads39;
//THENEWBOSTON
//https://www.youtube.com/watch?v=SCwU-gy3HoM
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView tcText = (TextView) findViewById(R.id.tcText);
            tcText.setText("Nice Job Boss!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickTcButton(View view){

        // RUNNABLE IS SECTION OF CODE THAT WILL BE USED BY A THREAD
        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime){
                    synchronized(this){
                        try{
                            wait(futureTime - System.currentTimeMillis());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
                // USE HANDLER TO INTERACT WITH MAIN PROGRAM
                handler.sendEmptyMessage(0);
            }
        };
        //CREATE A NEW THREAD WITH RUNNABLE R CODE INSIDE, THEN RUN IT
        Thread tcThread = new Thread(r);
        tcThread.start();




    }
}
