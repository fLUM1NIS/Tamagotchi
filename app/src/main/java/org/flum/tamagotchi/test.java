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
        canvas.scale(100, 100);

        canvas.drawText("fevc", 0, 0, paint);
    }
}
