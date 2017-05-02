package projects.tc2r.MYBBLESSONONE;
// SURFACE VIEW With Animations
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


public class Tutorial5 extends Activity implements View.OnTouchListener {
    // Created a Custom View
    OurView v;

    Bitmap ball;
    // X and Y of our ball
    float x, y;
    Sprite sprite;
    Bitmap lion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initate the view and its ontouchlistener
        v = new OurView(this);
        v.setOnTouchListener(this);

        // Intiate our ball bitmap
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.blueball);
        lion = BitmapFactory.decodeResource(getResources(), R.drawable.lion);

        x = 0;
        y = 0;

        // Called Content View using our custom View
        setContentView(v);
    }

    @Override
    protected void onPause() {
        super.onPause();
        v.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        v.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // We're going to make the ball draw where the user touches
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x = event.getX();
                y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                x = event.getX();
                y = event.getY();
                break;
        }
        // Return to True allows it to continue looking for more actions.
        return true;
    }

    // Customer view we created that works on a different thread
    // This way we aren't taxing the Main thread's processor.
    public class OurView extends SurfaceView implements Runnable {

        Thread t = null;
        SurfaceHolder holder;
        boolean isItOK = false;
        boolean spriteLoaded = false;


        public OurView(Context context) {
            super(context);
            holder = getHolder();
        }

        // Our Thread calls the run Method
        @Override
        public void run() {
            sprite = new Sprite(OurView.this, lion);
            if(!spriteLoaded){

                spriteLoaded = true;
            }

            while(isItOK) {
                //perform canvas drawing
                if(!holder.getSurface().isValid()){
                    // Continue means skip the rest and go back to the while loop
                    continue;
                }

                // Lock canvas, paint to it, then unlock canvas and display.
                Canvas canvas = holder.lockCanvas();
                Draw(canvas);
                holder.unlockCanvasAndPost(canvas);

            }

        }

        protected void Draw(Canvas canvas){
            canvas.drawARGB(255, 150,10,150);
            canvas.drawBitmap(ball, x - (ball.getWidth()/2), y - (ball.getHeight()/2), null);
            sprite.onDraw(canvas);

        }

        public void pause() {
            isItOK = false;
            while (true) {
                try {
                    // closes threads?
                    t.join();
                    t = null;
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        public void resume() {
            isItOK = true;
            t = new Thread(this);
            t.start();
        }
    }
}
