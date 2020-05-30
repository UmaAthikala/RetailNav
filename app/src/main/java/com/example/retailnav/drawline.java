package com.example.retailnav;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

class drawline extends View {
    Paint paint = new Paint();
    int x1,y1,x2,y2;
    public drawline(Context context,int x1_val,int y1_val,int x2_val,int y2_val ) {
        super(context);
        paint.setColor(Color.BLACK);
        x1=x1_val;
        y1=y1_val;
        x2=x2_val;
        y2=y2_val;
    }
    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(100, 50, 100, 500, paint);
    }

}