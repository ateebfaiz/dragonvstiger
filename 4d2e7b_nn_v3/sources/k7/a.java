package k7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.c1;
import com.facebook.react.uimanager.n;
import com.facebook.react.uimanager.x;
import com.facebook.react.uimanager.y;
import java.util.Locale;
import java.util.Objects;
import m7.c;

public class a extends Drawable {
    private final Context A;
    private int B = -1;

    /* renamed from: a  reason: collision with root package name */
    private c1 f12471a;

    /* renamed from: b  reason: collision with root package name */
    private c1 f12472b;

    /* renamed from: c  reason: collision with root package name */
    private c1 f12473c;

    /* renamed from: d  reason: collision with root package name */
    private b f12474d;

    /* renamed from: e  reason: collision with root package name */
    private Path f12475e;

    /* renamed from: f  reason: collision with root package name */
    private Path f12476f;

    /* renamed from: g  reason: collision with root package name */
    private Path f12477g;

    /* renamed from: h  reason: collision with root package name */
    private Path f12478h;

    /* renamed from: i  reason: collision with root package name */
    private Path f12479i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f12480j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private Path f12481k;

    /* renamed from: l  reason: collision with root package name */
    private RectF f12482l;

    /* renamed from: m  reason: collision with root package name */
    private RectF f12483m;

    /* renamed from: n  reason: collision with root package name */
    private RectF f12484n;

    /* renamed from: o  reason: collision with root package name */
    private RectF f12485o;

    /* renamed from: p  reason: collision with root package name */
    private PointF f12486p;

    /* renamed from: q  reason: collision with root package name */
    private PointF f12487q;

    /* renamed from: r  reason: collision with root package name */
    private PointF f12488r;

    /* renamed from: s  reason: collision with root package name */
    private PointF f12489s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f12490t = false;

    /* renamed from: u  reason: collision with root package name */
    private final Paint f12491u = new Paint(1);

    /* renamed from: v  reason: collision with root package name */
    private int f12492v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f12493w = 255;

    /* renamed from: x  reason: collision with root package name */
    private final float f12494x = 0.8f;

    /* renamed from: y  reason: collision with root package name */
    private m7.b f12495y = new m7.b();

    /* renamed from: z  reason: collision with root package name */
    private c f12496z = new c();

    /* renamed from: k7.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0147a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12497a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                k7.a$b[] r0 = k7.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12497a = r0
                k7.a$b r1 = k7.a.b.SOLID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12497a     // Catch:{ NoSuchFieldError -> 0x001d }
                k7.a$b r1 = k7.a.b.DASHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12497a     // Catch:{ NoSuchFieldError -> 0x0028 }
                k7.a$b r1 = k7.a.b.DOTTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k7.a.C0147a.<clinit>():void");
        }
    }

    private enum b {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect b(b bVar, float f10) {
            int i10 = C0147a.f12497a[bVar.ordinal()];
            if (i10 == 2) {
                float f11 = f10 * 3.0f;
                return new DashPathEffect(new float[]{f11, f11, f11, f11}, 0.0f);
            } else if (i10 != 3) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f10, f10, f10, f10}, 0.0f);
            }
        }
    }

    public a(Context context) {
        this.A = context;
    }

    private void B() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        if (this.f12490t) {
            this.f12490t = false;
            if (this.f12475e == null) {
                this.f12475e = new Path();
            }
            if (this.f12476f == null) {
                this.f12476f = new Path();
            }
            if (this.f12477g == null) {
                this.f12477g = new Path();
            }
            if (this.f12478h == null) {
                this.f12478h = new Path();
            }
            if (this.f12481k == null) {
                this.f12481k = new Path();
            }
            if (this.f12482l == null) {
                this.f12482l = new RectF();
            }
            if (this.f12483m == null) {
                this.f12483m = new RectF();
            }
            if (this.f12484n == null) {
                this.f12484n = new RectF();
            }
            if (this.f12485o == null) {
                this.f12485o = new RectF();
            }
            this.f12475e.reset();
            this.f12476f.reset();
            this.f12477g.reset();
            this.f12478h.reset();
            this.f12481k.reset();
            this.f12482l.set(getBounds());
            this.f12483m.set(getBounds());
            this.f12484n.set(getBounds());
            this.f12485o.set(getBounds());
            RectF j10 = j();
            int f20 = f(0);
            int f21 = f(1);
            int f22 = f(2);
            int f23 = f(3);
            int f24 = f(8);
            int f25 = f(9);
            int f26 = f(11);
            int f27 = f(10);
            if (p(9)) {
                f21 = f25;
                f23 = f21;
            }
            if (!p(10)) {
                f27 = f23;
            }
            if (!p(11)) {
                f26 = f21;
            }
            if (Color.alpha(f20) == 0 || Color.alpha(f26) == 0 || Color.alpha(f22) == 0 || Color.alpha(f27) == 0 || Color.alpha(f24) == 0) {
                f10 = 0.0f;
            } else {
                RectF rectF = this.f12482l;
                rectF.top += j10.top;
                rectF.bottom -= j10.bottom;
                rectF.left += j10.left;
                rectF.right -= j10.right;
                f10 = 0.8f;
            }
            RectF rectF2 = this.f12485o;
            rectF2.top += j10.top * 0.5f;
            rectF2.bottom -= j10.bottom * 0.5f;
            rectF2.left += j10.left * 0.5f;
            rectF2.right -= j10.right * 0.5f;
            c d10 = this.f12495y.d(getLayoutDirection(), this.A, this.f12483m.width(), this.f12483m.height());
            this.f12496z = d10;
            float c10 = d10.c();
            float d11 = this.f12496z.d();
            float a10 = this.f12496z.a();
            float b10 = this.f12496z.b();
            float max = Math.max(c10 - j10.left, 0.0f);
            float max2 = Math.max(c10 - j10.top, 0.0f);
            float max3 = Math.max(d11 - j10.right, 0.0f);
            float max4 = Math.max(d11 - j10.top, 0.0f);
            float max5 = Math.max(b10 - j10.right, 0.0f);
            float max6 = Math.max(b10 - j10.bottom, 0.0f);
            float max7 = Math.max(a10 - j10.left, 0.0f);
            float max8 = Math.max(a10 - j10.bottom, 0.0f);
            RectF rectF3 = j10;
            float f28 = a10;
            float f29 = b10;
            Path.Direction direction = Path.Direction.CW;
            this.f12475e.addRoundRect(this.f12482l, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, direction);
            Path path = this.f12476f;
            RectF rectF4 = this.f12482l;
            path.addRoundRect(rectF4.left - f10, rectF4.top - f10, rectF4.right + f10, rectF4.bottom + f10, new float[]{max, max2, max3, max4, max5, max6, max7, max8}, direction);
            this.f12477g.addRoundRect(this.f12483m, new float[]{c10, c10, d11, d11, f29, f29, f28, f28}, direction);
            c1 c1Var = this.f12471a;
            if (c1Var != null) {
                f11 = c1Var.a(8) / 2.0f;
            } else {
                f11 = 0.0f;
            }
            float f30 = c10 + f11;
            float f31 = d11 + f11;
            float f32 = f29 + f11;
            float f33 = f28 + f11;
            float f34 = max6;
            this.f12478h.addRoundRect(this.f12484n, new float[]{f30, f30, f31, f31, f32, f32, f33, f33}, direction);
            Path path2 = this.f12481k;
            RectF rectF5 = this.f12485o;
            RectF rectF6 = rectF3;
            float f35 = rectF6.left;
            float f36 = c10 - (f35 * 0.5f);
            if (f35 > 0.0f) {
                f12 = c10 / f35;
            } else {
                f12 = 0.0f;
            }
            float max9 = Math.max(f36, f12);
            float f37 = rectF6.top;
            float f38 = max5;
            float f39 = c10 - (f37 * 0.5f);
            if (f37 > 0.0f) {
                f13 = c10 / f37;
            } else {
                f13 = 0.0f;
            }
            float max10 = Math.max(f39, f13);
            float f40 = rectF6.right;
            float f41 = d11 - (f40 * 0.5f);
            if (f40 > 0.0f) {
                f14 = d11 / f40;
            } else {
                f14 = 0.0f;
            }
            float max11 = Math.max(f41, f14);
            float f42 = rectF6.top;
            float f43 = max4;
            float f44 = d11 - (f42 * 0.5f);
            if (f42 > 0.0f) {
                f15 = d11 / f42;
            } else {
                f15 = 0.0f;
            }
            float max12 = Math.max(f44, f15);
            float f45 = rectF6.right;
            float f46 = f29 - (f45 * 0.5f);
            if (f45 > 0.0f) {
                f16 = f29 / f45;
            } else {
                f16 = 0.0f;
            }
            float max13 = Math.max(f46, f16);
            float f47 = rectF6.bottom;
            float f48 = max3;
            float f49 = f29 - (f47 * 0.5f);
            if (f47 > 0.0f) {
                f17 = f29 / f47;
            } else {
                f17 = 0.0f;
            }
            float max14 = Math.max(f49, f17);
            float f50 = rectF6.left;
            float f51 = max7;
            float f52 = f28 - (f50 * 0.5f);
            if (f50 > 0.0f) {
                f18 = f28 / f50;
            } else {
                f18 = 0.0f;
            }
            float max15 = Math.max(f52, f18);
            float f53 = rectF6.bottom;
            float f54 = f28 - (f53 * 0.5f);
            if (f53 > 0.0f) {
                f19 = f28 / f53;
            } else {
                f19 = 0.0f;
            }
            path2.addRoundRect(rectF5, new float[]{max9, max10, max11, max12, max13, max14, max15, Math.max(f54, f19)}, direction);
            if (this.f12486p == null) {
                this.f12486p = new PointF();
            }
            PointF pointF = this.f12486p;
            PointF pointF2 = pointF;
            RectF rectF7 = this.f12482l;
            float f55 = rectF7.left;
            pointF.x = f55;
            float f56 = rectF7.top;
            pointF.y = f56;
            RectF rectF8 = this.f12483m;
            k((double) f55, (double) f56, (double) ((max * 2.0f) + f55), (double) ((max2 * 2.0f) + f56), (double) rectF8.left, (double) rectF8.top, (double) f55, (double) f56, pointF2);
            if (this.f12489s == null) {
                this.f12489s = new PointF();
            }
            PointF pointF3 = this.f12489s;
            PointF pointF4 = pointF3;
            RectF rectF9 = this.f12482l;
            float f57 = rectF9.left;
            pointF3.x = f57;
            float f58 = rectF9.bottom;
            pointF3.y = f58;
            RectF rectF10 = this.f12483m;
            k((double) f57, (double) (f58 - (max8 * 2.0f)), (double) ((f51 * 2.0f) + f57), (double) f58, (double) rectF10.left, (double) rectF10.bottom, (double) f57, (double) f58, pointF4);
            if (this.f12487q == null) {
                this.f12487q = new PointF();
            }
            PointF pointF5 = this.f12487q;
            PointF pointF6 = pointF5;
            RectF rectF11 = this.f12482l;
            float f59 = rectF11.right;
            pointF5.x = f59;
            float f60 = rectF11.top;
            pointF5.y = f60;
            RectF rectF12 = this.f12483m;
            k((double) (f59 - (f48 * 2.0f)), (double) f60, (double) f59, (double) ((f43 * 2.0f) + f60), (double) rectF12.right, (double) rectF12.top, (double) f59, (double) f60, pointF6);
            if (this.f12488r == null) {
                this.f12488r = new PointF();
            }
            PointF pointF7 = this.f12488r;
            PointF pointF8 = pointF7;
            RectF rectF13 = this.f12482l;
            float f61 = rectF13.right;
            pointF7.x = f61;
            float f62 = rectF13.bottom;
            pointF7.y = f62;
            RectF rectF14 = this.f12483m;
            k((double) (f61 - (f38 * 2.0f)), (double) (f62 - (f34 * 2.0f)), (double) f61, (double) f62, (double) rectF14.right, (double) rectF14.bottom, (double) f61, (double) f62, pointF8);
        }
    }

    private void C() {
        PathEffect pathEffect;
        b bVar = this.f12474d;
        if (bVar != null) {
            pathEffect = b.b(bVar, l());
        } else {
            pathEffect = null;
        }
        this.f12491u.setPathEffect(pathEffect);
    }

    private void D(int i10) {
        PathEffect pathEffect;
        b bVar = this.f12474d;
        if (bVar != null) {
            pathEffect = b.b(bVar, (float) i10);
        } else {
            pathEffect = null;
        }
        this.f12491u.setPathEffect(pathEffect);
    }

    private static int a(float f10, float f11) {
        return ((((int) f10) << 24) & ViewCompat.MEASURED_STATE_MASK) | (((int) f11) & ViewCompat.MEASURED_SIZE_MASK);
    }

    private void b(Canvas canvas, int i10, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        if (i10 != 0) {
            if (this.f12479i == null) {
                this.f12479i = new Path();
            }
            this.f12491u.setColor(i10);
            this.f12479i.reset();
            this.f12479i.moveTo(f10, f11);
            this.f12479i.lineTo(f12, f13);
            this.f12479i.lineTo(f14, f15);
            this.f12479i.lineTo(f16, f17);
            this.f12479i.lineTo(f10, f11);
            canvas.drawPath(this.f12479i, this.f12491u);
        }
    }

    private void c(Canvas canvas) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z11;
        int i14;
        Canvas canvas2 = canvas;
        this.f12491u.setStyle(Paint.Style.FILL);
        int q10 = q(this.f12492v, this.f12493w);
        if (Color.alpha(q10) != 0) {
            this.f12491u.setColor(q10);
            canvas2.drawRect(getBounds(), this.f12491u);
        }
        RectF j10 = j();
        int round = Math.round(j10.left);
        int round2 = Math.round(j10.top);
        int round3 = Math.round(j10.right);
        int round4 = Math.round(j10.bottom);
        if (round > 0 || round3 > 0 || round2 > 0 || round4 > 0) {
            Rect bounds = getBounds();
            int f10 = f(0);
            int f11 = f(1);
            int f12 = f(2);
            int f13 = f(3);
            int f14 = f(9);
            int f15 = f(11);
            int f16 = f(10);
            if (p(9)) {
                f11 = f14;
                f13 = f11;
            }
            if (!p(10)) {
                f16 = f13;
            }
            if (!p(11)) {
                f15 = f11;
            }
            if (getLayoutDirection() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int f17 = f(4);
            int f18 = f(5);
            if (com.facebook.react.modules.i18nmanager.a.f().d(this.A)) {
                if (p(4)) {
                    f10 = f17;
                }
                if (p(5)) {
                    f12 = f18;
                }
                if (z10) {
                    i14 = f12;
                } else {
                    i14 = f10;
                }
                if (!z10) {
                    f10 = f12;
                }
                i10 = f10;
                i11 = i14;
            } else {
                if (z10) {
                    i13 = f18;
                } else {
                    i13 = f17;
                }
                if (!z10) {
                    f17 = f18;
                }
                boolean p10 = p(4);
                boolean p11 = p(5);
                if (z10) {
                    z11 = p11;
                } else {
                    z11 = p10;
                }
                if (!z10) {
                    p10 = p11;
                }
                if (z11) {
                    f10 = i13;
                }
                i11 = f10;
                if (p10) {
                    i10 = f17;
                } else {
                    i10 = f12;
                }
            }
            int i15 = bounds.left;
            int i16 = i11;
            int i17 = bounds.top;
            int i18 = round3;
            int i19 = i15;
            int e10 = e(round, round2, round3, round4, i11, f15, i10, f16);
            if (e10 == 0) {
                this.f12491u.setAntiAlias(false);
                int width = bounds.width();
                int height = bounds.height();
                if (round > 0) {
                    float f19 = (float) i19;
                    float f20 = (float) (i19 + round);
                    int i20 = i17 + height;
                    i12 = i17;
                    b(canvas, i16, f19, (float) i17, f20, (float) (i17 + round2), f20, (float) (i20 - round4), f19, (float) i20);
                } else {
                    i12 = i17;
                }
                if (round2 > 0) {
                    float f21 = (float) i12;
                    float f22 = (float) (i12 + round2);
                    int i21 = i19 + width;
                    b(canvas, f15, (float) i19, f21, (float) (i19 + round), f22, (float) (i21 - i18), f22, (float) i21, f21);
                }
                if (i18 > 0) {
                    int i22 = i19 + width;
                    float f23 = (float) i22;
                    int i23 = i12 + height;
                    float f24 = (float) (i22 - i18);
                    b(canvas, i10, f23, (float) i12, f23, (float) i23, f24, (float) (i23 - round4), f24, (float) (i12 + round2));
                }
                if (round4 > 0) {
                    int i24 = i12 + height;
                    float f25 = (float) i24;
                    int i25 = i19 + width;
                    float f26 = (float) (i24 - round4);
                    b(canvas, f16, (float) i19, f25, (float) i25, f25, (float) (i25 - i18), f26, (float) (i19 + round), f26);
                }
                this.f12491u.setAntiAlias(true);
            } else if (Color.alpha(e10) != 0) {
                int i26 = bounds.right;
                int i27 = bounds.bottom;
                this.f12491u.setColor(e10);
                this.f12491u.setStyle(Paint.Style.STROKE);
                if (round > 0) {
                    this.f12480j.reset();
                    int round5 = Math.round(j10.left);
                    D(round5);
                    this.f12491u.setStrokeWidth((float) round5);
                    float f27 = (float) (i19 + (round5 / 2));
                    this.f12480j.moveTo(f27, (float) i17);
                    this.f12480j.lineTo(f27, (float) i27);
                    canvas2.drawPath(this.f12480j, this.f12491u);
                }
                if (round2 > 0) {
                    this.f12480j.reset();
                    int round6 = Math.round(j10.top);
                    D(round6);
                    this.f12491u.setStrokeWidth((float) round6);
                    float f28 = (float) (i17 + (round6 / 2));
                    this.f12480j.moveTo((float) i19, f28);
                    this.f12480j.lineTo((float) i26, f28);
                    canvas2.drawPath(this.f12480j, this.f12491u);
                }
                if (i18 > 0) {
                    this.f12480j.reset();
                    int round7 = Math.round(j10.right);
                    D(round7);
                    this.f12491u.setStrokeWidth((float) round7);
                    float f29 = (float) (i26 - (round7 / 2));
                    this.f12480j.moveTo(f29, (float) i17);
                    this.f12480j.lineTo(f29, (float) i27);
                    canvas2.drawPath(this.f12480j, this.f12491u);
                }
                if (round4 > 0) {
                    this.f12480j.reset();
                    int round8 = Math.round(j10.bottom);
                    D(round8);
                    this.f12491u.setStrokeWidth((float) round8);
                    float f30 = (float) (i27 - (round8 / 2));
                    this.f12480j.moveTo((float) i19, f30);
                    this.f12480j.lineTo((float) i26, f30);
                    canvas2.drawPath(this.f12480j, this.f12491u);
                }
            }
        }
    }

    private void d(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        float f10;
        PointF pointF;
        float f11;
        float f12;
        float f13;
        int i13;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        int i14;
        boolean z10;
        Canvas canvas2 = canvas;
        B();
        canvas.save();
        canvas2.clipPath((Path) Preconditions.checkNotNull(this.f12477g), Region.Op.INTERSECT);
        int alphaComponent = ColorUtils.setAlphaComponent(this.f12492v, getOpacity());
        if (Color.alpha(alphaComponent) != 0) {
            this.f12491u.setColor(alphaComponent);
            this.f12491u.setStyle(Paint.Style.FILL);
            canvas2.drawPath((Path) Preconditions.checkNotNull(this.f12476f), this.f12491u);
        }
        RectF j10 = j();
        boolean z11 = false;
        int f14 = f(0);
        int f15 = f(1);
        int f16 = f(2);
        int f17 = f(3);
        int f18 = f(9);
        int f19 = f(11);
        int f20 = f(10);
        if (p(9)) {
            f15 = f18;
            f17 = f15;
        }
        if (!p(10)) {
            f20 = f17;
        }
        if (p(11)) {
            i10 = f19;
        } else {
            i10 = f15;
        }
        if (j10.top > 0.0f || j10.bottom > 0.0f || j10.left > 0.0f || j10.right > 0.0f) {
            float l10 = l();
            int f21 = f(8);
            if (j10.top != l10 || j10.bottom != l10 || j10.left != l10 || j10.right != l10 || f14 != f21 || i10 != f21 || f16 != f21 || f20 != f21) {
                this.f12491u.setStyle(Paint.Style.FILL);
                canvas2.clipPath((Path) Preconditions.checkNotNull(this.f12475e), Region.Op.DIFFERENCE);
                if (getLayoutDirection() == 1) {
                    z11 = true;
                }
                int f22 = f(4);
                int f23 = f(5);
                if (com.facebook.react.modules.i18nmanager.a.f().d(this.A)) {
                    if (p(4)) {
                        f14 = f22;
                    }
                    if (p(5)) {
                        f16 = f23;
                    }
                    if (z11) {
                        i12 = f16;
                    } else {
                        i12 = f14;
                    }
                    if (!z11) {
                        f14 = f16;
                    }
                    i11 = f14;
                } else {
                    if (z11) {
                        i14 = f23;
                    } else {
                        i14 = f22;
                    }
                    if (!z11) {
                        f22 = f23;
                    }
                    boolean p10 = p(4);
                    boolean p11 = p(5);
                    if (z11) {
                        z10 = p11;
                    } else {
                        z10 = p10;
                    }
                    if (!z11) {
                        p10 = p11;
                    }
                    if (z10) {
                        f14 = i14;
                    }
                    if (p10) {
                        i12 = f14;
                        i11 = f22;
                    } else {
                        i12 = f14;
                        i11 = f16;
                    }
                }
                RectF rectF = (RectF) Preconditions.checkNotNull(this.f12483m);
                float f24 = rectF.left;
                float f25 = rectF.right;
                float f26 = rectF.top;
                float f27 = rectF.bottom;
                PointF pointF5 = (PointF) Preconditions.checkNotNull(this.f12486p);
                PointF pointF6 = (PointF) Preconditions.checkNotNull(this.f12487q);
                PointF pointF7 = (PointF) Preconditions.checkNotNull(this.f12489s);
                PointF pointF8 = (PointF) Preconditions.checkNotNull(this.f12488r);
                if (j10.left > 0.0f) {
                    float f28 = pointF5.x;
                    float f29 = pointF5.y - 0.8f;
                    float f30 = pointF7.x;
                    float f31 = pointF7.y + 0.8f;
                    float f32 = f27 + 0.8f;
                    pointF4 = pointF8;
                    PointF pointF9 = pointF7;
                    i13 = f20;
                    pointF2 = pointF6;
                    pointF = pointF9;
                    pointF3 = pointF5;
                    float f33 = f29;
                    f13 = f27;
                    float f34 = f30;
                    f12 = f26;
                    float f35 = f31;
                    f11 = f25;
                    f10 = f24;
                    b(canvas, i12, f24, f26 - 0.8f, f28, f33, f34, f35, f24, f32);
                } else {
                    pointF4 = pointF8;
                    pointF = pointF7;
                    pointF3 = pointF5;
                    f13 = f27;
                    f12 = f26;
                    f11 = f25;
                    f10 = f24;
                    i13 = f20;
                    pointF2 = pointF6;
                }
                if (j10.top > 0.0f) {
                    b(canvas, i10, f10 - 0.8f, f12, pointF3.x - 0.8f, pointF3.y, pointF2.x + 0.8f, pointF2.y, f11 + 0.8f, f12);
                }
                if (j10.right > 0.0f) {
                    b(canvas, i11, f11, f12 - 0.8f, pointF2.x, pointF2.y - 0.8f, pointF4.x, pointF4.y + 0.8f, f11, f13 + 0.8f);
                }
                if (j10.bottom > 0.0f) {
                    PointF pointF10 = pointF;
                    b(canvas, i13, f10 - 0.8f, f13, pointF10.x - 0.8f, pointF10.y, pointF4.x + 0.8f, pointF4.y, f11 + 0.8f, f13);
                }
            } else if (l10 > 0.0f) {
                this.f12491u.setColor(q(f21, this.f12493w));
                this.f12491u.setStyle(Paint.Style.STROKE);
                this.f12491u.setStrokeWidth(l10);
                canvas2.drawPath((Path) Preconditions.checkNotNull(this.f12481k), this.f12491u);
            }
        }
        canvas.restore();
    }

    private static int e(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        int i19;
        int i20;
        int i21 = -1;
        if (i10 > 0) {
            i18 = i14;
        } else {
            i18 = -1;
        }
        if (i11 > 0) {
            i19 = i15;
        } else {
            i19 = -1;
        }
        int i22 = i18 & i19;
        if (i12 > 0) {
            i20 = i16;
        } else {
            i20 = -1;
        }
        int i23 = i22 & i20;
        if (i13 > 0) {
            i21 = i17;
        }
        int i24 = i21 & i23;
        if (i10 <= 0) {
            i14 = 0;
        }
        if (i11 <= 0) {
            i15 = 0;
        }
        int i25 = i14 | i15;
        if (i12 <= 0) {
            i16 = 0;
        }
        int i26 = i25 | i16;
        if (i13 <= 0) {
            i17 = 0;
        }
        if (i24 == (i26 | i17)) {
            return i24;
        }
        return 0;
    }

    private static void k(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, PointF pointF) {
        PointF pointF2 = pointF;
        double d18 = (d10 + d12) / 2.0d;
        double d19 = (d11 + d13) / 2.0d;
        double d20 = d14 - d18;
        double d21 = d15 - d19;
        double abs = Math.abs(d12 - d10) / 2.0d;
        double abs2 = Math.abs(d13 - d11) / 2.0d;
        double d22 = ((d17 - d19) - d21) / ((d16 - d18) - d20);
        double d23 = d21 - (d20 * d22);
        double d24 = abs2 * abs2;
        double d25 = abs * abs;
        double d26 = d24 + (d25 * d22 * d22);
        double d27 = abs * 2.0d * abs * d23 * d22;
        double d28 = (-(d25 * ((d23 * d23) - d24))) / d26;
        double d29 = d26 * 2.0d;
        double sqrt = ((-d27) / d29) - Math.sqrt(d28 + Math.pow(d27 / d29, 2.0d));
        double d30 = (d22 * sqrt) + d23;
        double d31 = sqrt + d18;
        double d32 = d30 + d19;
        if (!Double.isNaN(d31) && !Double.isNaN(d32)) {
            PointF pointF3 = pointF;
            pointF3.x = (float) d31;
            pointF3.y = (float) d32;
        }
    }

    private boolean p(int i10) {
        float f10;
        c1 c1Var = this.f12472b;
        float f11 = Float.NaN;
        if (c1Var != null) {
            f10 = c1Var.a(i10);
        } else {
            f10 = Float.NaN;
        }
        c1 c1Var2 = this.f12473c;
        if (c1Var2 != null) {
            f11 = c1Var2.a(i10);
        }
        if (Float.isNaN(f10) || Float.isNaN(f11)) {
            return false;
        }
        return true;
    }

    private static int q(int i10, int i11) {
        if (i11 == 255) {
            return i10;
        }
        if (i11 == 0) {
            return i10 & ViewCompat.MEASURED_SIZE_MASK;
        }
        int i12 = i11 + (i11 >> 7);
        return (i10 & ViewCompat.MEASURED_SIZE_MASK) | ((((i10 >>> 24) * i12) >> 8) << 24);
    }

    private void r(int i10, float f10) {
        if (this.f12473c == null) {
            this.f12473c = new c1(255.0f);
        }
        if (!n.a(this.f12473c.b(i10), f10)) {
            this.f12473c.c(i10, f10);
            invalidateSelf();
        }
    }

    private void t(int i10, float f10) {
        if (this.f12472b == null) {
            this.f12472b = new c1(0.0f);
        }
        if (!n.a(this.f12472b.b(i10), f10)) {
            this.f12472b.c(i10, f10);
            invalidateSelf();
        }
    }

    public void A(float f10, int i10) {
        Float f11;
        if (Float.isNaN(f10)) {
            f11 = null;
        } else {
            f11 = Float.valueOf(f10);
        }
        if (f11 == null) {
            this.f12495y.e(m7.a.values()[i10], (x) null);
        } else {
            u(m7.a.values()[i10], new x(f11.floatValue(), y.POINT));
        }
    }

    public void draw(Canvas canvas) {
        C();
        if (!o()) {
            c(canvas);
        } else {
            d(canvas);
        }
    }

    public int f(int i10) {
        float f10;
        float f11;
        c1 c1Var = this.f12472b;
        if (c1Var != null) {
            f10 = c1Var.a(i10);
        } else {
            f10 = 0.0f;
        }
        c1 c1Var2 = this.f12473c;
        if (c1Var2 != null) {
            f11 = c1Var2.a(i10);
        } else {
            f11 = 255.0f;
        }
        return a(f11, f10);
    }

    public m7.b g() {
        return this.f12495y;
    }

    public int getAlpha() {
        return this.f12493w;
    }

    public int getLayoutDirection() {
        int i10 = this.B;
        if (i10 == -1) {
            return super.getLayoutDirection();
        }
        return i10;
    }

    public int getOpacity() {
        return (Color.alpha(this.f12492v) * this.f12493w) >> 8;
    }

    public void getOutline(Outline outline) {
        if (o()) {
            B();
            outline.setConvexPath((Path) Preconditions.checkNotNull(this.f12478h));
            return;
        }
        outline.setRect(getBounds());
    }

    public float h(float f10, int i10) {
        c1 c1Var = this.f12471a;
        if (c1Var == null) {
            return f10;
        }
        float b10 = c1Var.b(i10);
        if (Float.isNaN(b10)) {
            return f10;
        }
        return b10;
    }

    public c i() {
        return this.f12496z;
    }

    public RectF j() {
        float f10;
        float f11;
        float h10 = h(0.0f, 8);
        boolean z10 = true;
        float h11 = h(h10, 1);
        float h12 = h(h10, 3);
        float h13 = h(h10, 0);
        float h14 = h(h10, 2);
        if (this.f12471a != null) {
            if (getLayoutDirection() != 1) {
                z10 = false;
            }
            float b10 = this.f12471a.b(4);
            float b11 = this.f12471a.b(5);
            if (com.facebook.react.modules.i18nmanager.a.f().d(this.A)) {
                if (!Float.isNaN(b10)) {
                    h13 = b10;
                }
                if (!Float.isNaN(b11)) {
                    h14 = b11;
                }
                if (z10) {
                    f11 = h14;
                } else {
                    f11 = h13;
                }
                if (z10) {
                    h14 = h13;
                }
                h13 = f11;
            } else {
                if (z10) {
                    f10 = b11;
                } else {
                    f10 = b10;
                }
                if (!z10) {
                    b10 = b11;
                }
                if (!Float.isNaN(f10)) {
                    h13 = f10;
                }
                if (!Float.isNaN(b10)) {
                    h14 = b10;
                }
            }
        }
        return new RectF(h13, h11, h14, h12);
    }

    public float l() {
        c1 c1Var = this.f12471a;
        if (c1Var == null || Float.isNaN(c1Var.b(8))) {
            return 0.0f;
        }
        return this.f12471a.b(8);
    }

    public Path m() {
        if (!o()) {
            return null;
        }
        B();
        return new Path((Path) Preconditions.checkNotNull(this.f12475e));
    }

    public RectF n() {
        RectF j10 = j();
        if (j10 == null) {
            return new RectF(0.0f, 0.0f, (float) getBounds().width(), (float) getBounds().height());
        }
        return new RectF(j10.left, j10.top, ((float) getBounds().width()) - j10.right, ((float) getBounds().height()) - j10.bottom);
    }

    public boolean o() {
        return this.f12495y.c();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f12490t = true;
    }

    public void s(int i10, float f10, float f11) {
        t(i10, f10);
        r(i10, f11);
        this.f12490t = true;
    }

    public void setAlpha(int i10) {
        if (i10 != this.f12493w) {
            this.f12493w = i10;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void u(m7.a aVar, x xVar) {
        if (!Objects.equals(xVar, this.f12495y.a(aVar))) {
            this.f12495y.e(aVar, xVar);
            this.f12490t = true;
            invalidateSelf();
        }
    }

    public void v(String str) {
        b bVar;
        if (str == null) {
            bVar = null;
        } else {
            bVar = b.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.f12474d != bVar) {
            this.f12474d = bVar;
            this.f12490t = true;
            invalidateSelf();
        }
    }

    public void w(int i10, float f10) {
        if (this.f12471a == null) {
            this.f12471a = new c1();
        }
        if (!n.a(this.f12471a.b(i10), f10)) {
            this.f12471a.c(i10, f10);
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) {
                this.f12490t = true;
            }
            invalidateSelf();
        }
    }

    public void x(int i10) {
        this.f12492v = i10;
        invalidateSelf();
    }

    public void y(int i10) {
        if (this.B != i10) {
            this.B = i10;
        }
    }

    public void z(float f10) {
        Float f11;
        if (Float.isNaN(f10)) {
            f11 = null;
        } else {
            f11 = Float.valueOf(f10);
        }
        if (f11 == null) {
            u(m7.a.BORDER_RADIUS, (x) null);
        } else {
            u(m7.a.BORDER_RADIUS, new x(f11.floatValue(), y.POINT));
        }
    }
}
