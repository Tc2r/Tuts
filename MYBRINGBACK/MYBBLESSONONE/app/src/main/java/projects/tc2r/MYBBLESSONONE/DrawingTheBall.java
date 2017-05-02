package projects.tc2r.MYBBLESSONONE;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawingTheBall extends View{
    Bitmap bBall;
    int x, y, rectX, rectY, rectSize;
    public DrawingTheBall(Context context) {
        super(context);

        bBall = BitmapFactory.decodeResource(getResources(), R.drawable.blueball);
        x = 0;
        y = 0;
        rectX = 0;
        rectY = 0;
        rectSize = 250;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Drawing a Rectangle
        Rect ourRect = new Rect();
        // If the Square X position is larger than the screen, reset it
        if (rectX < canvas.getWidth()) {
            rectX += 3;
        }else{
            rectX =0;
        }
        // If the rect Y pos is larger than the screen, reset
        if (rectY < canvas.getHeight()) {
            rectY += 3;
            rectSize++;
            if(rectSize > canvas.getHeight()/2){
                rectSize = 250;
            }
        }else{
            rectY =0;
        }
        ourRect.set(rectX, rectY, rectX + rectSize, rectY + rectSize);

        // Create Blue Paint Object to Use
        Paint rectColor = new Paint();
        rectColor.setColor(Color.RED);
        rectColor.setStyle(Paint.Style.FILL_AND_STROKE);

        //Draw to Canvas
        canvas.drawRect(ourRect, rectColor);

        // Keep the ball within our Rect!
        if (x < rectX+ rectSize - bBall.getWidth()) {
            x += 10;

        }else{
            x = rectX;
        }
        // Keep the Ball within Our Rect!
        if (y < rectY+rectSize - bBall.getHeight()) {
            y += 10;
        }else{
            y = rectY;
        }
        Paint p = new Paint();
        canvas.drawBitmap(bBall,x, y, p);
        // Force draw to reiterate.
        invalidate();
    }
}
