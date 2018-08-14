package cnhh.lvtn.bangtuanhoan.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RandomCircles extends View {

    private static final float RADIUS_ATOM = 50;
    private static final float RADIUS_PROTON = 25;
    private static final float RADIUS_ELECTRON = 10;

    private float mWidth;
    private float mHeight;

    private Paint mPaintAtom;
    private Paint mPaintElectron;

    public RandomCircles(Context context) {
        super(context);

        mPaintAtom = new Paint();
        mPaintAtom.setColor(Color.BLACK);
        mPaintAtom.setStyle(Paint.Style.STROKE);
        mPaintAtom.setStrokeWidth(4f);

        mPaintElectron = new Paint();
        mPaintElectron.setColor(Color.BLACK);
        mPaintElectron.setStrokeWidth(4f);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mWidth = getWidth() / 2.0f;
        mHeight = getHeight() / 2.0f;

        //Draw Proton
        canvas.drawCircle(mWidth, mHeight, RADIUS_PROTON, mPaintElectron);

        //Draw border
        canvas.drawCircle(mWidth, mHeight, RADIUS_ATOM, mPaintAtom);
        canvas.drawCircle(mWidth, mHeight, RADIUS_ATOM * 2, mPaintAtom);
        canvas.drawCircle(mWidth, mHeight, RADIUS_ATOM * 3, mPaintAtom);

        //Draw Electron
        canvas.drawCircle(mWidth, mHeight - RADIUS_ATOM, RADIUS_ELECTRON, mPaintElectron);
        canvas.drawCircle(mWidth, mHeight + RADIUS_ATOM, RADIUS_ELECTRON, mPaintElectron);

    }
}