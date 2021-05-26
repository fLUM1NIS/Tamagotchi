package org.flum.tamagotchi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Sprite{

    private static Bitmap bitmap;
    private static List<Rect> frames;
    private static int frameWidth;
    private static int frameHeight;
    private static int currentFrame;
    private static double frameTime;
    private static double timeForCurrentFrame;

    private static double x;
    private static double y;

    private static double velocityX;
    private static double velocityY;

    private static int padding;

    public Sprite(double x, double y, double velocityX, double velocityY,  Rect initialFrame, Bitmap bitmap){

        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.bitmap = bitmap;
        this.frames = new ArrayList<Rect>();
        this.frames.add(initialFrame);
        this.bitmap = bitmap;
        this.timeForCurrentFrame = 0.0;
        this.frameTime = 0.1;
        this.currentFrame = 0;
        this.frameWidth = initialFrame.width();
        this.frameHeight = initialFrame.height();
        this.padding = 20;
    }

    public void addFrame (Rect frame) {
        frames.add(frame);
    }

    public static void update (int ms) {

        timeForCurrentFrame += ms;

        if (timeForCurrentFrame >= frameTime) {
            currentFrame = (currentFrame + 1) % frames.size();
            timeForCurrentFrame = timeForCurrentFrame - frameTime;
        }

        x = x;
        y = y + velocityY * ms/1000.0;
    }


    public void draw (Canvas canvas) {
        Paint p = new Paint();
        Rect destination = new Rect((int) x, (int) y, (int) (x + frameWidth), (int) (y + frameHeight));
        canvas.drawBitmap(bitmap, frames.get(currentFrame), destination, p);
    }
}
