
package org.flum.tamagotchi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

public class DrawMiniGame extends View {

    Activity activity = new Activity();
Activity activity2 = (Activity) getContext();

    public static int paddingLeft;
    float canvasH, canvasW, CW5, MOC;

    public static int wP;
    public static int hP;
    public static int wM;
    public static int hM;
    public static int wMe;
    public static int hMe;
    public static int wW;
    public static int hW;


    public DrawMiniGame(Context context) {
        super(context);

        Bitmap bPlayer = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_mini);
        wP = bPlayer.getWidth();
        hP = bPlayer.getHeight();
        Rect firstFrameP = new Rect(0, 0, wP, hP);
        player = new GameSprite(216*2 + 16, 1500, 0, 0, firstFrameP, bPlayer);
        player.addFrame(new Rect(wP, 0 * hP, wP + wP, hP + hP));

        Bitmap bMeteor = BitmapFactory.decodeResource(getResources(), R.drawable.meteor);
        wM = bPlayer.getWidth();
        hM = bPlayer.getHeight();
        Rect firstFrameM = new Rect(0, 0, wM, hM);
        meteor = new GameSprite(216 * ((int) ((Math.random()*4)) + 1) + 16, 200 + ((int) (Math.random()*1000)), 0, 300, firstFrameM, bMeteor);
        meteor.addFrame(new Rect(wM, hM, wM*2, hM*2));

        Bitmap bMeat = BitmapFactory.decodeResource(getResources(), R.drawable.meat);
        wMe = bMeat.getWidth();
        hMe = bMeat.getHeight();
        Rect firstFrameMe = new Rect(0, 0, wMe, hMe);
        meat = new GameSprite(216 * ((int) ((Math.random()*4)) + 1) + 16, 2800 + ((int) (Math.random()*2000)), 0, 300, firstFrameMe, bMeat);
        meat.addFrame(new Rect(wMe, hMe, wMe*2, hMe*2));

        Bitmap bWater = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        wW = bWater.getWidth();
        hW = bWater.getHeight();
        Rect firstFrameW = new Rect(0,0,wW,hW);
        water = new GameSprite(216 * ((int) ((Math.random()*4)) + 1) + 16, 1400 + ((int) (Math.random()*1000)), 0, 300, firstFrameW, bWater);
        water.addFrame(new Rect(wW, hW, wW*2, hW*2));

        Timer timer = new Timer();
        timer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        Paint p = new Paint();

        canvas.drawARGB(127, 0, 0, 255);

        canvas.drawLine(10, 0, 10, canvasH, paint);
        canvas.drawLine(CW5 * 1, 0, CW5 * 1, canvasH, paint);
        canvas.drawLine(CW5 * 2, 0, CW5 * 2, canvasH, paint);
        canvas.drawLine(CW5 * 3, 0, CW5 * 3, canvasH, paint);
        canvas.drawLine(CW5 * 4, 0, CW5 * 4, canvasH, paint);
        canvas.drawLine(canvasW - 10, 0, canvasW - 10, canvasH, paint);
        canvas.drawLine(10, canvasH - CW5, canvasW - 10, canvasH - CW5, paint);

        p.setAntiAlias(true);
        p.setTextSize(55.0f);
        p.setColor(Color.WHITE);
        canvas.drawText("Жизни: " + points + "", viewWidth - 250, 70, p);
        canvas.drawText("Еды: " + Person.HMEat, viewWidth - 650, 70, p);
        canvas.drawText("Воды: " + Person.HMWater, viewWidth - 1050, 70, p);

        canvasH = canvas.getHeight();
        canvasW = canvas.getWidth();
        CW5 = canvasW / 5;
        MOC = CW5 / 2;

        paddingLeft = (int) (CW5 - wP) /2;

        player.draw(canvas);
        meteor.draw(canvas);
        meat.draw(canvas);
        water.draw(canvas);

        gH = viewHeight;
    }

    public void update() {
        player.update(timerInterval);
        meteor.update(timerInterval);
        meat.update(timerInterval);
        water.update(timerInterval);

        if (meat.getY() > (player.getY() + player.getFrameHeight())) {
            teleportMeat();
        }

        if (meat.intersect(player)) {
            teleportMeat();
            Person.HMEat ++;
        }

        if (meteor.getY() > (player.getY() + player.getFrameHeight())) {
            teleportMeteor();
        }

        if (meteor.intersect(player)) {
            if (points == 0) {
                points = 3;
                Intent intent = new Intent(getContext(), MainActivity.class);
                activity2.startActivity(intent);
            }
            teleportMeteor();
            points -= 1;
        }

        if (water.getY() > (player.getY() + player.getFrameHeight())) {
            teleportWater();
        }

        if (water.intersect(player)) {
            teleportWater();
            Person.HMWater ++;
        }

        invalidate();
    }

    private boolean isItStart = true;

    private final int timerInterval = 20;
    private int viewWidth;
    private int viewHeight;
    private int points = MainActivity.points;
    private GameSprite player;
    private GameSprite meteor;
    private GameSprite meat;
    private GameSprite water;
    private int gH;


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        viewWidth = w;
        viewHeight = h;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventActivation = event.getAction();
        if (eventActivation == MotionEvent.ACTION_DOWN) {
            if (event.getX() < player.getBoundingBoxRect().right && player.getX() < 1080 - 216) {
                player.setX(player.getX()+216);
            }
            else if (event.getY() > player.getBoundingBoxRect().left  && player.getX() > 216) {
                player.setX(player.getX() - 216);
            }
        }
        return true;
    }

    private void teleportMeteor() {
        int rd = (int) (Math.random() * 4);
        meteor.setY(-100);
        meteor.setX (16 + 216 * rd);
        meteor.setVelocityY(meteor.getVelocityY() + 5);
    }

    private void teleportMeat() {
        int rd = (int) (Math.random() * 4);
        meat.setY(-100);
        meat.setX (16 + 216 * rd);
        meat.setVelocityY(meat.getVelocityY() + 5);
    }

    private void teleportWater() {
        int rd = (int) (Math.random() * 4);
        water.setY(-100);
        water.setX (16 + 216 * rd);
        water.setVelocityY(water.getVelocityY() + 5);
    }

    class Timer extends CountDownTimer {
        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (isItStart) update();
        }

        @Override
        public void onFinish() {
        }
    }
}







//package org.flum.tamagotchi;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.os.CountDownTimer;
//import android.view.View;
//
//public class DrawMiniGame extends View {
//
//    Timer timer = new Timer();
//
//    public static Rect firstFrame;
//    public static Canvas canvas = new Canvas();
//    public static Paint paint = new Paint();
//    float canvasH, canvasW, CW5, MOC;
//    GameSprite meteor;
//    public static Bitmap bMeteor;
//    public static int w;
//    public static int h;
//    public static int paddingLeft;
//
//    public DrawMiniGame(Context context) {
//        super(context);
//
//        bMeteor = BitmapFactory.decodeResource(getResources(), R.drawable.meteor);
//        w = bMeteor.getWidth();
//        h = bMeteor.getHeight();
//
//        paddingLeft = (int) (CW5 - w) /2;
//
//        firstFrame = new Rect(0, 0, w, h);
//        meteor = new GameSprite(CW5*4, 250, 0, 300, firstFrame, bMeteor);
//        meteor.addFrame(new Rect(w, h, w*2, h*2));
//
//        timer.start();
//
//        invalidate();
//        }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//
//        paint.setSubpixelText(true);
//        paint.setAntiAlias(true);
//
//        canvas.drawARGB(127, 0, 0, 255);
//        canvasH = canvas.getHeight();
//        canvasW = canvas.getWidth();
//        CW5 = canvasW / 5;
//        MOC = CW5 / 2;
//
//        canvas.drawLine(10, 0, 10, canvasH, paint);
//        canvas.drawLine(CW5 * 1, 0, CW5 * 1, canvasH, paint);
//        canvas.drawLine(CW5 * 2, 0, CW5 * 2, canvasH, paint);
//        canvas.drawLine(CW5 * 3, 0, CW5 * 3, canvasH, paint);
//        canvas.drawLine(CW5 * 4, 0, CW5 * 4, canvasH, paint);
//        canvas.drawLine(canvasW - 10, 0, canvasW - 10, canvasH, paint);
//        canvas.drawLine(10, canvasH - CW5, canvasW - 10, canvasH - CW5, paint);
//
//        meteor.draw(canvas);
//
//        invalidate();
//        super.onDraw(canvas);
//    }
//
//    public void update() {
//        meteor.update(60);
//        invalidate();
//    }
//
//
//
////    public void createMeteor() {
////        int rd = (int) (Math.random() * 4);
////
////        meteor = new Sprite(MOC*4 + paddingLeft, 0, 0, -300, firstFrame, bMeteor);
////        System.out.println("DRAWED");
////        System.out.println("x = " + MOC*2 + " y = " + canvas.getHeight());
////    }
//
//    class Timer extends CountDownTimer {
//
//        public Timer() {
//            super(Integer.MAX_VALUE, 60);
//        }
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//            update();
//            invalidate();
//        }
//        @Override
//        public void onFinish() {
//
//        }
//    }
//
//}
