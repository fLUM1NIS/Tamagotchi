package org.flum.tamagotchi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.view.View;

import java.util.Timer;

public class DrawPerson extends View {

    DrawMiniGame drawMiniGame = new DrawMiniGame(getContext());

    private static Sprite player;
    private static final int timerInterval = 480;
    private int y, x;


    public static Bitmap b;
    public static int w;
    public static int h;


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        player.draw(canvas);

        Paint paint = new Paint();

        y = getWidth() / 2;
        x = getHeight() / 3 * 2;
    }


    protected void update() {
        player.update(timerInterval);
        invalidate();
    }

    public DrawPerson(Context context) {

        super(context);

        b = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_person);
        w = b.getWidth() / 4;
        h = b.getHeight() / 4;

        Rect firstFrame = new Rect(0, 0, w, h);
        player = new Sprite(0, 0, 0, 0, firstFrame, b);
        if (Person.status == 1) {
            for (int j = 0; j < 4; j++) {
                player.addFrame(new Rect(j * w, 0 * h, j * w + w, 0 * w + w));
            }
        }

        if (Person.status == 2) {
            for (int j = 0; j < 4; j++) {
                player.addFrame(new Rect(j * w, 1 * h, j * w + w, 1 * w + w));
            }
        }


//        if (Person.status == 1) {
//            for (int i = 0; i < 1; i++) {
//                for (int j = 0; j < 4; j++) {
//                    if (i == 0 && j == 0) {
//                        continue;
//                    }
////                if (j == 1 || j == 2 || j == 3 || j ==4) {
////                    continue;
////                }
//                    player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
//                }
//            }


        Timer t = new Timer();
        t.start();
        invalidate();
    }

    class Timer extends CountDownTimer {

        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            update();
        }

        @Override
        public void onFinish() {

        }
    }
}