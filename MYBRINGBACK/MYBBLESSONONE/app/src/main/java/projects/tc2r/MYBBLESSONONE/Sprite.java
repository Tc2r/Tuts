package projects.tc2r.MYBBLESSONONE;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import projects.tc2r.MYBBLESSONONE.Tutorial5.OurView;

public class Sprite {

    // Declare  Variables
    // the start points of our rect
    int x, y;

    // controls how fast we move in a direction
    int aniSpeed, xSpeed, ySpeed;
    // The end point of our rect
    int height, width;

    // The Bitmap we use
    Bitmap leo;

    // Our custom View
    OurView ov;

    // Direction and animation control
    int currentFrame = 0;
    int direction = 1;

    public Sprite(OurView ourView, Bitmap lion) {
        leo = lion;
        ov = ourView;

        // Divide Height by 4, rows
        height = leo.getHeight()/4;
        // Divide Height by 3, rows
        width = leo.getWidth()/3;
        x = y = 0;
        // ANISPEED is a master control so we do not have to code every change in speed.
        aniSpeed = 25;
        xSpeed = aniSpeed;
        ySpeed = 0;
    }

    public void onDraw(Canvas canvas) {
        update();
        int srcY = direction * height;
        int srcX = currentFrame * width;
        Rect src = new Rect(srcX,srcY,srcX + width, srcY + height);
        Rect dst = new Rect(x,y,x+width, y+height);
        canvas.drawBitmap(leo,src,dst,null);
    }

    private void update() {

        // 0 = up;
        // 1 = right
        // 2 = down
        // 3 = left

        //facing down
        if(x> ov.getWidth() - width - xSpeed){
            // if hit right wall, travel down
            xSpeed = 0;
            ySpeed = aniSpeed;
            direction = 2;
        }
        // facing left
        if(y> ov.getHeight() - height - ySpeed){
            // If hit bottom wall, travel left;
            xSpeed = -aniSpeed;
            ySpeed = 0;
            direction = 3;
        }
        // facing up
        if(x + xSpeed < 0){
            // if hit left wall, travel up
            x = 0;
            xSpeed = 0;
            ySpeed = -aniSpeed;
            direction = 0;
        }
        //facing right
        if(y +ySpeed < 0){
            // if hit top wall, travel right
            y = 0;
            xSpeed = aniSpeed;
            ySpeed = 0;
            direction = 1;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // cycles through Frames using Modulus = remainder
        currentFrame = (++currentFrame % 3);

        // Update Position
        x += xSpeed;
        y += ySpeed;
    }
}
