package com.vivek.task_1_onsites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;


public class MyCanvas extends View {

    Canvas appCanvas;
    Bitmap bitmap;
    Paint rectBorder;
    LinearLayout layout;
    int left = 200;
    int top = 200;
    int right = 600;
    int bottom = 600;
    Rect rect;

    int prevX ;
    int prevY ;

    private int touchMode;
    static final int TOUCH_MODE_TAP = 1;
    static final int TOUCH_MODE_DOWN = 1;

    public MyCanvas(Context context) {
        super(context);
        rect = new Rect();
        layout = new LinearLayout(context);
        rectBorder = new Paint();
        rectBorder.setColor(Color.BLACK);
        rectBorder.setStrokeWidth(30);
        rectBorder.setAntiAlias(true);
        rectBorder.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            appCanvas = new Canvas(bitmap);
        }

//        int screenWidth = appCanvas.getWidth();
//        int screenHeight = appCanvas.getHeight();
//
//        if (touch == false) {
//
//            left = (screenWidth / 2) - 200;
//            top = (screenHeight / 2) - 200;
//            right = (screenWidth / 2) + 200;
//            bottom = (screenHeight / 2) + 200;
//        }
        rect.left = left;
        rect.right= right;
        rect.top = top;
        rect.bottom = bottom;

        canvas.drawRect(rect, rectBorder);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int positionX = (int) event.getX();
        int positionY = (int) event.getY();



            if (Math.abs(positionX - left) < 25 && positionY > top && positionY < bottom) {
            Log.d("rectleft","touched");
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:{
                    touchMode = TOUCH_MODE_DOWN;
                    prevX = positionX;
                    prevY = positionY;
                }
                break;

                case MotionEvent.ACTION_MOVE:{
                    Log.d("buddy", String.valueOf(positionX));
                    left = positionX;
                    invalidate();
                }
                break;

                case MotionEvent.ACTION_UP:{
                    break;
                }

            }
            return true;

        }
        if (Math.abs(positionY - top) < 25 && positionX  > left && positionX  < right) {
            Log.d("recttop","touched");
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:{
                    touchMode = TOUCH_MODE_DOWN;
                    prevX = positionX;
                    prevY = positionY;
                }
                break;

                case MotionEvent.ACTION_MOVE:{
                    Log.d("buddy", String.valueOf(positionX));
                    top = positionY;
                    invalidate();
                }
                break;

                case MotionEvent.ACTION_UP:{
                    break;
                }

            }
            return true;
        }
        if (Math.abs(positionX  - right) < 25 && positionY > top && positionY < bottom) {
            Log.d("rectright","touched");
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:{
                    touchMode = TOUCH_MODE_DOWN;
                    prevX = positionX;
                    prevY = positionY;
                }
                break;

                case MotionEvent.ACTION_MOVE:{
                    Log.d("buddy", String.valueOf(positionX));
                    right = positionX;
                    invalidate();
                }
                break;

                case MotionEvent.ACTION_UP:{
                    break;
                }

            }
            return true;
        }
        if (Math.abs(positionY - bottom) < 25 && positionX  > left && positionX  < right) {
            Log.d("rectBottom","touched");
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:{
                    touchMode = TOUCH_MODE_DOWN;
                    prevX = positionX;
                    prevY = positionY;
                }
                break;

                case MotionEvent.ACTION_MOVE:{
                    Log.d("buddy", String.valueOf(positionX));
                    bottom = positionY;
                    invalidate();
                }
                break;

                case MotionEvent.ACTION_UP:{
                    break;
                }

            }
            return true;
        }
        if(positionX+20>left&&positionX-20<right&&positionY+20>top&&positionY-20<bottom){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:{
                    touchMode = TOUCH_MODE_DOWN;
                    prevX = positionX;
                    prevY = positionY;
                }
                break;

                case MotionEvent.ACTION_MOVE:{
                    Log.d("buddy", String.valueOf(positionX));
                    left=left+positionX-prevX;
                    right=right+positionX-prevX;
                    top = top + positionY-prevY;
                    bottom = bottom + positionY-prevY;
                    prevX = positionX;
                    prevY=positionY;

                    invalidate();
                }
                break;

                case MotionEvent.ACTION_UP:{
                    break;
                }

            }
            return true;
        }
        return super.onTouchEvent(event);
    }
}
