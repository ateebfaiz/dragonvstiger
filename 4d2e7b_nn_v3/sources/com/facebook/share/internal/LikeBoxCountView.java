package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;

@Deprecated
public class LikeBoxCountView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f4391a;

    /* renamed from: b  reason: collision with root package name */
    private b f4392b = b.LEFT;

    /* renamed from: c  reason: collision with root package name */
    private float f4393c;

    /* renamed from: d  reason: collision with root package name */
    private float f4394d;

    /* renamed from: e  reason: collision with root package name */
    private float f4395e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f4396f;

    /* renamed from: g  reason: collision with root package name */
    private int f4397g;

    /* renamed from: h  reason: collision with root package name */
    private int f4398h;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4399a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.share.internal.LikeBoxCountView$b[] r0 = com.facebook.share.internal.LikeBoxCountView.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4399a = r0
                com.facebook.share.internal.LikeBoxCountView$b r1 = com.facebook.share.internal.LikeBoxCountView.b.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.share.internal.LikeBoxCountView$b r1 = com.facebook.share.internal.LikeBoxCountView.b.TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.share.internal.LikeBoxCountView$b r1 = com.facebook.share.internal.LikeBoxCountView.b.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4399a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.share.internal.LikeBoxCountView$b r1 = com.facebook.share.internal.LikeBoxCountView.b.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.LikeBoxCountView.a.<clinit>():void");
        }
    }

    public enum b {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public LikeBoxCountView(Context context) {
        super(context);
        b(context);
    }

    private void a(Canvas canvas, float f10, float f11, float f12, float f13) {
        Path path = new Path();
        float f14 = this.f4395e * 2.0f;
        float f15 = f10 + f14;
        float f16 = f11 + f14;
        path.addArc(new RectF(f10, f11, f15, f16), -180.0f, 90.0f);
        if (this.f4392b == b.TOP) {
            float f17 = f12 - f10;
            path.lineTo(((f17 - this.f4394d) / 2.0f) + f10, f11);
            path.lineTo((f17 / 2.0f) + f10, f11 - this.f4393c);
            path.lineTo(((f17 + this.f4394d) / 2.0f) + f10, f11);
        }
        path.lineTo(f12 - this.f4395e, f11);
        float f18 = f12 - f14;
        path.addArc(new RectF(f18, f11, f12, f16), -90.0f, 90.0f);
        if (this.f4392b == b.RIGHT) {
            float f19 = f13 - f11;
            path.lineTo(f12, ((f19 - this.f4394d) / 2.0f) + f11);
            path.lineTo(this.f4393c + f12, (f19 / 2.0f) + f11);
            path.lineTo(f12, ((f19 + this.f4394d) / 2.0f) + f11);
        }
        path.lineTo(f12, f13 - this.f4395e);
        float f20 = f13 - f14;
        path.addArc(new RectF(f18, f20, f12, f13), 0.0f, 90.0f);
        if (this.f4392b == b.BOTTOM) {
            float f21 = f12 - f10;
            path.lineTo(((this.f4394d + f21) / 2.0f) + f10, f13);
            path.lineTo((f21 / 2.0f) + f10, this.f4393c + f13);
            path.lineTo(((f21 - this.f4394d) / 2.0f) + f10, f13);
        }
        path.lineTo(this.f4395e + f10, f13);
        path.addArc(new RectF(f10, f20, f15, f13), 90.0f, 90.0f);
        if (this.f4392b == b.LEFT) {
            float f22 = f13 - f11;
            path.lineTo(f10, ((this.f4394d + f22) / 2.0f) + f11);
            path.lineTo(f10 - this.f4393c, (f22 / 2.0f) + f11);
            path.lineTo(f10, ((f22 - this.f4394d) / 2.0f) + f11);
        }
        path.lineTo(f10, f11 + this.f4395e);
        canvas.drawPath(path, this.f4396f);
    }

    private void b(Context context) {
        setWillNotDraw(false);
        this.f4393c = getResources().getDimension(u2.b.f24271c);
        this.f4394d = getResources().getDimension(u2.b.f24272d);
        this.f4395e = getResources().getDimension(u2.b.f24269a);
        Paint paint = new Paint();
        this.f4396f = paint;
        paint.setColor(getResources().getColor(u2.a.f24266b));
        this.f4396f.setStrokeWidth(getResources().getDimension(u2.b.f24270b));
        this.f4396f.setStyle(Paint.Style.STROKE);
        c(context);
        addView(this.f4391a);
        setCaretPosition(this.f4392b);
    }

    private void c(Context context) {
        this.f4391a = new TextView(context);
        this.f4391a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4391a.setGravity(17);
        this.f4391a.setTextSize(0, getResources().getDimension(u2.b.f24274f));
        this.f4391a.setTextColor(getResources().getColor(u2.a.f24267c));
        this.f4397g = getResources().getDimensionPixelSize(u2.b.f24273e);
        this.f4398h = getResources().getDimensionPixelSize(u2.b.f24271c);
    }

    private void d(int i10, int i11, int i12, int i13) {
        TextView textView = this.f4391a;
        int i14 = this.f4397g;
        textView.setPadding(i10 + i14, i11 + i14, i12 + i14, i14 + i13);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i10 = a.f4399a[this.f4392b.ordinal()];
        if (i10 == 1) {
            paddingLeft = (int) (((float) paddingLeft) + this.f4393c);
        } else if (i10 == 2) {
            paddingTop = (int) (((float) paddingTop) + this.f4393c);
        } else if (i10 == 3) {
            width = (int) (((float) width) - this.f4393c);
        } else if (i10 == 4) {
            height = (int) (((float) height) - this.f4393c);
        }
        a(canvas, (float) paddingLeft, (float) paddingTop, (float) width, (float) height);
    }

    @Deprecated
    public void setCaretPosition(b bVar) {
        this.f4392b = bVar;
        int i10 = a.f4399a[bVar.ordinal()];
        if (i10 == 1) {
            d(this.f4398h, 0, 0, 0);
        } else if (i10 == 2) {
            d(0, this.f4398h, 0, 0);
        } else if (i10 == 3) {
            d(0, 0, this.f4398h, 0);
        } else if (i10 == 4) {
            d(0, 0, 0, this.f4398h);
        }
    }

    @Deprecated
    public void setText(String str) {
        this.f4391a.setText(str);
    }
}
