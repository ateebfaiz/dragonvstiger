package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import fb.b;

public class HorizontalProgressWheelView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f11851a;

    /* renamed from: b  reason: collision with root package name */
    private a f11852b;

    /* renamed from: c  reason: collision with root package name */
    private float f11853c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f11854d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f11855e;

    /* renamed from: f  reason: collision with root package name */
    private int f11856f;

    /* renamed from: g  reason: collision with root package name */
    private int f11857g;

    /* renamed from: h  reason: collision with root package name */
    private int f11858h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11859i;

    /* renamed from: j  reason: collision with root package name */
    private float f11860j;

    /* renamed from: w  reason: collision with root package name */
    private int f11861w;

    public interface a {
        void a();

        void b(float f10, float f11);

        void c();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f11861w = ContextCompat.getColor(getContext(), fb.a.f12094m);
        this.f11856f = getContext().getResources().getDimensionPixelSize(b.f12103i);
        this.f11857g = getContext().getResources().getDimensionPixelSize(b.f12100f);
        this.f11858h = getContext().getResources().getDimensionPixelSize(b.f12101g);
        Paint paint = new Paint(1);
        this.f11854d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f11854d.setStrokeWidth((float) this.f11856f);
        this.f11854d.setColor(getResources().getColor(fb.a.f12088g));
        Paint paint2 = new Paint(this.f11854d);
        this.f11855e = paint2;
        paint2.setColor(this.f11861w);
        this.f11855e.setStrokeCap(Paint.Cap.ROUND);
        this.f11855e.setStrokeWidth((float) getContext().getResources().getDimensionPixelSize(b.f12104j));
    }

    private void b(MotionEvent motionEvent, float f10) {
        this.f11860j -= f10;
        postInvalidate();
        this.f11853c = motionEvent.getX();
        a aVar = this.f11852b;
        if (aVar != null) {
            aVar.b(-f10, this.f11860j);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f11851a);
        int width = this.f11851a.width();
        int i10 = this.f11856f;
        int i11 = this.f11858h;
        int i12 = width / (i10 + i11);
        float f10 = this.f11860j % ((float) (i11 + i10));
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i12 / 4;
            if (i13 < i14) {
                this.f11854d.setAlpha((int) ((((float) i13) / ((float) i14)) * 255.0f));
            } else if (i13 > (i12 * 3) / 4) {
                this.f11854d.setAlpha((int) ((((float) (i12 - i13)) / ((float) i14)) * 255.0f));
            } else {
                this.f11854d.setAlpha(255);
            }
            float f11 = -f10;
            Rect rect = this.f11851a;
            float f12 = ((float) rect.left) + f11 + ((float) ((this.f11856f + this.f11858h) * i13));
            float centerY = ((float) rect.centerY()) - (((float) this.f11857g) / 4.0f);
            Rect rect2 = this.f11851a;
            canvas.drawLine(f12, centerY, f11 + ((float) rect2.left) + ((float) ((this.f11856f + this.f11858h) * i13)), ((float) rect2.centerY()) + (((float) this.f11857g) / 4.0f), this.f11854d);
        }
        float centerX = (float) this.f11851a.centerX();
        float centerY2 = ((float) this.f11851a.centerY()) - (((float) this.f11857g) / 2.0f);
        Canvas canvas2 = canvas;
        float f13 = centerY2;
        canvas2.drawLine(centerX, f13, (float) this.f11851a.centerX(), (((float) this.f11857g) / 2.0f) + ((float) this.f11851a.centerY()), this.f11855e);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f11853c = motionEvent.getX();
        } else if (action == 1) {
            a aVar = this.f11852b;
            if (aVar != null) {
                this.f11859i = false;
                aVar.a();
            }
        } else if (action == 2) {
            float x10 = motionEvent.getX() - this.f11853c;
            if (x10 != 0.0f) {
                if (!this.f11859i) {
                    this.f11859i = true;
                    a aVar2 = this.f11852b;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
                b(motionEvent, x10);
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i10) {
        this.f11861w = i10;
        this.f11855e.setColor(i10);
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.f11852b = aVar;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11851a = new Rect();
        a();
    }
}
