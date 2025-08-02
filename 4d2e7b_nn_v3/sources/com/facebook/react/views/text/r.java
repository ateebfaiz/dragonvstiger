package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.mapbuffer.a;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.i0;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.yoga.e;
import com.facebook.yoga.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import w7.b;
import w7.c;
import w7.d;
import w7.f;
import w7.g;
import w7.h;
import w7.j;

public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4268a = "r";

    /* renamed from: b  reason: collision with root package name */
    private static final TextPaint f4269b = new TextPaint(1);

    /* renamed from: c  reason: collision with root package name */
    private static final ConcurrentHashMap f4270c = new ConcurrentHashMap();

    public static void a(Spannable spannable, float f10, o oVar, float f11, o oVar2, double d10, int i10, boolean z10, int i11, int i12, Layout.Alignment alignment) {
        Spannable spannable2 = spannable;
        int i13 = i10;
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannable2, f4269b);
        Layout c10 = c(spannable, isBoring, f10, oVar, z10, i11, i12, alignment);
        int d11 = (int) (Double.isNaN(d10) ? (double) g0.d(4.0f) : d10);
        int i14 = 0;
        Class<ReactAbsoluteSizeSpan> cls = ReactAbsoluteSizeSpan.class;
        int i15 = d11;
        for (ReactAbsoluteSizeSpan size : (ReactAbsoluteSizeSpan[]) spannable2.getSpans(0, spannable.length(), cls)) {
            i15 = Math.max(i15, size.getSize());
        }
        int i16 = i15;
        while (i16 > d11) {
            if (i13 != -1 && i13 != 0 && c10.getLineCount() > i13) {
                o oVar3 = oVar2;
            } else if (oVar2 == o.UNDEFINED || ((float) c10.getHeight()) <= f11) {
                return;
            }
            int max = i16 - Math.max(1, (int) g0.d(1.0f));
            float f12 = ((float) max) / ((float) i15);
            ReactAbsoluteSizeSpan[] reactAbsoluteSizeSpanArr = (ReactAbsoluteSizeSpan[]) spannable2.getSpans(i14, spannable.length(), cls);
            int length = reactAbsoluteSizeSpanArr.length;
            int i17 = i14;
            while (i17 < length) {
                ReactAbsoluteSizeSpan reactAbsoluteSizeSpan = reactAbsoluteSizeSpanArr[i17];
                spannable2.setSpan(new ReactAbsoluteSizeSpan((int) Math.max(((float) reactAbsoluteSizeSpan.getSize()) * f12, (float) d11)), spannable2.getSpanStart(reactAbsoluteSizeSpan), spannable2.getSpanEnd(reactAbsoluteSizeSpan), spannable2.getSpanFlags(reactAbsoluteSizeSpan));
                spannable2.removeSpan(reactAbsoluteSizeSpan);
                i17++;
                f12 = f12;
            }
            c10 = c(spannable, isBoring, f10, oVar, z10, i11, i12, alignment);
            i16 = max;
            i14 = 0;
        }
    }

    private static void b(Context context, a aVar, SpannableStringBuilder spannableStringBuilder, List list) {
        int i10;
        i0.f fVar;
        List list2 = list;
        int count = aVar.getCount();
        for (int i11 = 0; i11 < count; i11++) {
            a h10 = aVar.h(i11);
            int length = spannableStringBuilder.length();
            p a10 = p.a(h10.h(5));
            spannableStringBuilder.append(s.b(h10.getString(0), a10.f4248n));
            int length2 = spannableStringBuilder.length();
            if (h10.b(1)) {
                i10 = h10.getInt(1);
            } else {
                i10 = -1;
            }
            if (h10.b(2) && h10.getBoolean(2)) {
                list2.add(new g(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new j(i10, (int) g0.e(h10.getDouble(3)), (int) g0.e(h10.getDouble(4)))));
            } else if (length2 >= length) {
                if ((fVar = a10.f4257w) == null ? a10.f4256v == i0.e.LINK : fVar == i0.f.LINK) {
                    list2.add(new g(length, length2, new d(i10)));
                }
                if (a10.f4236b) {
                    list2.add(new g(length, length2, new ReactForegroundColorSpan(a10.f4238d)));
                }
                if (a10.f4239e) {
                    list2.add(new g(length, length2, new ReactBackgroundColorSpan(a10.f4240f)));
                }
                if (!Float.isNaN(a10.f())) {
                    list2.add(new g(length, length2, new w7.a(a10.f())));
                }
                list2.add(new g(length, length2, new ReactAbsoluteSizeSpan(a10.f4242h)));
                if (!(a10.f4258x == -1 && a10.f4259y == -1 && a10.f4260z == null)) {
                    list2.add(new g(length, length2, new c(a10.f4258x, a10.f4259y, a10.A, a10.f4260z, context.getAssets())));
                }
                if (a10.f4253s) {
                    list2.add(new g(length, length2, new ReactUnderlineSpan()));
                }
                if (a10.f4254t) {
                    list2.add(new g(length, length2, new ReactStrikethroughSpan()));
                }
                if (!((a10.f4249o == 0.0f && a10.f4250p == 0.0f && a10.f4251q == 0.0f) || Color.alpha(a10.f4252r) == 0)) {
                    list2.add(new g(length, length2, new h(a10.f4249o, a10.f4250p, a10.f4251q, a10.f4252r)));
                }
                if (!Float.isNaN(a10.b())) {
                    list2.add(new g(length, length2, new b(a10.b())));
                }
                list2.add(new g(length, length2, new f(i10)));
            }
        }
    }

    private static Layout c(Spannable spannable, BoringLayout.Metrics metrics, float f10, o oVar, boolean z10, int i10, int i11, Layout.Alignment alignment) {
        boolean z11;
        float f11;
        TextDirectionHeuristic textDirectionHeuristic;
        int i12;
        TextDirectionHeuristic textDirectionHeuristic2;
        Spannable spannable2 = spannable;
        BoringLayout.Metrics metrics2 = metrics;
        float f12 = f10;
        o oVar2 = oVar;
        boolean z12 = z10;
        int i13 = i10;
        int i14 = i11;
        Layout.Alignment alignment2 = alignment;
        int length = spannable.length();
        if (oVar2 == o.UNDEFINED || f12 < 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (metrics2 == null) {
            f11 = Layout.getDesiredWidth(spannable2, f4269b);
        } else {
            f11 = Float.NaN;
        }
        boolean isRtl = TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable2, 0, length);
        if (metrics2 == null && (z11 || (!e.a(f11) && f11 <= f12))) {
            if (oVar2 == o.EXACTLY) {
                f11 = f12;
            }
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable2, 0, length, f4269b, (int) Math.ceil((double) f11)).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(z12).setBreakStrategy(i13).setHyphenationFrequency(i14);
            if (isRtl) {
                textDirectionHeuristic2 = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic2 = TextDirectionHeuristics.LTR;
            }
            return hyphenationFrequency.setTextDirection(textDirectionHeuristic2).build();
        } else if (metrics2 == null || (!z11 && ((float) metrics2.width) > f12)) {
            StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannable2, 0, length, f4269b, (int) Math.ceil((double) f12)).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(z12).setBreakStrategy(i13).setHyphenationFrequency(i14);
            if (isRtl) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            StaticLayout.Builder textDirection = hyphenationFrequency2.setTextDirection(textDirectionHeuristic);
            if (Build.VERSION.SDK_INT >= 28) {
                StaticLayout.Builder unused = textDirection.setUseLineSpacingFromFallbacks(true);
            }
            return textDirection.build();
        } else {
            int i15 = metrics2.width;
            if (oVar2 == o.EXACTLY) {
                i15 = (int) Math.ceil((double) f12);
            }
            if (metrics2.width < 0) {
                ReactSoftExceptionLogger.logSoftException(f4268a, new ReactNoCrashSoftException("Text width is invalid: " + metrics2.width));
                i12 = 0;
            } else {
                i12 = i15;
            }
            return BoringLayout.make(spannable, f4269b, i12, alignment, 1.0f, 0.0f, metrics, z10);
        }
    }

    private static Spannable d(Context context, a aVar, m mVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        b(context, aVar.h(2), spannableStringBuilder, arrayList);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((g) arrayList.get((arrayList.size() - i10) - 1)).a(spannableStringBuilder, i10);
        }
        if (mVar != null) {
            mVar.a(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public static void e(int i10) {
        f4270c.remove(Integer.valueOf(i10));
    }

    public static Spannable f(Context context, a aVar, m mVar) {
        if (!aVar.b(3)) {
            return d(context, aVar, mVar);
        }
        return (Spannable) f4270c.get(Integer.valueOf(aVar.getInt(3)));
    }

    public static Layout.Alignment g(a aVar, Spannable spannable) {
        boolean z10;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        if (!aVar.b(2)) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (i(aVar) != TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spannable, 0, spannable.length())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        } else {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        }
        a h10 = aVar.h(2);
        if (h10.getCount() == 0) {
            return alignment;
        }
        a h11 = h10.h(0).h(5);
        if (!h11.b(12)) {
            return alignment;
        }
        String string = h11.getString(12);
        if (string.equals("center")) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (!string.equals("right")) {
            return alignment;
        }
        if (z10) {
            alignment2 = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment2 = Layout.Alignment.ALIGN_OPPOSITE;
        }
        return alignment2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        if (r4 != false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r4 != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int h(com.facebook.react.common.mapbuffer.a r3, android.text.Spannable r4, int r5) {
        /*
            android.text.Layout$Alignment r3 = g(r3, r4)
            android.text.TextDirectionHeuristic r0 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            int r1 = r4.length()
            r2 = 0
            boolean r4 = r0.isRtl(r4, r2, r1)
            android.text.Layout$Alignment r0 = android.text.Layout.Alignment.ALIGN_NORMAL
            r1 = 3
            r2 = 5
            if (r3 != r0) goto L_0x001b
            if (r4 == 0) goto L_0x0019
        L_0x0017:
            r5 = r2
            goto L_0x0027
        L_0x0019:
            r5 = r1
            goto L_0x0027
        L_0x001b:
            android.text.Layout$Alignment r0 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            if (r3 != r0) goto L_0x0022
            if (r4 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0022:
            android.text.Layout$Alignment r4 = android.text.Layout.Alignment.ALIGN_CENTER
            if (r3 != r4) goto L_0x0027
            r5 = 1
        L_0x0027:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.r.h(com.facebook.react.common.mapbuffer.a, android.text.Spannable, int):int");
    }

    public static boolean i(a aVar) {
        if (!aVar.b(2)) {
            return false;
        }
        a h10 = aVar.h(2);
        if (h10.getCount() == 0) {
            return false;
        }
        a h11 = h10.h(0).h(5);
        if (h11.b(23) && p.e(h11.getString(23)) == 1) {
            return true;
        }
        return false;
    }

    public static WritableArray j(Context context, a aVar, a aVar2, float f10, float f11) {
        boolean z10;
        boolean z11;
        int i10;
        TextPaint textPaint;
        double d10;
        Context context2 = context;
        a aVar3 = aVar;
        a aVar4 = aVar2;
        Spannable f12 = f(context2, aVar3, (m) null);
        TextPaint textPaint2 = f4269b;
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(f12, textPaint2);
        int h10 = p.h(aVar4.getString(2));
        if (aVar4.b(4)) {
            z10 = aVar4.getBoolean(4);
        } else {
            z10 = true;
        }
        boolean z12 = z10;
        int h11 = p.h(aVar4.getString(5));
        if (aVar4.b(3)) {
            z11 = aVar4.getBoolean(3);
        } else {
            z11 = false;
        }
        if (aVar4.b(0)) {
            i10 = aVar4.getInt(0);
        } else {
            i10 = -1;
        }
        int i11 = i10;
        Layout.Alignment g10 = g(aVar3, f12);
        if (z11) {
            if (aVar4.b(6)) {
                d10 = aVar4.getDouble(6);
            } else {
                d10 = Double.NaN;
            }
            textPaint = textPaint2;
            a(f12, f10, o.EXACTLY, f11, o.UNDEFINED, d10, i11, z12, h10, h11, g10);
        } else {
            textPaint = textPaint2;
        }
        return b.a(f12, c(f12, isBoring, f10, o.EXACTLY, z12, h10, h11, g10), textPaint, context2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e8, code lost:
        if (r2 > r24) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010b, code lost:
        if (r1 > r26) goto L_0x010d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long k(android.content.Context r21, com.facebook.react.common.mapbuffer.a r22, com.facebook.react.common.mapbuffer.a r23, float r24, com.facebook.yoga.o r25, float r26, com.facebook.yoga.o r27, com.facebook.react.views.text.m r28, float[] r29) {
        /*
            r0 = r22
            r1 = r23
            r12 = r25
            r13 = r27
            r2 = r21
            r3 = r28
            android.text.Spannable r14 = f(r2, r0, r3)
            if (r14 != 0) goto L_0x0015
            r0 = 0
            return r0
        L_0x0015:
            r2 = 2
            java.lang.String r2 = r1.getString(r2)
            int r15 = com.facebook.react.views.text.p.h(r2)
            r2 = 4
            boolean r3 = r1.b(r2)
            r16 = 1
            if (r3 == 0) goto L_0x002e
            boolean r2 = r1.getBoolean(r2)
            r17 = r2
            goto L_0x0030
        L_0x002e:
            r17 = r16
        L_0x0030:
            r2 = 5
            java.lang.String r2 = r1.getString(r2)
            int r18 = com.facebook.react.views.text.p.c(r2)
            r2 = 3
            boolean r3 = r1.b(r2)
            r11 = 0
            if (r3 == 0) goto L_0x0046
            boolean r2 = r1.getBoolean(r2)
            goto L_0x0047
        L_0x0046:
            r2 = r11
        L_0x0047:
            boolean r3 = r1.b(r11)
            r10 = -1
            if (r3 == 0) goto L_0x0054
            int r3 = r1.getInt(r11)
            r9 = r3
            goto L_0x0055
        L_0x0054:
            r9 = r10
        L_0x0055:
            android.text.Layout$Alignment r19 = g(r0, r14)
            if (r2 == 0) goto L_0x0084
            r0 = 6
            boolean r2 = r1.b(r0)
            if (r2 == 0) goto L_0x0068
            double r0 = r1.getDouble(r0)
        L_0x0066:
            r5 = r0
            goto L_0x006b
        L_0x0068:
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0066
        L_0x006b:
            r0 = r14
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r7 = r9
            r8 = r17
            r13 = r9
            r9 = r15
            r12 = r10
            r10 = r18
            r20 = r11
            r11 = r19
            a(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10, r11)
            goto L_0x0088
        L_0x0084:
            r13 = r9
            r12 = r10
            r20 = r11
        L_0x0088:
            android.text.TextPaint r0 = f4269b
            android.text.BoringLayout$Metrics r1 = android.text.BoringLayout.isBoring(r14, r0)
            r0 = r14
            r2 = r24
            r3 = r25
            r4 = r17
            r5 = r15
            r6 = r18
            r7 = r19
            android.text.Layout r0 = c(r0, r1, r2, r3, r4, r5, r6, r7)
            if (r13 == r12) goto L_0x00ac
            if (r13 != 0) goto L_0x00a3
            goto L_0x00ac
        L_0x00a3:
            int r1 = r0.getLineCount()
            int r1 = java.lang.Math.min(r13, r1)
            goto L_0x00b0
        L_0x00ac:
            int r1 = r0.getLineCount()
        L_0x00b0:
            com.facebook.yoga.o r2 = com.facebook.yoga.o.EXACTLY
            r3 = 10
            r4 = r25
            r5 = r12
            if (r4 != r2) goto L_0x00ba
            goto L_0x00ea
        L_0x00ba:
            r2 = 0
            r11 = r20
        L_0x00bd:
            if (r11 >= r1) goto L_0x00e2
            int r6 = r14.length()
            if (r6 <= 0) goto L_0x00d6
            int r6 = r0.getLineEnd(r11)
            int r6 = r6 + -1
            char r6 = r14.charAt(r6)
            if (r6 != r3) goto L_0x00d6
            float r6 = r0.getLineMax(r11)
            goto L_0x00da
        L_0x00d6:
            float r6 = r0.getLineWidth(r11)
        L_0x00da:
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x00df
            r2 = r6
        L_0x00df:
            int r11 = r11 + 1
            goto L_0x00bd
        L_0x00e2:
            com.facebook.yoga.o r6 = com.facebook.yoga.o.AT_MOST
            if (r4 != r6) goto L_0x00ec
            int r4 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ec
        L_0x00ea:
            r2 = r24
        L_0x00ec:
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r4 <= r6) goto L_0x00f8
            double r6 = (double) r2
            double r6 = java.lang.Math.ceil(r6)
            float r2 = (float) r6
        L_0x00f8:
            com.facebook.yoga.o r4 = com.facebook.yoga.o.EXACTLY
            r6 = r27
            if (r6 == r4) goto L_0x010d
            int r1 = r1 + -1
            int r1 = r0.getLineBottom(r1)
            float r1 = (float) r1
            com.facebook.yoga.o r4 = com.facebook.yoga.o.AT_MOST
            if (r6 != r4) goto L_0x010f
            int r4 = (r1 > r26 ? 1 : (r1 == r26 ? 0 : -1))
            if (r4 <= 0) goto L_0x010f
        L_0x010d:
            r1 = r26
        L_0x010f:
            r4 = r20
            r11 = r4
        L_0x0112:
            int r6 = r14.length()
            if (r11 >= r6) goto L_0x01dc
            int r6 = r14.length()
            java.lang.Class<w7.j> r7 = w7.j.class
            int r6 = r14.nextSpanTransition(r11, r6, r7)
            java.lang.Object[] r7 = r14.getSpans(r11, r6, r7)
            w7.j[] r7 = (w7.j[]) r7
            int r8 = r7.length
            r11 = r20
        L_0x012b:
            if (r11 >= r8) goto L_0x01d9
            r9 = r7[r11]
            int r10 = r14.getSpanStart(r9)
            int r12 = r0.getLineForOffset(r10)
            int r13 = r0.getEllipsisCount(r12)
            if (r13 <= 0) goto L_0x0152
            int r13 = r0.getLineStart(r12)
            int r15 = r0.getEllipsisStart(r12)
            int r13 = r13 + r15
            if (r10 < r13) goto L_0x0152
            int r13 = r0.getLineEnd(r12)
            if (r10 < r13) goto L_0x014f
            goto L_0x0152
        L_0x014f:
            r5 = r3
            goto L_0x01d3
        L_0x0152:
            int r13 = r9.c()
            float r13 = (float) r13
            int r9 = r9.a()
            float r9 = (float) r9
            boolean r15 = r0.isRtlCharAt(r10)
            int r3 = r0.getParagraphDirection(r12)
            if (r3 != r5) goto L_0x0169
            r3 = r16
            goto L_0x016b
        L_0x0169:
            r3 = r20
        L_0x016b:
            int r17 = r14.length()
            int r5 = r17 + -1
            if (r10 != r5) goto L_0x019e
            int r5 = r14.length()
            if (r5 <= 0) goto L_0x018c
            int r5 = r0.getLineEnd(r12)
            int r5 = r5 + -1
            char r5 = r14.charAt(r5)
            r10 = 10
            if (r5 != r10) goto L_0x018e
            float r5 = r0.getLineMax(r12)
            goto L_0x0192
        L_0x018c:
            r10 = 10
        L_0x018e:
            float r5 = r0.getLineWidth(r12)
        L_0x0192:
            if (r3 == 0) goto L_0x0197
            float r3 = r2 - r5
            goto L_0x019c
        L_0x0197:
            float r3 = r0.getLineRight(r12)
            float r3 = r3 - r13
        L_0x019c:
            r5 = r10
            goto L_0x01bb
        L_0x019e:
            r5 = 10
            if (r3 != r15) goto L_0x01a7
            float r10 = r0.getPrimaryHorizontal(r10)
            goto L_0x01ab
        L_0x01a7:
            float r10 = r0.getSecondaryHorizontal(r10)
        L_0x01ab:
            if (r3 == 0) goto L_0x01b7
            if (r15 != 0) goto L_0x01b7
            float r3 = r0.getLineRight(r12)
            float r3 = r3 - r10
            float r3 = r2 - r3
            goto L_0x01b8
        L_0x01b7:
            r3 = r10
        L_0x01b8:
            if (r15 == 0) goto L_0x01bb
            float r3 = r3 - r13
        L_0x01bb:
            int r10 = r0.getLineBaseline(r12)
            float r10 = (float) r10
            float r10 = r10 - r9
            int r9 = r4 * 2
            float r10 = com.facebook.react.uimanager.g0.b(r10)
            r29[r9] = r10
            int r9 = r9 + 1
            float r3 = com.facebook.react.uimanager.g0.b(r3)
            r29[r9] = r3
            int r4 = r4 + 1
        L_0x01d3:
            int r11 = r11 + 1
            r3 = r5
            r5 = -1
            goto L_0x012b
        L_0x01d9:
            r11 = r6
            goto L_0x0112
        L_0x01dc:
            float r0 = com.facebook.react.uimanager.g0.b(r2)
            float r1 = com.facebook.react.uimanager.g0.b(r1)
            long r0 = com.facebook.yoga.p.a(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.r.k(android.content.Context, com.facebook.react.common.mapbuffer.a, com.facebook.react.common.mapbuffer.a, float, com.facebook.yoga.o, float, com.facebook.yoga.o, com.facebook.react.views.text.m, float[]):long");
    }

    public static void l(int i10, Spannable spannable) {
        f4270c.put(Integer.valueOf(i10), spannable);
    }
}
