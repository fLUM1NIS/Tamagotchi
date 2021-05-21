package org.flum.tamagotchi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DrawMiniGame extends View {
    public DrawMiniGame(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);

        canvas.drawARGB(127,0,0,255);

        super.onDraw(canvas);
    }
}
