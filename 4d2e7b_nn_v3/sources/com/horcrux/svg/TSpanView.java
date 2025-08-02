package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import java.text.Bidi;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class TSpanView extends TextView {
    private Path R0;
    String S0;
    private TextPathView T0;
    private final ArrayList U0 = new ArrayList();
    private final ArrayList V0 = new ArrayList();
    private final AssetManager W0 = this.mContext.getResources().getAssets();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9730a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9731b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f9732c;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|(2:41|42)|43|45|46|47|48|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|(2:41|42)|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|(2:41|42)|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00ec */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f6 */
        static {
            /*
                com.horcrux.svg.b0[] r0 = com.horcrux.svg.b0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9732c = r0
                r1 = 1
                com.horcrux.svg.b0 r2 = com.horcrux.svg.b0.baseline     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f9732c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.horcrux.svg.b0 r3 = com.horcrux.svg.b0.textBottom     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.afterEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.textAfterEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.alphabetic     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.ideographic     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.middle     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.central     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x006c }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.mathematical     // Catch:{ NoSuchFieldError -> 0x006c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r5 = 9
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.hanging     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r5 = 10
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.textTop     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r5 = 11
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.beforeEdge     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r5 = 12
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x009c }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.textBeforeEdge     // Catch:{ NoSuchFieldError -> 0x009c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5 = 13
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.bottom     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r5 = 14
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.center     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r5 = 15
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r3 = f9732c     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.horcrux.svg.b0 r4 = com.horcrux.svg.b0.top     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r5 = 16
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                com.horcrux.svg.h0[] r3 = com.horcrux.svg.h0.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f9731b = r3
                com.horcrux.svg.h0 r4 = com.horcrux.svg.h0.spacing     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r3 = f9731b     // Catch:{ NoSuchFieldError -> 0x00db }
                com.horcrux.svg.h0 r4 = com.horcrux.svg.h0.spacingAndGlyphs     // Catch:{ NoSuchFieldError -> 0x00db }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                com.horcrux.svg.f0[] r3 = com.horcrux.svg.f0.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f9730a = r3
                com.horcrux.svg.f0 r4 = com.horcrux.svg.f0.start     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                int[] r1 = f9730a     // Catch:{ NoSuchFieldError -> 0x00f6 }
                com.horcrux.svg.f0 r3 = com.horcrux.svg.f0.middle     // Catch:{ NoSuchFieldError -> 0x00f6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f6 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00f6 }
            L_0x00f6:
                int[] r0 = f9730a     // Catch:{ NoSuchFieldError -> 0x0100 }
                com.horcrux.svg.f0 r1 = com.horcrux.svg.f0.end     // Catch:{ NoSuchFieldError -> 0x0100 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0100 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0100 }
            L_0x0100:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.a.<clinit>():void");
        }
    }

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
    }

    private void R(Paint paint, j jVar) {
        int i10 = Build.VERSION.SDK_INT;
        double d10 = jVar.f9866n;
        paint.setLetterSpacing((float) (d10 / (jVar.f9853a * ((double) this.mScale))));
        if (d10 == 0.0d && jVar.f9861i == d0.normal) {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + jVar.f9859g);
        } else {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + jVar.f9859g);
        }
        if (i10 >= 26) {
            boolean unused = paint.setFontVariationSettings("'wght' " + jVar.f9858f + jVar.f9860h);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r5 = android.graphics.Typeface.create(android.graphics.Typeface.createFromAsset(r10.W0, r7), r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00c9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S(android.graphics.Paint r11, com.horcrux.svg.j r12) {
        /*
            r10 = this;
            com.horcrux.svg.e0 r0 = r12.f9857e
            com.horcrux.svg.e0 r1 = com.horcrux.svg.e0.Bold
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0011
            int r0 = r12.f9858f
            r1 = 550(0x226, float:7.71E-43)
            if (r0 < r1) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = r2
            goto L_0x0012
        L_0x0011:
            r0 = r3
        L_0x0012:
            com.horcrux.svg.c0 r1 = r12.f9855c
            com.horcrux.svg.c0 r4 = com.horcrux.svg.c0.italic
            if (r1 != r4) goto L_0x001a
            r1 = r3
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            if (r0 == 0) goto L_0x0021
            if (r1 == 0) goto L_0x0021
            r2 = 3
            goto L_0x0028
        L_0x0021:
            if (r0 == 0) goto L_0x0025
            r2 = r3
            goto L_0x0028
        L_0x0025:
            if (r1 == 0) goto L_0x0028
            r2 = 2
        L_0x0028:
            int r0 = r12.f9858f
            java.lang.String r4 = r12.f9854b
            r5 = 0
            if (r4 == 0) goto L_0x00d3
            int r6 = r4.length()
            if (r6 <= 0) goto L_0x00d3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "fonts/"
            r6.append(r7)
            r6.append(r4)
            java.lang.String r8 = ".otf"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r4)
            java.lang.String r7 = ".ttf"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r8 < r9) goto L_0x00be
            com.horcrux.svg.a0.a()
            android.content.res.AssetManager r5 = r10.W0
            android.graphics.Typeface$Builder r5 = com.horcrux.svg.z.a(r5, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "'wght' "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r9 = r12.f9860h
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            android.graphics.Typeface.Builder unused = r5.setFontVariationSettings(r6)
            android.graphics.Typeface.Builder unused = r5.setWeight(r0)
            android.graphics.Typeface.Builder unused = r5.setItalic(r1)
            android.graphics.Typeface r5 = r5.build()
            if (r5 != 0) goto L_0x00d3
            com.horcrux.svg.a0.a()
            android.content.res.AssetManager r5 = r10.W0
            android.graphics.Typeface$Builder r5 = com.horcrux.svg.z.a(r5, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r8)
            r6.append(r0)
            java.lang.String r7 = r12.f9860h
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.graphics.Typeface.Builder unused = r5.setFontVariationSettings(r6)
            android.graphics.Typeface.Builder unused = r5.setWeight(r0)
            android.graphics.Typeface.Builder unused = r5.setItalic(r1)
            android.graphics.Typeface r5 = r5.build()
            goto L_0x00d3
        L_0x00be:
            android.content.res.AssetManager r8 = r10.W0     // Catch:{ Exception -> 0x00c9 }
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromAsset(r8, r6)     // Catch:{ Exception -> 0x00c9 }
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r2)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00d3
        L_0x00c9:
            android.content.res.AssetManager r6 = r10.W0     // Catch:{ Exception -> 0x00d3 }
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromAsset(r6, r7)     // Catch:{ Exception -> 0x00d3 }
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r2)     // Catch:{ Exception -> 0x00d3 }
        L_0x00d3:
            if (r5 != 0) goto L_0x00df
            com.facebook.react.views.text.d r6 = com.facebook.react.views.text.d.a()     // Catch:{ Exception -> 0x00df }
            android.content.res.AssetManager r7 = r10.W0     // Catch:{ Exception -> 0x00df }
            android.graphics.Typeface r5 = r6.c(r4, r2, r7)     // Catch:{ Exception -> 0x00df }
        L_0x00df:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r2 < r4) goto L_0x00e9
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r0, r1)
        L_0x00e9:
            r11.setLinearText(r3)
            r11.setSubpixelText(r3)
            r11.setTypeface(r5)
            double r0 = r12.f9853a
            float r12 = r10.mScale
            double r2 = (double) r12
            double r0 = r0 * r2
            float r12 = (float) r0
            r11.setTextSize(r12)
            r12 = 0
            r11.setLetterSpacing(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.S(android.graphics.Paint, com.horcrux.svg.j):void");
    }

    private void T(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        k t10 = t();
        v();
        j b10 = t10.b();
        TextPaint textPaint = new TextPaint(paint);
        S(textPaint, b10);
        R(textPaint, b10);
        double c10 = t10.c();
        int i10 = a.f9730a[b10.f9862j.ordinal()];
        if (i10 == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i10 != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout W = W(textPaint, alignment, true, new SpannableString(this.S0), (int) p.a(this.f9733f, (double) canvas.getWidth(), 0.0d, (double) this.mScale, c10));
        int lineAscent = W.getLineAscent(0);
        u();
        canvas.save();
        canvas.translate((float) t10.l(0.0d), (float) (t10.m() + ((double) lineAscent)));
        W.draw(canvas);
        canvas.restore();
    }

    private double U(SVGLength sVGLength, double d10, double d11) {
        return p.a(sVGLength, d10, 0.0d, (double) this.mScale, d11);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e3, code lost:
        r11 = r53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ec, code lost:
        r5 = r69;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01fc, code lost:
        r11 = r4 * r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0244  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Path V(java.lang.String r68, android.graphics.Paint r69, android.graphics.Canvas r70) {
        /*
            r67 = this;
            r6 = r67
            r14 = r69
            r15 = r70
            r12 = 0
            int r10 = r68.length()
            android.graphics.Path r9 = new android.graphics.Path
            r9.<init>()
            java.util.ArrayList r0 = r6.U0
            r0.clear()
            java.util.ArrayList r0 = r6.V0
            r0.clear()
            if (r10 != 0) goto L_0x001d
            return r9
        L_0x001d:
            com.horcrux.svg.TextPathView r0 = r6.T0
            if (r0 == 0) goto L_0x0024
            r16 = 1
            goto L_0x0026
        L_0x0024:
            r16 = r12
        L_0x0026:
            r17 = 0
            if (r16 == 0) goto L_0x0048
            android.graphics.PathMeasure r0 = new android.graphics.PathMeasure
            com.horcrux.svg.TextPathView r1 = r6.T0
            android.graphics.Path r1 = r1.U(r15, r14)
            r0.<init>(r1, r12)
            float r1 = r0.getLength()
            double r1 = (double) r1
            boolean r3 = r0.isClosed()
            int r4 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r4 != 0) goto L_0x0043
            return r9
        L_0x0043:
            r8 = r0
            r4 = r1
            r19 = r3
            goto L_0x004e
        L_0x0048:
            r0 = 0
            r8 = r0
            r19 = r12
            r4 = r17
        L_0x004e:
            com.horcrux.svg.k r2 = r67.t()
            com.horcrux.svg.j r0 = r2.b()
            r6.S(r14, r0)
            com.horcrux.svg.l r3 = new com.horcrux.svg.l
            r3.<init>(r14)
            boolean[] r1 = new boolean[r10]
            char[] r20 = r68.toCharArray()
            r22 = r8
            double r7 = r0.f9864l
            double r12 = r0.f9865m
            r26 = r12
            double r11 = r0.f9866n
            boolean r13 = r0.f9867o
            r25 = 1
            r28 = r13 ^ 1
            int r13 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r13 != 0) goto L_0x0082
            com.horcrux.svg.d0 r13 = r0.f9861i
            r29 = r1
            com.horcrux.svg.d0 r1 = com.horcrux.svg.d0.normal
            if (r13 != r1) goto L_0x0084
            r1 = 1
            goto L_0x0085
        L_0x0082:
            r29 = r1
        L_0x0084:
            r1 = 0
        L_0x0085:
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r1 == 0) goto L_0x00a2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r30 = r3
            java.lang.String r3 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', "
            r1.append(r3)
            java.lang.String r3 = r0.f9859g
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r14.setFontFeatureSettings(r1)
            goto L_0x00ba
        L_0x00a2:
            r30 = r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, "
            r1.append(r3)
            java.lang.String r3 = r0.f9859g
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r14.setFontFeatureSettings(r1)
        L_0x00ba:
            r1 = 26
            if (r13 < r1) goto L_0x00d9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "'wght' "
            r1.append(r3)
            int r3 = r0.f9858f
            r1.append(r3)
            java.lang.String r3 = r0.f9860h
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            boolean unused = r14.setFontVariationSettings(r1)
        L_0x00d9:
            com.facebook.react.bridge.ReadableMap r13 = r0.f9856d
            float[] r3 = new float[r10]
            r1 = r68
            r14.getTextWidths(r1, r3)
            com.horcrux.svg.f0 r1 = r0.f9862j
            com.horcrux.svg.TextView r0 = r67.E()
            r31 = r7
            double r7 = r0.D(r14)
            double r33 = r6.X(r1, r7)
            double r44 = r2.c()
            r46 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r16 == 0) goto L_0x014f
            com.horcrux.svg.TextPathView r0 = r6.T0
            com.horcrux.svg.j0 r0 = r0.R()
            r35 = r1
            com.horcrux.svg.j0 r1 = com.horcrux.svg.j0.sharp
            if (r0 != r1) goto L_0x0109
            r36 = 1
            goto L_0x010b
        L_0x0109:
            r36 = 0
        L_0x010b:
            com.horcrux.svg.TextPathView r0 = r6.T0
            com.horcrux.svg.k0 r0 = r0.S()
            com.horcrux.svg.k0 r1 = com.horcrux.svg.k0.right
            if (r0 != r1) goto L_0x0118
            r37 = -1
            goto L_0x011a
        L_0x0118:
            r37 = 1
        L_0x011a:
            com.horcrux.svg.TextPathView r0 = r6.T0
            com.horcrux.svg.SVGLength r1 = r0.T()
            r0 = r67
            r48 = r9
            r9 = r35
            r15 = r2
            r49 = r30
            r30 = r3
            r2 = r4
            r50 = r13
            r13 = r4
            r4 = r44
            double r0 = r0.U(r1, r2, r4)
            double r33 = r33 + r0
            if (r19 == 0) goto L_0x014b
            double r4 = r13 / r46
            com.horcrux.svg.f0 r2 = com.horcrux.svg.f0.middle
            if (r9 != r2) goto L_0x0141
            double r2 = -r4
            goto L_0x0143
        L_0x0141:
            r2 = r17
        L_0x0143:
            double r0 = r0 + r2
            double r4 = r0 + r13
        L_0x0146:
            r3 = r36
            r2 = r37
            goto L_0x015d
        L_0x014b:
            r4 = r13
            r0 = r17
            goto L_0x0146
        L_0x014f:
            r15 = r2
            r48 = r9
            r50 = r13
            r49 = r30
            r30 = r3
            r13 = r4
            r0 = r17
            r2 = 1
            r3 = 0
        L_0x015d:
            com.horcrux.svg.SVGLength r9 = r6.f9734g
            r51 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r9 == 0) goto L_0x01a4
            r53 = r13
            int r13 = r70.getWidth()
            double r13 = (double) r13
            r68 = r3
            float r3 = r6.mScale
            r55 = r0
            double r0 = (double) r3
            r38 = 0
            r35 = r9
            r36 = r13
            r40 = r0
            r42 = r44
            double r0 = com.horcrux.svg.p.a(r35, r36, r38, r40, r42)
            int r3 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r3 < 0) goto L_0x019c
            int[] r3 = com.horcrux.svg.TSpanView.a.f9731b
            com.horcrux.svg.h0 r9 = r6.f9736i
            int r9 = r9.ordinal()
            r3 = r3[r9]
            r9 = 2
            if (r3 == r9) goto L_0x0199
            double r0 = r0 - r7
            r3 = 1
            int r7 = r10 + -1
            double r7 = (double) r7
            double r0 = r0 / r7
            double r11 = r11 + r0
        L_0x0197:
            r0 = r11
            goto L_0x01ab
        L_0x0199:
            double r51 = r0 / r7
            goto L_0x0197
        L_0x019c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Negative textLength value"
            r0.<init>(r1)
            throw r0
        L_0x01a4:
            r55 = r0
            r68 = r3
            r53 = r13
            goto L_0x0197
        L_0x01ab:
            double r13 = (double) r2
            double r11 = r51 * r13
            android.graphics.Paint$FontMetrics r3 = r69.getFontMetrics()
            float r7 = r3.descent
            double r7 = (double) r7
            float r9 = r3.leading
            r42 = r11
            double r11 = (double) r9
            double r11 = r11 + r7
            r19 = r2
            float r2 = r3.ascent
            float r2 = -r2
            float r2 = r2 + r9
            r57 = r4
            double r4 = (double) r2
            float r2 = r3.top
            float r2 = -r2
            double r2 = (double) r2
            double r35 = r2 + r11
            java.lang.String r9 = r67.B()
            com.horcrux.svg.b0 r37 = r67.A()
            if (r37 == 0) goto L_0x0225
            int[] r38 = com.horcrux.svg.TSpanView.a.f9732c
            int r39 = r37.ordinal()
            r38 = r38[r39]
            switch(r38) {
                case 2: goto L_0x021e;
                case 3: goto L_0x021e;
                case 4: goto L_0x021e;
                case 5: goto L_0x0225;
                case 6: goto L_0x021e;
                case 7: goto L_0x0206;
                case 8: goto L_0x0202;
                case 9: goto L_0x01ff;
                case 10: goto L_0x01f7;
                case 11: goto L_0x01f0;
                case 12: goto L_0x01f0;
                case 13: goto L_0x01f0;
                case 14: goto L_0x01ec;
                case 15: goto L_0x01ea;
                case 16: goto L_0x01e7;
                default: goto L_0x01df;
            }
        L_0x01df:
            r5 = r69
            r2 = r17
        L_0x01e3:
            r11 = r53
            r4 = 0
            goto L_0x022c
        L_0x01e7:
            r5 = r69
            goto L_0x01e3
        L_0x01ea:
            double r11 = r35 / r46
        L_0x01ec:
            r5 = r69
            r2 = r11
            goto L_0x01e3
        L_0x01f0:
            r2 = r4
            r11 = r53
            r4 = 0
            r5 = r69
            goto L_0x022c
        L_0x01f7:
            r2 = 4605380978949069210(0x3fe999999999999a, double:0.8)
        L_0x01fc:
            double r11 = r4 * r2
            goto L_0x01ec
        L_0x01ff:
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            goto L_0x01fc
        L_0x0202:
            double r4 = r4 - r7
            double r11 = r4 / r46
            goto L_0x01ec
        L_0x0206:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            java.lang.String r3 = "x"
            r5 = r69
            r11 = r53
            r4 = 0
            r7 = 1
            r5.getTextBounds(r3, r4, r7, r2)
            int r2 = r2.height()
            double r2 = (double) r2
            double r2 = r2 / r46
            goto L_0x022c
        L_0x021e:
            r5 = r69
            r11 = r53
            r4 = 0
            double r2 = -r7
            goto L_0x022c
        L_0x0225:
            r5 = r69
            r11 = r53
            r4 = 0
            r2 = r17
        L_0x022c:
            if (r9 == 0) goto L_0x0305
            boolean r7 = r9.isEmpty()
            if (r7 != 0) goto L_0x0305
            int[] r7 = com.horcrux.svg.TSpanView.a.f9732c
            int r8 = r37.ordinal()
            r7 = r7[r8]
            r8 = 14
            if (r7 == r8) goto L_0x0305
            r8 = 16
            if (r7 == r8) goto L_0x0305
            java.lang.String r7 = "os2"
            java.lang.String r8 = "unitsPerEm"
            java.lang.String r4 = "tables"
            int r35 = r9.hashCode()
            r53 = r11
            switch(r35) {
                case -1720785339: goto L_0x026e;
                case 114240: goto L_0x0262;
                case 109801339: goto L_0x0256;
                default: goto L_0x0253;
            }
        L_0x0253:
            r21 = -1
            goto L_0x0279
        L_0x0256:
            java.lang.String r11 = "super"
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x025f
            goto L_0x0276
        L_0x025f:
            r21 = 2
            goto L_0x0279
        L_0x0262:
            java.lang.String r11 = "sub"
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x026b
            goto L_0x0276
        L_0x026b:
            r21 = 1
            goto L_0x0279
        L_0x026e:
            java.lang.String r11 = "baseline"
            boolean r11 = r9.equals(r11)
            if (r11 != 0) goto L_0x0277
        L_0x0276:
            goto L_0x0253
        L_0x0277:
            r21 = 0
        L_0x0279:
            switch(r21) {
                case 0: goto L_0x028d;
                case 1: goto L_0x02cb;
                case 2: goto L_0x0291;
                default: goto L_0x027c;
            }
        L_0x027c:
            float r4 = r6.mScale
            double r7 = (double) r4
            double r36 = r7 * r44
            double r7 = (double) r4
            r35 = r9
            r38 = r7
            r40 = r44
            double r7 = com.horcrux.svg.p.b(r35, r36, r38, r40)
            double r2 = r2 - r7
        L_0x028d:
            r35 = r13
            goto L_0x0308
        L_0x0291:
            if (r50 == 0) goto L_0x028d
            r9 = r50
            boolean r11 = r9.hasKey(r4)
            if (r11 == 0) goto L_0x028d
            boolean r11 = r9.hasKey(r8)
            if (r11 == 0) goto L_0x028d
            int r8 = r9.getInt(r8)
            com.facebook.react.bridge.ReadableMap r4 = r9.getMap(r4)
            boolean r9 = r4.hasKey(r7)
            if (r9 == 0) goto L_0x028d
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r7)
            java.lang.String r7 = "ySuperscriptYOffset"
            boolean r9 = r4.hasKey(r7)
            if (r9 == 0) goto L_0x028d
            double r11 = r4.getDouble(r7)
            float r4 = r6.mScale
            r35 = r13
            double r13 = (double) r4
            double r13 = r13 * r44
            double r13 = r13 * r11
            double r7 = (double) r8
            double r13 = r13 / r7
            double r2 = r2 - r13
            goto L_0x0308
        L_0x02cb:
            r35 = r13
            r9 = r50
            if (r9 == 0) goto L_0x0308
            boolean r11 = r9.hasKey(r4)
            if (r11 == 0) goto L_0x0308
            boolean r11 = r9.hasKey(r8)
            if (r11 == 0) goto L_0x0308
            int r8 = r9.getInt(r8)
            com.facebook.react.bridge.ReadableMap r4 = r9.getMap(r4)
            boolean r9 = r4.hasKey(r7)
            if (r9 == 0) goto L_0x0308
            com.facebook.react.bridge.ReadableMap r4 = r4.getMap(r7)
            java.lang.String r7 = "ySubscriptYOffset"
            boolean r9 = r4.hasKey(r7)
            if (r9 == 0) goto L_0x0308
            double r11 = r4.getDouble(r7)
            float r4 = r6.mScale
            double r13 = (double) r4
            double r13 = r13 * r44
            double r13 = r13 * r11
            double r7 = (double) r8
            double r13 = r13 / r7
            double r2 = r2 + r13
            goto L_0x0308
        L_0x0305:
            r53 = r11
            goto L_0x028d
        L_0x0308:
            android.graphics.Matrix r4 = new android.graphics.Matrix
            r4.<init>()
            android.graphics.Matrix r14 = new android.graphics.Matrix
            r14.<init>()
            android.graphics.Matrix r13 = new android.graphics.Matrix
            r13.<init>()
            r7 = 9
            float[] r12 = new float[r7]
            float[] r11 = new float[r7]
            r7 = r31
            r9 = 0
        L_0x0320:
            if (r9 >= r10) goto L_0x0565
            r31 = r7
            char r7 = r20[r9]
            java.lang.String r8 = java.lang.String.valueOf(r7)
            boolean r21 = r29[r9]
            if (r21 == 0) goto L_0x0336
            java.lang.String r8 = ""
            r6 = r8
            r38 = r10
            r37 = 0
            goto L_0x0369
        L_0x0336:
            r25 = r9
            r37 = 0
        L_0x033a:
            r38 = 1
            int r6 = r25 + 1
            if (r6 >= r10) goto L_0x0348
            r38 = r30[r6]
            r39 = 0
            int r38 = (r38 > r39 ? 1 : (r38 == r39 ? 0 : -1))
            if (r38 <= 0) goto L_0x034b
        L_0x0348:
            r38 = r10
            goto L_0x0368
        L_0x034b:
            r38 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r8)
            char r8 = r20[r6]
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r10 = 1
            r29[r6] = r10
            r25 = r6
            r10 = r38
            r37 = 1
            goto L_0x033a
        L_0x0368:
            r6 = r8
        L_0x0369:
            float r8 = r5.measureText(r6)
            r40 = r6
            double r5 = (double) r8
            double r5 = r5 * r51
            if (r28 == 0) goto L_0x037e
            r8 = r30[r9]
            r10 = r9
            double r8 = (double) r8
            double r8 = r8 * r51
            double r8 = r8 - r5
            r31 = r8
            goto L_0x037f
        L_0x037e:
            r10 = r9
        L_0x037f:
            r8 = 32
            if (r7 != r8) goto L_0x0385
            r8 = 1
            goto L_0x0386
        L_0x0385:
            r8 = 0
        L_0x0386:
            if (r8 == 0) goto L_0x038b
            r44 = r26
            goto L_0x038d
        L_0x038b:
            r44 = r17
        L_0x038d:
            double r44 = r44 + r0
            double r44 = r5 + r44
            if (r21 == 0) goto L_0x0398
            r61 = r0
            r0 = r17
            goto L_0x039e
        L_0x0398:
            double r59 = r31 + r44
            r61 = r0
            r0 = r59
        L_0x039e:
            double r0 = r15.l(r0)
            r41 = r10
            double r9 = r15.m()
            double r59 = r15.i()
            double r63 = r15.j()
            r65 = r9
            double r9 = r15.k()
            if (r21 != 0) goto L_0x03ba
            if (r8 == 0) goto L_0x03e1
        L_0x03ba:
            r10 = r67
            r9 = r70
            r59 = r2
            r23 = r11
            r24 = r12
            r1 = r13
            r11 = r15
            r5 = r19
            r2 = r22
            r21 = r38
            r19 = r41
            r37 = r42
            r6 = r48
            r0 = r49
            r15 = 1
            r25 = 2
            r41 = 0
            r12 = r69
            r22 = r4
            r3 = r53
            goto L_0x0542
        L_0x03e1:
            double r44 = r44 * r35
            double r5 = r5 * r35
            double r0 = r0 + r59
            double r0 = r0 * r35
            double r0 = r33 + r0
            double r0 = r0 - r44
            if (r16 == 0) goto L_0x0490
            r21 = r7
            double r7 = r0 + r5
            double r5 = r5 / r46
            r44 = r9
            double r9 = r0 + r5
            int r50 = (r9 > r57 ? 1 : (r9 == r57 ? 0 : -1))
            if (r50 <= 0) goto L_0x03fe
            goto L_0x03ba
        L_0x03fe:
            int r50 = (r9 > r55 ? 1 : (r9 == r55 ? 0 : -1))
            if (r50 >= 0) goto L_0x0403
            goto L_0x03ba
        L_0x0403:
            r50 = r15
            r15 = 3
            if (r68 == 0) goto L_0x0417
            float r0 = (float) r9
            r1 = r22
            r1.getMatrix(r0, r14, r15)
            r59 = r2
            r22 = r4
            r23 = r11
            r15 = 2
            r2 = r1
            goto L_0x0475
        L_0x0417:
            r59 = r2
            r2 = r22
            int r3 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x0429
            r3 = 0
            r2.getMatrix(r3, r4, r15)
            float r0 = (float) r0
            r4.preTranslate(r0, r3)
            r3 = 1
            goto L_0x042e
        L_0x0429:
            float r0 = (float) r0
            r3 = 1
            r2.getMatrix(r0, r4, r3)
        L_0x042e:
            float r0 = (float) r9
            r2.getMatrix(r0, r14, r3)
            int r0 = (r7 > r53 ? 1 : (r7 == r53 ? 0 : -1))
            if (r0 <= 0) goto L_0x0443
            r9 = r53
            float r0 = (float) r9
            r2.getMatrix(r0, r13, r15)
            double r7 = r7 - r9
            float r0 = (float) r7
            r1 = 0
            r13.preTranslate(r0, r1)
            goto L_0x0449
        L_0x0443:
            r9 = r53
            float r0 = (float) r7
            r2.getMatrix(r0, r13, r3)
        L_0x0449:
            r4.getValues(r12)
            r13.getValues(r11)
            r15 = 2
            r0 = r12[r15]
            double r0 = (double) r0
            r7 = 5
            r8 = r12[r7]
            r22 = r4
            double r3 = (double) r8
            r8 = r11[r15]
            r53 = r9
            double r8 = (double) r8
            r7 = r11[r7]
            r23 = r11
            double r10 = (double) r7
            double r8 = r8 - r0
            double r10 = r10 - r3
            double r0 = java.lang.Math.atan2(r10, r8)
            r3 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r0 = r0 * r3
            double r0 = r0 * r35
            float r0 = (float) r0
            r14.preRotate(r0)
        L_0x0475:
            double r0 = -r5
            float r0 = (float) r0
            double r3 = r63 + r59
            float r1 = (float) r3
            r14.preTranslate(r0, r1)
            r3 = r42
            float r0 = (float) r3
            r5 = r19
            float r1 = (float) r5
            r14.preScale(r0, r1)
            r6 = r65
            float r0 = (float) r6
            r1 = 0
            r14.postTranslate(r1, r0)
        L_0x048d:
            r0 = r44
            goto L_0x04af
        L_0x0490:
            r59 = r2
            r21 = r7
            r44 = r9
            r23 = r11
            r50 = r15
            r5 = r19
            r2 = r22
            r6 = r65
            r15 = 2
            r22 = r4
            r3 = r42
            float r0 = (float) r0
            double r9 = r6 + r63
            double r9 = r9 + r59
            float r1 = (float) r9
            r14.setTranslate(r0, r1)
            goto L_0x048d
        L_0x04af:
            float r0 = (float) r0
            r14.preRotate(r0)
            if (r37 == 0) goto L_0x04e2
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            int r10 = r40.length()
            r11 = 0
            r1 = 0
            r9 = 0
            r7 = r69
            r8 = r40
            r19 = r41
            r6 = r48
            r41 = r53
            r21 = r38
            r37 = r3
            r3 = r41
            r15 = 1
            r24 = r12
            r41 = 0
            r12 = r1
            r1 = r13
            r25 = 2
            r13 = r0
            r7.getTextPath(r8, r9, r10, r11, r12, r13)
            r7 = r0
            r0 = r49
            goto L_0x04fe
        L_0x04e2:
            r24 = r12
            r1 = r13
            r25 = r15
            r7 = r21
            r21 = r38
            r8 = r40
            r19 = r41
            r6 = r48
            r0 = r49
            r15 = 1
            r41 = 0
            r37 = r3
            r3 = r53
            android.graphics.Path r7 = r0.b(r7, r8)
        L_0x04fe:
            android.graphics.RectF r9 = new android.graphics.RectF
            r9.<init>()
            r7.computeBounds(r9, r15)
            float r9 = r9.width()
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 != 0) goto L_0x0534
            r70.save()
            r9 = r70
            r11 = r50
            r9.concat(r14)
            r7 = r10
            r10 = r67
            java.util.ArrayList r12 = r10.U0
            r12.add(r8)
            java.util.ArrayList r12 = r10.V0
            android.graphics.Matrix r13 = new android.graphics.Matrix
            r13.<init>(r14)
            r12.add(r13)
            r12 = r69
            r9.drawText(r8, r7, r7, r12)
            r70.restore()
            goto L_0x0542
        L_0x0534:
            r10 = r67
            r12 = r69
            r9 = r70
            r11 = r50
            r7.transform(r14)
            r6.addPath(r7)
        L_0x0542:
            int r7 = r19 + 1
            r49 = r0
            r13 = r1
            r53 = r3
            r19 = r5
            r48 = r6
            r9 = r7
            r6 = r10
            r15 = r11
            r5 = r12
            r10 = r21
            r4 = r22
            r11 = r23
            r12 = r24
            r7 = r31
            r42 = r37
            r0 = r61
            r22 = r2
            r2 = r59
            goto L_0x0320
        L_0x0565:
            r10 = r6
            r6 = r48
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.V(java.lang.String, android.graphics.Paint, android.graphics.Canvas):android.graphics.Path");
    }

    private StaticLayout W(TextPaint textPaint, Layout.Alignment alignment, boolean z10, SpannableString spannableString, int i10) {
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i10).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z10).setBreakStrategy(1).setHyphenationFrequency(1).build();
    }

    private double X(f0 f0Var, double d10) {
        int i10 = a.f9730a[f0Var.ordinal()];
        if (i10 == 2) {
            return (-d10) / 2.0d;
        }
        if (i10 != 3) {
            return 0.0d;
        }
        return -d10;
    }

    private void Z() {
        ViewParent parent = getParent();
        while (parent != null) {
            if (parent.getClass() == TextPathView.class) {
                this.T0 = (TextPathView) parent;
                return;
            } else if (parent instanceof TextView) {
                parent = parent.getParent();
            } else {
                return;
            }
        }
    }

    public static String a0(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Bidi bidi = new Bidi(str, -2);
        if (bidi.isLeftToRight()) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i10 = 0; i10 < runCount; i10++) {
            bArr[i10] = (byte) bidi.getRunLevel(i10);
            numArr[i10] = Integer.valueOf(i10);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < runCount; i11++) {
            int intValue = numArr[i11].intValue();
            int runStart = bidi.getRunStart(intValue);
            int runLimit = bidi.getRunLimit(intValue);
            if ((bArr[intValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit < runStart) {
                        break;
                    }
                    sb2.append(str.charAt(runLimit));
                }
            } else {
                sb2.append(str, runStart, runLimit);
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public double D(Paint paint) {
        if (!Double.isNaN(this.Q0)) {
            return this.Q0;
        }
        String str = this.S0;
        double d10 = 0.0d;
        if (str == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (childAt instanceof TextView) {
                    d10 += ((TextView) childAt).D(paint);
                }
            }
            this.Q0 = d10;
            return d10;
        } else if (str.length() == 0) {
            this.Q0 = 0.0d;
            return 0.0d;
        } else {
            j b10 = t().b();
            S(paint, b10);
            R(paint, b10);
            double measureText = (double) paint.measureText(str);
            this.Q0 = measureText;
            return measureText;
        }
    }

    public void Y(String str) {
        this.S0 = str;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.R0 = null;
        super.clearCache();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        if (this.S0 != null) {
            SVGLength sVGLength = this.f9733f;
            if (sVGLength == null || sVGLength.f9683a == 0.0d) {
                int size = this.U0.size();
                if (size > 0) {
                    S(paint, t().b());
                    for (int i10 = 0; i10 < size; i10++) {
                        canvas.save();
                        canvas.concat((Matrix) this.V0.get(i10));
                        canvas.drawText((String) this.U0.get(i10), 0.0f, 0.0f, paint);
                        canvas.restore();
                    }
                }
                q(canvas, paint, f10);
                return;
            }
            if (setupFillPaint(paint, this.fillOpacity * f10)) {
                T(canvas, paint);
            }
            if (setupStrokePaint(paint, f10 * this.strokeOpacity)) {
                T(canvas, paint);
                return;
            }
            return;
        }
        clip(canvas, paint);
        p(canvas, paint, f10);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.R0;
        if (path != null) {
            return path;
        }
        if (this.S0 == null) {
            Path C = C(canvas, paint);
            this.R0 = C;
            return C;
        }
        Z();
        v();
        this.R0 = V(a0(this.S0), paint, canvas);
        u();
        return this.R0;
    }

    public int hitTest(float[] fArr) {
        Region region;
        if (this.S0 == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            initBounds();
            Region region2 = this.mRegion;
            if ((region2 != null && region2.contains(round, round2)) || ((region = this.mStrokeRegion) != null && region.contains(round, round2))) {
                if (getClipPath() == null || this.mClipRegion.contains(round, round2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }

    public void invalidate() {
        this.R0 = null;
        super.invalidate();
    }
}
