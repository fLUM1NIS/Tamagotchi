package org.flum.tamagotchi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class test extends View {

    public test(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.scale(300, 200);

        canvas.drawText("1010", 0, 0, paint);
        canvas.drawColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        //paint.setTextScaleX(30);
        canvas.drawLine(0, 0, 100, 100, paint);
        canvas.drawCircle(100, 100, 50000, paint);
        canvas.drawText("HELLO MEN", 10, 10, paint);

    }
}
