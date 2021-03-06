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

import org.flum.tamagotchi.ui.main.Sprite;

import java.util.Timer;

public class DrawPerson extends View {

    int color_blue = Color.BLUE;
    int color_red = Color.RED;
    int color_green = Color.GREEN;
    int color_white = Color.WHITE;
    int color_yellow = Color.YELLOW;
    int color_grey = Color.GRAY;

    private Sprite player;
    private int viewWidth;
    private int viewHeight;
    private int points = 0;
    private final int timerInterval = 30;


    //example to create new color
    // int myTransparentBlue = Color.argb(127, 0, 0, 255);


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        paint.setSubpixelText(true);
        paint.setAntiAlias(true);

        paint.setColor(color_green);
        canvas.drawPaint(paint);

    }

    public DrawPerson(Context context) {
        super(context);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_person);
        int w = b.getWidth() / 4;
        int h = b.getHeight() / 4;
        Rect firstFrame = new Rect(0, 0, w, h);
        player = new Sprite(10, 0, 0, 100, firstFrame, b);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
            }
        }
        Timer t = new Timer();
        t.start();
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    protected void update() {
        player.update(timerInterval);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }


    class Timer extends CountDownTimer {
        public Timer() {
            super(Integer.MAX_VALUE, 30);
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