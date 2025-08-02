package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
class RectView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9675a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9676b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9677c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9678d;

    /* renamed from: e  reason: collision with root package name */
    private SVGLength f9679e;

    /* renamed from: f  reason: collision with root package name */
    private SVGLength f9680f;

    public RectView(ReactContext reactContext) {
        super(reactContext);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Path getPath(android.graphics.Canvas r22, android.graphics.Paint r23) {
        /*
            r21 = this;
            r0 = r21
            android.graphics.Path r11 = new android.graphics.Path
            r11.<init>()
            com.horcrux.svg.SVGLength r3 = r0.f9675a
            double r12 = r0.relativeOnWidth(r3)
            com.horcrux.svg.SVGLength r3 = r0.f9676b
            double r14 = r0.relativeOnHeight(r3)
            com.horcrux.svg.SVGLength r3 = r0.f9677c
            double r16 = r0.relativeOnWidth(r3)
            com.horcrux.svg.SVGLength r3 = r0.f9678d
            double r18 = r0.relativeOnHeight(r3)
            com.horcrux.svg.SVGLength r3 = r0.f9679e
            if (r3 != 0) goto L_0x003a
            com.horcrux.svg.SVGLength r4 = r0.f9680f
            if (r4 == 0) goto L_0x0028
            goto L_0x003a
        L_0x0028:
            float r4 = (float) r12
            float r5 = (float) r14
            double r6 = r12 + r16
            float r6 = (float) r6
            double r7 = r14 + r18
            float r7 = (float) r7
            android.graphics.Path$Direction r8 = android.graphics.Path.Direction.CW
            r3 = r11
            r3.addRect(r4, r5, r6, r7, r8)
            r11.close()
            goto L_0x007f
        L_0x003a:
            if (r3 != 0) goto L_0x0044
            com.horcrux.svg.SVGLength r3 = r0.f9680f
            double r3 = r0.relativeOnHeight(r3)
        L_0x0042:
            r5 = r3
            goto L_0x0057
        L_0x0044:
            com.horcrux.svg.SVGLength r4 = r0.f9680f
            if (r4 != 0) goto L_0x004d
            double r3 = r0.relativeOnWidth(r3)
            goto L_0x0042
        L_0x004d:
            double r3 = r0.relativeOnWidth(r3)
            com.horcrux.svg.SVGLength r5 = r0.f9680f
            double r5 = r0.relativeOnHeight(r5)
        L_0x0057:
            r7 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r9 = r16 / r7
            int r20 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r20 <= 0) goto L_0x0060
            r3 = r9
        L_0x0060:
            double r7 = r18 / r7
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0067
            r5 = r7
        L_0x0067:
            float r7 = (float) r12
            float r8 = (float) r14
            double r9 = r12 + r16
            float r9 = (float) r9
            double r1 = r14 + r18
            float r1 = (float) r1
            float r2 = (float) r3
            float r10 = (float) r5
            android.graphics.Path$Direction r20 = android.graphics.Path.Direction.CW
            r3 = r11
            r4 = r7
            r5 = r8
            r6 = r9
            r7 = r1
            r8 = r2
            r9 = r10
            r10 = r20
            r3.addRoundRect(r4, r5, r6, r7, r8, r9, r10)
        L_0x007f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.elements = r1
            com.horcrux.svg.m r2 = new com.horcrux.svg.m
            com.horcrux.svg.c r3 = com.horcrux.svg.c.kCGPathElementMoveToPoint
            com.horcrux.svg.o r4 = new com.horcrux.svg.o
            r4.<init>(r12, r14)
            r5 = 1
            com.horcrux.svg.o[] r6 = new com.horcrux.svg.o[r5]
            r7 = 0
            r6[r7] = r4
            r2.<init>(r3, r6)
            r1.add(r2)
            java.util.ArrayList<com.horcrux.svg.m> r1 = r0.elements
            com.horcrux.svg.m r2 = new com.horcrux.svg.m
            com.horcrux.svg.c r3 = com.horcrux.svg.c.kCGPathElementAddLineToPoint
            com.horcrux.svg.o r4 = new com.horcrux.svg.o
            double r8 = r12 + r16
            r4.<init>(r8, r14)
            com.horcrux.svg.o[] r6 = new com.horcrux.svg.o[r5]
            r6[r7] = r4
            r2.<init>(r3, r6)
            r1.add(r2)
            java.util.ArrayList<com.horcrux.svg.m> r1 = r0.elements
            com.horcrux.svg.m r2 = new com.horcrux.svg.m
            com.horcrux.svg.o r4 = new com.horcrux.svg.o
            r22 = r11
            double r10 = r14 + r18
            r4.<init>(r8, r10)
            com.horcrux.svg.o[] r6 = new com.horcrux.svg.o[r5]
            r6[r7] = r4
            r2.<init>(r3, r6)
            r1.add(r2)
            java.util.ArrayList<com.horcrux.svg.m> r1 = r0.elements
            com.horcrux.svg.m r2 = new com.horcrux.svg.m
            com.horcrux.svg.o r4 = new com.horcrux.svg.o
            r4.<init>(r12, r10)
            com.horcrux.svg.o[] r6 = new com.horcrux.svg.o[r5]
            r6[r7] = r4
            r2.<init>(r3, r6)
            r1.add(r2)
            java.util.ArrayList<com.horcrux.svg.m> r1 = r0.elements
            com.horcrux.svg.m r2 = new com.horcrux.svg.m
            com.horcrux.svg.o r4 = new com.horcrux.svg.o
            r4.<init>(r12, r14)
            com.horcrux.svg.o[] r5 = new com.horcrux.svg.o[r5]
            r5[r7] = r4
            r2.<init>(r3, r5)
            r1.add(r2)
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RectView.getPath(android.graphics.Canvas, android.graphics.Paint):android.graphics.Path");
    }

    public void p(Dynamic dynamic) {
        this.f9678d = SVGLength.b(dynamic);
        invalidate();
    }

    public void q(Dynamic dynamic) {
        this.f9679e = SVGLength.b(dynamic);
        invalidate();
    }

    public void r(Dynamic dynamic) {
        this.f9680f = SVGLength.b(dynamic);
        invalidate();
    }

    public void s(Dynamic dynamic) {
        this.f9677c = SVGLength.b(dynamic);
        invalidate();
    }

    public void t(Dynamic dynamic) {
        this.f9675a = SVGLength.b(dynamic);
        invalidate();
    }

    public void u(Dynamic dynamic) {
        this.f9676b = SVGLength.b(dynamic);
        invalidate();
    }
}
