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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DrawPerson extends View {

    int color_blue = Color.BLUE;
    int color_red = Color.RED;
    int color_green = Color.GREEN;
    int color_white = Color.WHITE;
    int color_yellow = Color.YELLOW;
    int color_grey = Color.GRAY;

    private Sprite player;
    private Sprite player1;
    private int viewWidth;
    private int viewHeight;
    private int points = 0;
    private final int timerInterval = 480;
    private int velocityY;
    private int y, x;

    Bitmap b;
    Rect firstFrame;

    public int c = 0;

    private int scoreMore = 0; //240

    Person person = new Person();

    //example to create new color
    // int myTransparentBlue = Color.argb(127, 0, 0, 255);

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

        int w = b.getWidth()/4;
        int h = b.getHeight()/4;

        firstFrame = new Rect(0, 0, w, h);

        player = new Sprite(0, 0, 0, 0, firstFrame, b);

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
                    player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
                }
            }
        }

        if (Person.status == 2) {
            for (int i = 0; i < 2 && i != 1; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
//                if (j == 1 || j == 2 || j == 3 || j ==4) {
//                    continue;
//                }
                    player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
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