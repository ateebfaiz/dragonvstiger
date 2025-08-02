package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.m0;
import com.facebook.react.views.view.e;
import com.facebook.yoga.o;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Comparator;
import w7.f;
import w7.i;

public class ReactTextView extends AppCompatTextView implements m0 {
    private static final ViewGroup.LayoutParams O0 = new ViewGroup.LayoutParams(0, 0);
    private e C;
    private Spannable N0;

    /* renamed from: a  reason: collision with root package name */
    private boolean f4191a;

    /* renamed from: b  reason: collision with root package name */
    private int f4192b;

    /* renamed from: c  reason: collision with root package name */
    private TextUtils.TruncateAt f4193c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4194d;

    /* renamed from: e  reason: collision with root package name */
    private float f4195e;

    /* renamed from: f  reason: collision with root package name */
    private float f4196f;

    /* renamed from: g  reason: collision with root package name */
    private float f4197g;

    /* renamed from: h  reason: collision with root package name */
    private int f4198h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4199i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4200j;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4201w;

    class a implements Comparator {
        a() {
        }

        public int compare(Object obj, Object obj2) {
            return ((WritableMap) obj).getInt(FirebaseAnalytics.Param.INDEX) - ((WritableMap) obj2).getInt(FirebaseAnalytics.Param.INDEX);
        }
    }

    public ReactTextView(Context context) {
        super(context);
        b();
    }

    private void a() {
        if (!Float.isNaN(this.f4195e)) {
            setTextSize(0, this.f4195e);
        }
        if (!Float.isNaN(this.f4197g)) {
            super.setLetterSpacing(this.f4197g);
        }
    }

    private void b() {
        e eVar = this.C;
        if (eVar != null) {
            eVar.a();
        }
        this.C = new e(this);
        this.f4192b = Integer.MAX_VALUE;
        this.f4194d = false;
        this.f4198h = 0;
        this.f4199i = false;
        this.f4200j = false;
        this.f4201w = false;
        this.f4193c = TextUtils.TruncateAt.END;
        this.f4195e = Float.NaN;
        this.f4196f = Float.NaN;
        this.f4197g = 0.0f;
        this.N0 = null;
    }

    private static WritableMap c(int i10, int i11, int i12, int i13, int i14, int i15) {
        WritableMap createMap = Arguments.createMap();
        if (i10 == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt(FirebaseAnalytics.Param.INDEX, i11);
        } else if (i10 == 0) {
            createMap.putString("visibility", "visible");
            createMap.putInt(FirebaseAnalytics.Param.INDEX, i11);
            createMap.putDouble("left", (double) g0.b((float) i12));
            createMap.putDouble("top", (double) g0.b((float) i13));
            createMap.putDouble("right", (double) g0.b((float) i14));
            createMap.putDouble("bottom", (double) g0.b((float) i15));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt(FirebaseAnalytics.Param.INDEX, i11);
        }
        return createMap;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            return (ReactContext) ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        b();
        setBreakStrategy(0);
        setMovementMethod(getDefaultMovementMethod());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            setJustificationMode(0);
        }
        setLayoutParams(O0);
        super.setText((CharSequence) null);
        a();
        setGravity(8388659);
        setNumberOfLines(this.f4192b);
        setAdjustFontSizeToFit(this.f4194d);
        setLinkifyMask(this.f4198h);
        setTextIsSelectable(this.f4200j);
        setIncludeFontPadding(true);
        setEnabled(true);
        setLinkifyMask(0);
        setEllipsizeLocation(this.f4193c);
        setEnabled(true);
        if (i10 >= 26) {
            setFocusable(16);
        }
        setHyphenationFrequency(0);
        h();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (ViewCompat.hasAccessibilityDelegate(this)) {
            AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
            if (accessibilityDelegate instanceof ExploreByTouchHelper) {
                if (((ExploreByTouchHelper) accessibilityDelegate).dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
                    return true;
                }
                return false;
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public void e(int i10, float f10, float f11) {
        this.C.f(i10, f10, f11);
    }

    public void f(float f10, int i10) {
        this.C.h(f10, i10);
    }

    public void g(int i10, float f10) {
        this.C.j(i10, f10);
    }

    /* access modifiers changed from: package-private */
    public int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    public Spannable getSpanned() {
        return this.N0;
    }

    public void h() {
        TextUtils.TruncateAt truncateAt;
        if (this.f4192b == Integer.MAX_VALUE || this.f4194d) {
            truncateAt = null;
        } else {
            truncateAt = this.f4193c;
        }
        setEllipsize(truncateAt);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f4191a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (i a10 : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                if (a10.a() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTextIsSelectable(this.f4200j);
        if (this.f4191a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (i c10 : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                c10.c();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4191a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (i d10 : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                d10.d();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f4194d && getSpanned() != null && this.f4201w) {
            this.f4201w = false;
            o oVar = o.EXACTLY;
            r.a(getSpanned(), (float) getWidth(), oVar, (float) getHeight(), oVar, (double) this.f4196f, this.f4192b, getIncludeFontPadding(), getBreakStrategy(), getHyphenationFrequency(), Layout.Alignment.ALIGN_NORMAL);
            setText(getSpanned());
        }
        this.C.d(canvas);
        super.onDraw(canvas);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f4191a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (i e10 : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                e10.e();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0102, code lost:
        if (r5 != false) goto L_0x0104;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            r23 = this;
            r0 = r23
            int r1 = r23.getId()
            java.lang.CharSequence r2 = r23.getText()
            boolean r2 = r2 instanceof android.text.Spanned
            if (r2 == 0) goto L_0x01a4
            int r2 = i7.a.a(r1)
            r3 = 2
            if (r2 != r3) goto L_0x0017
            goto L_0x01a4
        L_0x0017:
            com.facebook.react.bridge.ReactContext r2 = r23.getReactContext()
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r3 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r2 = r2.getNativeModule(r3)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.Object r2 = p5.a.c(r2)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.CharSequence r3 = r23.getText()
            android.text.Spanned r3 = (android.text.Spanned) r3
            android.text.Layout r4 = r23.getLayout()
            if (r4 != 0) goto L_0x0036
            return
        L_0x0036:
            int r5 = r3.length()
            java.lang.Class<w7.j> r6 = w7.j.class
            r7 = 0
            java.lang.Object[] r5 = r3.getSpans(r7, r5, r6)
            w7.j[] r5 = (w7.j[]) r5
            boolean r6 = r0.f4199i
            if (r6 == 0) goto L_0x004e
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = r5.length
            r6.<init>(r8)
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            int r8 = r27 - r25
            int r9 = r28 - r26
            int r10 = r5.length
            r11 = r7
        L_0x0055:
            if (r11 >= r10) goto L_0x016c
            r12 = r5[r11]
            int r13 = r12.b()
            android.view.View r13 = r2.resolveView(r13)
            int r15 = r3.getSpanStart(r12)
            int r14 = r4.getLineForOffset(r15)
            int r16 = r4.getEllipsisCount(r14)
            if (r16 <= 0) goto L_0x0088
            int r16 = r4.getLineStart(r14)
            int r17 = r4.getEllipsisStart(r14)
            int r7 = r16 + r17
            if (r15 >= r7) goto L_0x007c
            goto L_0x0088
        L_0x007c:
            r21 = r1
            r22 = r3
            r20 = r5
            r28 = r10
            r1 = 8
            goto L_0x0147
        L_0x0088:
            int r7 = r0.f4192b
            if (r14 >= r7) goto L_0x007c
            int r7 = r4.getLineEnd(r14)
            if (r15 < r7) goto L_0x0093
            goto L_0x007c
        L_0x0093:
            int r7 = r12.c()
            int r12 = r12.a()
            r20 = r5
            boolean r5 = r4.isRtlCharAt(r15)
            r28 = r10
            int r10 = r4.getParagraphDirection(r14)
            r21 = r1
            r1 = -1
            r16 = 1
            if (r10 != r1) goto L_0x00b1
            r1 = r16
            goto L_0x00b2
        L_0x00b1:
            r1 = 0
        L_0x00b2:
            int r10 = r3.length()
            int r10 = r10 + -1
            if (r15 != r10) goto L_0x00e7
            int r10 = r3.length()
            if (r10 <= 0) goto L_0x00d5
            int r10 = r4.getLineEnd(r14)
            int r10 = r10 + -1
            char r10 = r3.charAt(r10)
            r22 = r3
            r3 = 10
            if (r10 != r3) goto L_0x00d7
            float r3 = r4.getLineMax(r14)
            goto L_0x00db
        L_0x00d5:
            r22 = r3
        L_0x00d7:
            float r3 = r4.getLineWidth(r14)
        L_0x00db:
            if (r1 == 0) goto L_0x00e1
            int r1 = (int) r3
            int r1 = r8 - r1
            goto L_0x0105
        L_0x00e1:
            float r1 = r4.getLineRight(r14)
            int r1 = (int) r1
            goto L_0x0104
        L_0x00e7:
            r22 = r3
            if (r1 != r5) goto L_0x00f1
            float r3 = r4.getPrimaryHorizontal(r15)
        L_0x00ef:
            int r3 = (int) r3
            goto L_0x00f6
        L_0x00f1:
            float r3 = r4.getSecondaryHorizontal(r15)
            goto L_0x00ef
        L_0x00f6:
            if (r1 == 0) goto L_0x0101
            float r1 = r4.getLineRight(r14)
            int r1 = (int) r1
            int r1 = r1 - r3
            int r1 = r8 - r1
            goto L_0x0102
        L_0x0101:
            r1 = r3
        L_0x0102:
            if (r5 == 0) goto L_0x0105
        L_0x0104:
            int r1 = r1 - r7
        L_0x0105:
            if (r5 == 0) goto L_0x010d
            int r3 = r23.getTotalPaddingRight()
        L_0x010b:
            int r1 = r1 + r3
            goto L_0x0112
        L_0x010d:
            int r3 = r23.getTotalPaddingLeft()
            goto L_0x010b
        L_0x0112:
            int r3 = r25 + r1
            int r5 = r23.getTotalPaddingTop()
            int r10 = r4.getLineBaseline(r14)
            int r5 = r5 + r10
            int r5 = r5 - r12
            int r10 = r26 + r5
            if (r8 <= r1) goto L_0x0127
            if (r9 > r5) goto L_0x0125
            goto L_0x0127
        L_0x0125:
            r14 = 0
            goto L_0x0129
        L_0x0127:
            r14 = 8
        L_0x0129:
            int r1 = r3 + r7
            int r5 = r10 + r12
            r13.setVisibility(r14)
            r13.layout(r3, r10, r1, r5)
            boolean r7 = r0.f4199i
            if (r7 == 0) goto L_0x015f
            r16 = r3
            r17 = r10
            r18 = r1
            r19 = r5
            com.facebook.react.bridge.WritableMap r1 = c(r14, r15, r16, r17, r18, r19)
            r6.add(r1)
            goto L_0x015f
        L_0x0147:
            r13.setVisibility(r1)
            boolean r1 = r0.f4199i
            if (r1 == 0) goto L_0x015f
            r18 = -1
            r19 = -1
            r14 = 8
            r16 = -1
            r17 = -1
            com.facebook.react.bridge.WritableMap r1 = c(r14, r15, r16, r17, r18, r19)
            r6.add(r1)
        L_0x015f:
            int r11 = r11 + 1
            r10 = r28
            r5 = r20
            r1 = r21
            r3 = r22
            r7 = 0
            goto L_0x0055
        L_0x016c:
            r21 = r1
            boolean r1 = r0.f4199i
            if (r1 == 0) goto L_0x01a4
            com.facebook.react.views.text.ReactTextView$a r1 = new com.facebook.react.views.text.ReactTextView$a
            r1.<init>()
            java.util.Collections.sort(r6, r1)
            com.facebook.react.bridge.WritableArray r1 = com.facebook.react.bridge.Arguments.createArray()
            java.util.Iterator r3 = r6.iterator()
        L_0x0182:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0192
            java.lang.Object r4 = r3.next()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            r1.pushMap(r4)
            goto L_0x0182
        L_0x0192:
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = "inlineViews"
            r3.putArray(r4, r1)
            if (r2 == 0) goto L_0x01a4
            java.lang.String r1 = "topInlineViewLayout"
            r4 = r21
            r2.receiveEvent(r4, r1, r3)
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f4191a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (i f10 : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                f10.f();
            }
        }
    }

    public int reactTagForTouch(float f10, float f11) {
        int i10;
        CharSequence text = getText();
        int id2 = getId();
        int i11 = (int) f10;
        int i12 = (int) f11;
        Layout layout = getLayout();
        if (layout == null) {
            return id2;
        }
        int lineForVertical = layout.getLineForVertical(i12);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i11 >= lineLeft && i11 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i11);
                f[] fVarArr = (f[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, f.class);
                if (fVarArr != null) {
                    int length = text.length();
                    for (int i13 = 0; i13 < fVarArr.length; i13++) {
                        int spanStart = spanned.getSpanStart(fVarArr[i13]);
                        int spanEnd = spanned.getSpanEnd(fVarArr[i13]);
                        if (spanEnd >= offsetForHorizontal && (i10 = spanEnd - spanStart) <= length) {
                            id2 = fVarArr[i13].a();
                            length = i10;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e10) {
                z2.a.j("ReactNative", "Crash in HorizontalMeasurementProvider: " + e10.getMessage());
            }
        }
        return id2;
    }

    public void setAdjustFontSizeToFit(boolean z10) {
        this.f4194d = z10;
    }

    public void setBackgroundColor(int i10) {
        this.C.e(i10);
    }

    public void setBorderRadius(float f10) {
        this.C.g(f10);
    }

    public void setBorderStyle(@Nullable String str) {
        this.C.i(str);
    }

    public void setBreakStrategy(int i10) {
        super.setBreakStrategy(i10);
        this.f4201w = true;
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.f4193c = truncateAt;
    }

    public void setFontSize(float f10) {
        double ceil;
        if (this.f4194d) {
            ceil = Math.ceil((double) g0.f(f10));
        } else {
            ceil = Math.ceil((double) g0.d(f10));
        }
        this.f4195e = (float) ceil;
        a();
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i10) {
        if (i10 == 0) {
            i10 = GravityCompat.START;
        }
        setGravity(i10 | (getGravity() & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i10) {
        if (i10 == 0) {
            i10 = 48;
        }
        setGravity(i10 | (getGravity() & -113));
    }

    public void setHyphenationFrequency(int i10) {
        super.setHyphenationFrequency(i10);
        this.f4201w = true;
    }

    public void setIncludeFontPadding(boolean z10) {
        super.setIncludeFontPadding(z10);
        this.f4201w = true;
    }

    public void setLetterSpacing(float f10) {
        if (!Float.isNaN(f10)) {
            this.f4197g = g0.d(f10) / this.f4195e;
            a();
        }
    }

    public void setLinkifyMask(int i10) {
        this.f4198h = i10;
    }

    public void setMinimumFontSize(float f10) {
        this.f4196f = f10;
        this.f4201w = true;
    }

    public void setNotifyOnInlineViewLayout(boolean z10) {
        this.f4199i = z10;
    }

    public void setNumberOfLines(int i10) {
        if (i10 == 0) {
            i10 = Integer.MAX_VALUE;
        }
        this.f4192b = i10;
        setMaxLines(i10);
        this.f4201w = true;
    }

    public void setOverflow(@Nullable String str) {
        this.C.k(str);
    }

    public void setSpanned(Spannable spannable) {
        this.N0 = spannable;
        this.f4201w = true;
    }

    public void setText(i iVar) {
        this.f4191a = iVar.b();
        if (getLayoutParams() == null) {
            setLayoutParams(O0);
        }
        Spannable i10 = iVar.i();
        int i11 = this.f4198h;
        if (i11 > 0) {
            Linkify.addLinks(i10, i11);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(i10);
        float f10 = iVar.f();
        float h10 = iVar.h();
        float g10 = iVar.g();
        float e10 = iVar.e();
        if (!(f10 == -1.0f || h10 == -1.0f || g10 == -1.0f || e10 == -1.0f)) {
            setPadding((int) Math.floor((double) f10), (int) Math.floor((double) h10), (int) Math.floor((double) g10), (int) Math.floor((double) e10));
        }
        int j10 = iVar.j();
        if (j10 != getGravityHorizontal()) {
            setGravityHorizontal(j10);
        }
        if (getBreakStrategy() != iVar.k()) {
            setBreakStrategy(iVar.k());
        }
        if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != iVar.d()) {
            setJustificationMode(iVar.d());
        }
        requestLayout();
    }

    public void setTextIsSelectable(boolean z10) {
        this.f4200j = z10;
        super.setTextIsSelectable(z10);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.f4191a && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (i a10 : (i[]) spanned.getSpans(0, spanned.length(), i.class)) {
                if (a10.a() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}
