package com.brioal.lzuwelcome.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.brioal.baselib.util.SizeUtil;
import com.brioal.lzuwelcome.R;
import com.github.lzyzsd.randomcolor.RandomColor;

import java.util.Random;

/**
 * 梯形View
 * Created by Brioal on 2016/8/17.
 */

public class TraView extends View {
    private Paint mPaint;
    private int mColor;
    private boolean isLeft;
    private int mIndex;

    public TraView(Context context) {
        this(context, null);
    }

    public TraView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TraView);
        isLeft = array.getBoolean(R.styleable.TraView_isleft, true);
        array.recycle();
        init();
    }

    public void setIndex(int index) {
        mIndex = index;
    }

    private void init() {
        RandomColor randomColor = new RandomColor();
        mColor = randomColor.random(RandomColor.Color.ORANGE, 20)[new Random().nextInt(19)];

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mColor);
        mIndex = 1;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) (SizeUtil.Dp2Px(getContext(), 40)), (int) SizeUtil.Dp2Px(getContext(), 100));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        mPaint.setColor(mColor);
        mPaint.setPathEffect(new CornerPathEffect(10));
        if (isLeft) { //朝向左边
            path.moveTo(getWidth(), 0);
            path.lineTo(0, SizeUtil.Dp2Px(getContext(), 30));
            path.lineTo(0, getHeight() - SizeUtil.Dp2Px(getContext(), 30));
            path.lineTo(getWidth(), getHeight());
            path.close();
        } else { //朝向右边
            path.moveTo(0, 0);
            path.lineTo(getWidth(), SizeUtil.Dp2Px(getContext(), 30));
            path.lineTo(getWidth(), getHeight() - SizeUtil.Dp2Px(getContext(), 30));
            path.lineTo(0, getHeight());
            path.close();
        }
        canvas.drawPath(path, mPaint);
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        String text = mIndex + "";
        mPaint.setTextSize(SizeUtil.Sp2Px(getContext(), 30));
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        mPaint.setColor(Color.WHITE);
        canvas.drawText(text, -(rect.right - rect.left) / 2, (rect.bottom - rect.top) / 2, mPaint);
        canvas.restore();
    }
}
