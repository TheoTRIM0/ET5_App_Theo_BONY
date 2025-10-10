package UPsay.decouverteAndroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Toast;
import android.os.Handler;
import androidx.annotation.Nullable;

public class ToGraphic extends View{
    float xText, yText;
    float size;
    float x1, x2, y1, y2;
    Handler timerHandler = new Handler();
    Runnable updateTimerThread = new Runnable() {
        public void run() {
            timerHandler.postDelayed(this,100);
            size=size+1;
            invalidate(); // appel de onDraw pour redessiner
        }
    };

    public ToGraphic(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setXYText(600,600);
        size=100;
        timerHandler.postDelayed(updateTimerThread, 10);
        setOnTouchListener(onTouchListener);
    }

    public void setXYText (float x, float y){
        xText=x;
        yText=y;
    }

    @Override
    public void onDraw (Canvas canvas) {
        Paint p = new Paint();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.curieux);
        canvas.drawBitmap(b, 200,200,p);
       /* p.setColor(Color.BLACK);
        p.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawRect(0,0,getWidth(),getHeight(), p);
        p.setColor(Color.GREEN);
        p.setTextSize(100);
        p.setTextAlign(android.graphics.Paint.Align.CENTER);
        String texte = "Bonjour MONDE";
        canvas.drawText(texte, getWidth()/2, getHeight()/2, p);*/
        p.setTextSize(size);
        String texte = "Bonjour MONDE";
        canvas.drawText(texte, xText, yText, p);

    }
/*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        xText = event.getX();
        yText = event.getY();
        invalidate();
        return false;
    }
*/
    OnTouchListener onTouchListener = new OnTouchListener() {

        @Override
        public boolean onTouch(View v,MotionEvent event) {
            float dx, dy;
            String direction;
            switch (event.getAction()) {
                case (MotionEvent.ACTION_DOWN):
                    x1 = event.getX();
                    y1 = event.getY();
                    Log.i("pacman", "appuyé");
                    break;
                case (MotionEvent.ACTION_UP): {
                    x2 = event.getX();
                    y2 = event.getY();
                    dx = x2 - x1;
                    dy = y2 - y1;
                    // Use dx and dy to determine the direction of the move
                    if (Math.abs(dx) > Math.abs(dy)) {
                        if (dx > 0)
                            direction = "right";
                        else
                            direction = "left";
                    } else {
                        if (dy > 0)
                            direction = "down";
                        else
                            direction = "up";
                    }
                    Log.i("pacman", "laché " + direction);
                    Log.i("pacman", "dx = " + dx + "; dy = " + dy);
                    break;
                }
            }
            invalidate();
            return true;
        }
    };
}

