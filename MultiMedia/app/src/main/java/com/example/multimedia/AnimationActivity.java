
package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class AnimationActivity extends AppCompatActivity {
    DemoView demoview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demoview = new DemoView(this);
        setContentView(demoview);
    }
    private class DemoView extends View {
        public DemoView(Context context){
            super(context);
        }
        @Override protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setAntiAlias(false);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(200, 200, 150, paint);
            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            canvas.drawCircle(600, 200, 150, paint);
            paint.setAntiAlias(false);
            paint.setColor(Color.RED);
            canvas.drawRect(800, 1000, 100, 500, paint);
//            RectF oval1 = new RectF(0, 0, 250,250);
//            canvas.drawOval(oval1, paint);

            canvas.rotate(-45);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawText("Graphics Rotation", 40, 180, paint);
        }
    }
}

