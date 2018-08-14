package cnhh.lvtn.bangtuanhoan.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class RandomCircles extends View {

    private static final float RADIUS_ATOM = 50;
    private static final float RADIUS_PROTON = 25;
    private static final float RADIUS_ELECTRON = 10;
    private static final int ODD = 180;
    private static final int EVEN = 90;

    private float mWidth;
    private float mHeight;

    private Paint mPaintAtom;
    private Paint mPaintElectron;
    private TextPaint mTextPaint;

    private Animation animation;

    public RandomCircles(Context context) {
        super(context);

        mPaintAtom = new Paint();
        mPaintAtom.setColor(Color.BLACK);
        mPaintAtom.setStyle(Paint.Style.STROKE);
        mPaintAtom.setStrokeWidth(4f);

        mPaintElectron = new Paint();
        mPaintElectron.setColor(Color.BLACK);
        mPaintElectron.setStrokeWidth(4f);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(25);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mWidth = getWidth() / 2.0f;
        mHeight = getHeight() / 2.0f;

        //Draw Proton
        canvas.drawCircle(mWidth, mHeight, RADIUS_PROTON, mPaintElectron);

        drawAtomStruct("S2 P6 D1", canvas);

        if (animation == null) {
            initAnimation();
        }

        //Draw Name Atom
        Rect textBounds = new Rect();
        String text = "Au";
        mTextPaint.getTextBounds(text, 0, text.length(), textBounds);
        canvas.drawText(text, mWidth - textBounds.exactCenterX(), mHeight - textBounds.exactCenterY(), mTextPaint);

    }

    private void initAnimation() {
        animation = new RotateAnimation(0, 360, mWidth, mHeight);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.RESTART);
        animation.setDuration(7500L);
        animation.setInterpolator(new LinearInterpolator());
        startAnimation(animation);
    }

    private void drawWithNumberElectron(int num, int border, Canvas canvas) {

        int style = border % 2  != 0 ? ODD : EVEN;

        for (int i = 1; i <= num; i++) {
            int angle = i * (360 / num);
            float x = (float) (mWidth + RADIUS_ATOM * border * cos(Math.toRadians(angle - style)));
            float y = (float) (mHeight + RADIUS_ATOM * border * sin(Math.toRadians(angle - style)));
            canvas.drawCircle(x, y, RADIUS_ELECTRON, mPaintElectron);
        }
    }

    private void drawAtomStruct(String structure, Canvas canvas) {

        String atoms[] = structure.split(" ");

        for (int i = 0; i < atoms.length; i++) {

            int border = i + 1;
            //Draw border
            canvas.drawCircle(mWidth, mHeight, RADIUS_ATOM * border, mPaintAtom);

            String electrons = atoms[i].substring(1);
            int num = Integer.parseInt(electrons);
            drawWithNumberElectron(num, border, canvas);
        }
    }
}