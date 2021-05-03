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


//    TextView indicators = findViewById(R.id.indicators);

    private int scoreMore = 0; //240

    Person person = new Person();

    //example to create new color
    // int myTransparentBlue = Color.argb(127, 0, 0, 255);


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawARGB(250, 127, 199, 255); // цвет фона
        canvas.drawColor(Color.WHITE);
        player.draw(canvas);


        Paint paint = new Paint();

//        canvas.drawText("ddec", 0, 0, paint);

        String st = "ferht";
        //canvas.drawText(String.valueOf(person.getHealth()), 0, 0, paint);
//        player1.draw(canvas);



        //player = new Sprite(getWidth()/4, getHeight() / 3, 0, 10, firstFrame, b);

        y = getWidth() / 2;
        x = getHeight() / 3 * 2;


    }

    protected void update () {
        player.update(timerInterval);
        invalidate();
    }

    public DrawPerson(Context context) {

        super(context);


        b = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_person);
//        Bitmap b1 = BitmapFactory.decodeResource(getResources(), R.drawable.kitchen);

        int w = b.getWidth()/4;
        int h = b.getHeight()/4;

//        int w1 = b.getWidth()*4;
//        int h1 = b.getHeight()*4;


        firstFrame = new Rect(0, 0, w, h);

        //if ()

//        player1 = new Sprite(100, 100, 0, 0, firstFrame, b1);
        player = new Sprite(0, 0, 0, 0, firstFrame, b);

        // this isn't work
        // i need to move this down


        Timer t = new Timer();
        t.start();

        // // //
        // // //

        if (scoreMore == 4) {
            for (int i = 0; i < 100; i++) {
                y+=5;
            }
        }
        if (scoreMore == 1) {
            for (int i = 0; i < 100; i++) {
                y-=5;
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
//                if (j == 1 || j == 2 || j == 3 || j ==4) {
//                    continue;
//                }
                player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
//                player1.addFrame(new Rect(j * w1, i * h1, j * w1 + w1, i * w1 + w1));
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
            //savData();
        }
    }



//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        Paint paint = new Paint();
//
//        paint.setSubpixelText(true);
//        paint.setAntiAlias(true);
//
//        paint.setColor(color_green);
//        canvas.drawPaint(paint);
//
//    }
//
//    public DrawPerson(Context context) {
//        super(context);
//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.tamagotchi_person);
//        int w = b.getWidth() / 4;
//        int h = b.getHeight() / 4;
//        Rect firstFrame = new Rect(0, 0, w, h);
//        player = new Sprite(10, 0, 0, 100, firstFrame, b);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                player.addFrame(new Rect(j * w, i * h, j * w + w, i * w + w));
//            }
//        }
//        Timer t = new Timer();
//        t.start();
//    }
//
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        viewWidth = w;
//        viewHeight = h;
//    }
//
//    protected void update() {
//        player.update(timerInterval);
//    }
//
//    @Override
//    public void invalidate() {
//        super.invalidate();
//    }
//
//
//    class Timer extends CountDownTimer {
//        public Timer() {
//            super(Integer.MAX_VALUE, 30);
//        }
//
//        @Override
//        public void onTick(long millisUntilFinished) {
//            update();
//        }
//
//        @Override
//        public void onFinish() {
//        }
//    }

    public static class OtherView {
    }
}