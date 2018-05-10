package com.wazert.myblog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.wazert.myblog.R;

/**
 * @author zhaozhuo
 * @date 2018/3/7 15:53
 */

public class CircleView extends View {

    private int mCoclor = Color.RED;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    private void init() {
        paint.setColor(mCoclor);
    }

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mCoclor = array.getColor(R.styleable.CircleView_circle_color,Color.RED);
        array.recycle();
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int wsm = MeasureSpec.getMode(widthMeasureSpec);
        int wss = MeasureSpec.getSize(widthMeasureSpec);
        int hsm = MeasureSpec.getMode(heightMeasureSpec);
        int hss = MeasureSpec.getSize(heightMeasureSpec);

        if(wsm ==MeasureSpec.AT_MOST && hsm ==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,200);
        }else  if(wsm ==MeasureSpec.AT_MOST){
            setMeasuredDimension(200,hss);
        }else if(hsm == MeasureSpec.AT_MOST){
            setMeasuredDimension(wss,200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int pl = getPaddingLeft();
        final int pr = getPaddingRight();
        final int pb = getPaddingBottom();
        final int pt = getPaddingTop();

        int width = getWidth() -pl-pr;
        int height = getHeight()-pt-pb;
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(pl+width /2, pt+height / 2, radius, paint);
    }
}
