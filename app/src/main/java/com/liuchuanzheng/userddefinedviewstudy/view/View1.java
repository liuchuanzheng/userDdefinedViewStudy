package com.liuchuanzheng.userddefinedviewstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 刘传政
 * @date 2019/1/28 0028 10:53
 * QQ:1052374416
 * 电话:18501231486
 * 作用:
 * 注意事项:
 */
public class View1 extends View {
    Paint paint = new Paint();

    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        // Style 修改为画线模式
        paint.setStyle(Paint.Style.STROKE);
        // 线条宽度为 20 像素
        paint.setStrokeWidth(20);
        // 抗锯齿
        paint.setAntiAlias(true);
        // 绘制一个圆
        canvas.drawColor(Color.GREEN);
        canvas.drawCircle(500, 300, 200, paint);
        //绘制一个矩形
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(100, 600, 500, 900, paint);
        //绘制一个点
        paint.setStrokeWidth(20);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(20, 20, paint);
        //绘制一系列点
        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                8 /* 一共绘制 8 个数（4 个点）*/, paint);
        //绘制椭圆
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(600, 600, 850, 900, paint);
        //绘制线
        canvas.drawLine(200, 200, 800, 500, paint);
        //绘制多条线
        float[] points2 = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120,
                150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        canvas.drawLines(points2, paint);
        //绘制圆角矩形
        canvas.drawRoundRect(100, 1200, 500, 1400, 50, 50, paint);
        //绘制弧形或扇形
        /*
        * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
        * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        * sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
        * */
        paint.setStyle(Paint.Style.FILL); // 填充模式
        canvas.drawArc(200, 1400, 800, 1800, -90, 90, true, paint); // 绘制扇形
        canvas.drawArc(50, 1400, 200, 1800, 30, 140, false, paint); // 绘制弧形
        paint.setStyle(Paint.Style.STROKE); // 画线模式
        canvas.drawArc(200, 1400, 800, 1800, 180, 60, false, paint); // 绘制不封口的弧形
    }
}
