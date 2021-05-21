package org.flum.tamagotchi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.View;

public class DrawPerson extends View {

    int color_blue = Color.BLUE;
    int color_red = Color.RED;
    int color_green = Color.GREEN;
    int color_white = Color.WHITE;
    int color_yellow = Color.YELLOW;
    int color_grey = Color.GRAY;

    private Sprite playerGood;
    private Sprite playerNormal;
    private Sprite playerBad;
    private Sprite playerAwful;
    private Sprite playerDead;
    private int points = 0;
    private final int timerInterval = 480;
    private int velocityY;
    private int y, x;

    Bitmap bGood;
    Bitmap bNormal;
    Bitmap bBad;
    Bitmap bAwful;
    Bitmap bDead;
    Rect firstFrame;

    public int c = 0;

    private int scoreMore = 0; //240

    Person person = new Person();

    //example to create new color
    // int myTransparentBlue = Color.argb(127, 0, 0, 255);

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        playerGood.draw(canvas);

        Paint paint = new Paint();

        y = getWidth() / 2;
        x = getHeight() / 3 * 2;
    }

    protected void update() {
        playerGood.update(timerInterval);
        invalidate();
    }

    public DrawPerson(Context context) {

        super(context);

        bGood = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_person);
        bNormal = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_person);

        int wGood = bGood.getWidth()/4;
        int hGood = bGood.getHeight()/ 4;

        int wNormal = bNormal.getWidth()/4;
        int hNormal = bNormal.getHeight()/ 4;

//        int wBad = bBad.getWidth()/4;
//        int hBad = bBad.getHeight();
//
//        int wAwful = bAwful.getWidth()/4;
//        int hAwful = bAwful.getHeight();
//
//        int wDead = bDead.getWidth();
//        int hDead = bDead.getHeight();

        firstFrame = new Rect(0, 0, wGood, hGood);

        playerGood = new Sprite(0, 0, 0, 0, firstFrame, bGood);
        playerNormal = new Sprite(0, 0, 0, 0, firstFrame, bNormal);
        playerBad = new Sprite(0, 0, 0, 0, firstFrame, bBad);
        playerAwful = new Sprite(0, 0, 0, 0, firstFrame, bAwful);
        playerDead = new Sprite(0, 0, 0, 0, firstFrame, bDead);


        Timer t = new Timer();
        t.start();

        // i - height
        // j - width

        // i до 1
        // j до 4

        if (Person.status == 1) {
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
//                if (j == 1 || j == 2 || j == 3 || j ==4) {
//                    continue;
//                }
                    playerGood.addFrame(new Rect(j * wGood, i * hGood, j * wGood + wGood, i * wGood + wGood));
                    invalidate();
                }
            }
        }

//        if (Person.status == 1) {
//            for (int j = 0; j < 5; j++) {
//                // playerGood.addFrame(new Rect(wGood, i * hGood, wGood + wGood, i * wGood + wGood));
//                if (j == 0) continue;
//                playerGood.addFrame(new Rect(j * wGood, hGood, j * wGood + wGood, wGood + wGood));
//            }
//        }
//
//        if (Person.status == 2) {
//            for (int j = 0; j < 5; j++) {
//                playerNormal.addFrame(new Rect(j * wNormal, hNormal, j * wNormal + wNormal, wNormal + wNormal));
//            }
//        }

        if (Person.status == 2) {
            for (int i = 0; i < 2 && i != 1; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
//                if (j == 1 || j == 2 || j == 3 || j ==4) {
//                    continue;
//                }
                    playerNormal.addFrame(new Rect(j * wNormal, i * hNormal, j * wNormal + wNormal, i * wNormal + wNormal));
                    invalidate();
                }
            }
        }



        invalidate();
    }

    class Timer extends CountDownTimer {

        public Timer() {
            super(Integer.MAX_VALUE, timerInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            update();
            scoreMore++;
        }

        @Override
        public void onFinish() {

        }
    }
}