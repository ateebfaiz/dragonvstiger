package com.facebook.react.views.text;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.r1;
import com.facebook.react.uimanager.t0;
import com.facebook.yoga.e;
import com.facebook.yoga.f;
import com.facebook.yoga.n;
import com.facebook.yoga.o;
import com.facebook.yoga.q;
import java.util.ArrayList;
import java.util.Map;
import w7.j;

public class h extends c {
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public static final TextPaint f4218f0 = new TextPaint(1);
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public Spannable f4219b0;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public boolean f4220c0;

    /* renamed from: d0  reason: collision with root package name */
    private final n f4221d0 = new a();

    /* renamed from: e0  reason: collision with root package name */
    private final com.facebook.yoga.b f4222e0 = new b();

    class a implements n {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0168, code lost:
            if (r2 > r21) goto L_0x016a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long U(com.facebook.yoga.q r18, float r19, com.facebook.yoga.o r20, float r21, com.facebook.yoga.o r22) {
            /*
                r17 = this;
                r0 = r17
                r1 = r19
                r2 = r20
                r3 = r22
                com.facebook.react.views.text.h r4 = com.facebook.react.views.text.h.this
                android.text.Spannable r4 = r4.f4219b0
                java.lang.String r5 = "Spannable element has not been prepared in onBeforeLayout"
                java.lang.Object r4 = p5.a.d(r4, r5)
                android.text.Spannable r4 = (android.text.Spannable) r4
                com.facebook.react.views.text.h r5 = com.facebook.react.views.text.h.this
                android.text.Layout r5 = r5.E1(r4, r1, r2)
                com.facebook.react.views.text.h r6 = com.facebook.react.views.text.h.this
                boolean r7 = r6.T
                r8 = -1
                r9 = 0
                r10 = 1
                if (r7 == 0) goto L_0x00ba
                com.facebook.react.views.text.q r6 = r6.A
                int r6 = r6.c()
                com.facebook.react.views.text.h r7 = com.facebook.react.views.text.h.this
                com.facebook.react.views.text.q r7 = r7.A
                int r7 = r7.c()
                com.facebook.react.views.text.h r11 = com.facebook.react.views.text.h.this
                float r11 = r11.U
                float r6 = (float) r6
                float r11 = r11 * r6
                r12 = 1082130432(0x40800000, float:4.0)
                float r12 = com.facebook.react.uimanager.g0.d(r12)
                float r11 = java.lang.Math.max(r11, r12)
                int r11 = (int) r11
            L_0x0044:
                if (r7 <= r11) goto L_0x00ba
                com.facebook.react.views.text.h r12 = com.facebook.react.views.text.h.this
                int r12 = r12.H
                if (r12 == r8) goto L_0x0056
                int r12 = r5.getLineCount()
                com.facebook.react.views.text.h r13 = com.facebook.react.views.text.h.this
                int r13 = r13.H
                if (r12 > r13) goto L_0x0063
            L_0x0056:
                com.facebook.yoga.o r12 = com.facebook.yoga.o.UNDEFINED
                if (r3 == r12) goto L_0x00ba
                int r12 = r5.getHeight()
                float r12 = (float) r12
                int r12 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
                if (r12 <= 0) goto L_0x00ba
            L_0x0063:
                r5 = 1065353216(0x3f800000, float:1.0)
                float r5 = com.facebook.react.uimanager.g0.d(r5)
                int r5 = (int) r5
                int r5 = java.lang.Math.max(r10, r5)
                int r7 = r7 - r5
                float r5 = (float) r7
                float r5 = r5 / r6
                int r12 = r4.length()
                java.lang.Class<com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan> r13 = com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan.class
                java.lang.Object[] r12 = r4.getSpans(r9, r12, r13)
                com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan[] r12 = (com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan[]) r12
                int r13 = r12.length
                r14 = r9
            L_0x007f:
                if (r14 >= r13) goto L_0x00b0
                r15 = r12[r14]
                com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan r9 = new com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan
                int r10 = r15.getSize()
                float r10 = (float) r10
                float r10 = r10 * r5
                float r8 = (float) r11
                float r8 = java.lang.Math.max(r10, r8)
                int r8 = (int) r8
                r9.<init>(r8)
                int r8 = r4.getSpanStart(r15)
                int r10 = r4.getSpanEnd(r15)
                r16 = r5
                int r5 = r4.getSpanFlags(r15)
                r4.setSpan(r9, r8, r10, r5)
                r4.removeSpan(r15)
                int r14 = r14 + 1
                r5 = r16
                r8 = -1
                r9 = 0
                r10 = 1
                goto L_0x007f
            L_0x00b0:
                com.facebook.react.views.text.h r5 = com.facebook.react.views.text.h.this
                android.text.Layout r5 = r5.E1(r4, r1, r2)
                r8 = -1
                r9 = 0
                r10 = 1
                goto L_0x0044
            L_0x00ba:
                com.facebook.react.views.text.h r6 = com.facebook.react.views.text.h.this
                boolean r6 = r6.f4220c0
                if (r6 == 0) goto L_0x00ff
                com.facebook.react.views.text.h r6 = com.facebook.react.views.text.h.this
                com.facebook.react.uimanager.e1 r6 = r6.F()
                android.text.TextPaint r7 = com.facebook.react.views.text.h.f4218f0
                com.facebook.react.bridge.WritableArray r7 = com.facebook.react.views.text.b.a(r4, r5, r7, r6)
                com.facebook.react.bridge.WritableMap r8 = com.facebook.react.bridge.Arguments.createMap()
                java.lang.String r9 = "lines"
                r8.putArray(r9, r7)
                boolean r7 = r6.hasActiveReactInstance()
                if (r7 == 0) goto L_0x00f3
                java.lang.Class<com.facebook.react.uimanager.events.RCTEventEmitter> r7 = com.facebook.react.uimanager.events.RCTEventEmitter.class
                com.facebook.react.bridge.JavaScriptModule r6 = r6.getJSModule(r7)
                com.facebook.react.uimanager.events.RCTEventEmitter r6 = (com.facebook.react.uimanager.events.RCTEventEmitter) r6
                com.facebook.react.views.text.h r7 = com.facebook.react.views.text.h.this
                int r7 = r7.q()
                java.lang.String r9 = "topTextLayout"
                r6.receiveEvent(r7, r9, r8)
                goto L_0x00ff
            L_0x00f3:
                com.facebook.react.bridge.ReactNoCrashSoftException r6 = new com.facebook.react.bridge.ReactNoCrashSoftException
                java.lang.String r7 = "Cannot get RCTEventEmitter, no CatalystInstance"
                r6.<init>((java.lang.String) r7)
                java.lang.String r7 = "ReactTextShadowNode"
                com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r7, r6)
            L_0x00ff:
                com.facebook.react.views.text.h r6 = com.facebook.react.views.text.h.this
                int r6 = r6.H
                r7 = -1
                if (r6 != r7) goto L_0x010b
                int r6 = r5.getLineCount()
                goto L_0x0113
            L_0x010b:
                int r7 = r5.getLineCount()
                int r6 = java.lang.Math.min(r6, r7)
            L_0x0113:
                com.facebook.yoga.o r7 = com.facebook.yoga.o.EXACTLY
                if (r2 != r7) goto L_0x0118
                goto L_0x014b
            L_0x0118:
                r7 = 0
                r9 = 0
            L_0x011a:
                if (r9 >= r6) goto L_0x0141
                int r8 = r4.length()
                if (r8 <= 0) goto L_0x0135
                int r8 = r5.getLineEnd(r9)
                r10 = 1
                int r8 = r8 - r10
                char r8 = r4.charAt(r8)
                r10 = 10
                if (r8 != r10) goto L_0x0135
                float r8 = r5.getLineMax(r9)
                goto L_0x0139
            L_0x0135:
                float r8 = r5.getLineWidth(r9)
            L_0x0139:
                int r10 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r10 <= 0) goto L_0x013e
                r7 = r8
            L_0x013e:
                int r9 = r9 + 1
                goto L_0x011a
            L_0x0141:
                com.facebook.yoga.o r4 = com.facebook.yoga.o.AT_MOST
                if (r2 != r4) goto L_0x014a
                int r2 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r2 <= 0) goto L_0x014a
                goto L_0x014b
            L_0x014a:
                r1 = r7
            L_0x014b:
                int r2 = android.os.Build.VERSION.SDK_INT
                r4 = 29
                if (r2 <= r4) goto L_0x0157
                double r1 = (double) r1
                double r1 = java.lang.Math.ceil(r1)
                float r1 = (float) r1
            L_0x0157:
                com.facebook.yoga.o r2 = com.facebook.yoga.o.EXACTLY
                if (r3 == r2) goto L_0x016a
                r2 = 1
                int r6 = r6 - r2
                int r2 = r5.getLineBottom(r6)
                float r2 = (float) r2
                com.facebook.yoga.o r4 = com.facebook.yoga.o.AT_MOST
                if (r3 != r4) goto L_0x016c
                int r3 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
                if (r3 <= 0) goto L_0x016c
            L_0x016a:
                r2 = r21
            L_0x016c:
                long r1 = com.facebook.yoga.p.a(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.h.a.U(com.facebook.yoga.q, float, com.facebook.yoga.o, float, com.facebook.yoga.o):long");
        }
    }

    class b implements com.facebook.yoga.b {
        b() {
        }

        public float a(q qVar, float f10, float f11) {
            Layout A1 = h.this.E1((Spannable) p5.a.d(h.this.f4219b0, "Spannable element has not been prepared in onBeforeLayout"), f10, o.EXACTLY);
            return (float) A1.getLineBaseline(A1.getLineCount() - 1);
        }
    }

    public h(m mVar) {
        super(mVar);
        D1();
    }

    private int C1() {
        int i10 = this.I;
        if (g0() != f.RTL) {
            return i10;
        }
        if (i10 == 5) {
            return 3;
        }
        if (i10 == 3) {
            return 5;
        }
        return i10;
    }

    private void D1() {
        if (!t()) {
            X0(this.f4221d0);
            F0(this.f4222e0);
        }
    }

    /* access modifiers changed from: private */
    public Layout E1(Spannable spannable, float f10, o oVar) {
        float f11;
        boolean z10;
        TextPaint textPaint = f4218f0;
        textPaint.setTextSize((float) this.A.c());
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannable, textPaint);
        if (isBoring == null) {
            f11 = Layout.getDesiredWidth(spannable, textPaint);
        } else {
            f11 = Float.NaN;
        }
        if (oVar == o.UNDEFINED || f10 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int C1 = C1();
        if (C1 == 1) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (C1 != 3 && C1 == 5) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        Layout.Alignment alignment2 = alignment;
        if (isBoring == null && (z10 || (!e.a(f11) && f11 <= f10))) {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) Math.ceil((double) f11)).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.S).setBreakStrategy(this.J).setHyphenationFrequency(this.K);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                StaticLayout.Builder unused = hyphenationFrequency.setJustificationMode(this.L);
            }
            if (i10 >= 28) {
                StaticLayout.Builder unused2 = hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        } else if (isBoring == null || (!z10 && ((float) isBoring.width) > f10)) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 > 29) {
                f10 = (float) Math.ceil((double) f10);
            }
            StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) f10).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.S).setBreakStrategy(this.J).setHyphenationFrequency(this.K);
            if (i11 >= 28) {
                StaticLayout.Builder unused3 = hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency2.build();
        } else {
            return BoringLayout.make(spannable, textPaint, Math.max(isBoring.width, 0), alignment2, 1.0f, 0.0f, isBoring, this.S);
        }
    }

    public void V(d0 d0Var) {
        this.f4219b0 = x1(this, (String) null, true, d0Var);
        x0();
    }

    public Iterable n() {
        Map map = this.f4204a0;
        if (map == null || map.isEmpty()) {
            return null;
        }
        Spanned spanned = (Spanned) p5.a.d(this.f4219b0, "Spannable element has not been prepared in onBeforeLayout");
        j[] jVarArr = (j[]) spanned.getSpans(0, spanned.length(), j.class);
        ArrayList arrayList = new ArrayList(jVarArr.length);
        for (j b10 : jVarArr) {
            t0 t0Var = (t0) this.f4204a0.get(Integer.valueOf(b10.b()));
            t0Var.s();
            arrayList.add(t0Var);
        }
        return arrayList;
    }

    public boolean o0() {
        return true;
    }

    @h7.a(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z10) {
        this.f4220c0 = z10;
    }

    public boolean u0() {
        return false;
    }

    public void x0() {
        super.x0();
        super.h();
    }

    public void z0(r1 r1Var) {
        super.z0(r1Var);
        Spannable spannable = this.f4219b0;
        if (spannable != null) {
            r1Var.O(q(), new i(spannable, -1, this.Z, k0(4), k0(1), k0(5), k0(3), C1(), this.J, this.L));
        }
    }
}
